package BitNet.Server.Thread;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import BitNet.Commons.AckPacket;
import BitNet.Commons.ReqPacket;

public class ServerReceiveThread extends Thread{

	Socket cSock = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	HashMap<String, DataOutputStream> mHash = null;
	
	String NICKNAME = "";
	
	public ServerReceiveThread(Socket cSock, HashMap<String, DataOutputStream> mHash) {
		// TODO Auto-generated constructor stub
		this.cSock = cSock;
		this.mHash = mHash;
	}
	
	@Override
	public void run() {
		
		//1) 클라이언트 접속 되면 클라이언트가 닉네임을 입력 할 때 까지 대기
		//2) 정상적으로 닉네임이 들어오면 HashMap에 닉네임과 DataOutputStream 추가
		
			//오류상황 1. 클라이언트가 닉네임을 입력 하지 않거나 공백만 입력 했을 경우
			//오류상황 2. 중복된 닉네임이 있는 경우...
		
		//PACKET 이용...
		//모든 클라이언트의 요청은 패킷에따라 처리
		try
		{
			//클라이언트로 부터 데이터를 수신할 DataInputStream
			this.dis = new DataInputStream(cSock.getInputStream());
			
			//클라이언트에게 데이터를 송신할 DataOutputStream
			this.dos = new DataOutputStream(cSock.getOutputStream());
			
			boolean isRunning = true;
			
			while(isRunning)
			{
				//클라이언트가 보내는 패킷을 대기
				int REQ_PACKET = dis.readInt();
				//클라이언트가 보낸 패킷을 분석
				switch(REQ_PACKET){
				case ReqPacket.REQ_NICKNAME:
					NICKNAME = dis.readUTF();
					System.out.println("[[클라이언트의 닉네임 : " + NICKNAME+"]]");
					//에러가 나는 경우를 대비(잘못된 닉네임)
					//trim() => 앞뒤 공백을 제거
					//오류 상황... 닉네임이 그냥 공백문자거나 				중복된 닉네임일 경우..
					if(NICKNAME.trim().equals("") || mHash.get(NICKNAME) != null){
						//클라이언트에게 에러났다고 알려줌..
						System.out.println("[[Server]] 닉네임 중복 또는 공백문자 입력됨");
						dos.writeInt(AckPacket.ACK_NICKNAME_N);
						isRunning = false;
					}else{
						//적절한 닉네임이 들어왔을 경우..
						System.out.println("[[Server]] 적절한 닉네임이 입력됨");
						dos.writeInt(AckPacket.ACK_NICKNAME_Y);
						mHash.put(NICKNAME, dos);
						sendBroadCast("["+NICKNAME+"] " + "님 접속함");
					}
					break;
				case ReqPacket.REQ_MESSAGE:
					String msg = dis.readUTF();
					System.out.println("["+NICKNAME+"] " + msg);
					sendBroadCast("["+NICKNAME+"] " + msg);
					break;
				case ReqPacket.REQ_W:
					String nick = dis.readUTF();
					String says = dis.readUTF();
					
					DataOutputStream wDos = mHash.get(nick);
					if(wDos != null)
					{
						System.out.println(NICKNAME+" => "+nick+" " + says);
						wDos.writeInt(AckPacket.ACK_W);
						wDos.writeUTF(NICKNAME+"님으로 부터 귓말 : " + says);
					}
					break;
				case ReqPacket.REQ_FILE_UPLOAD:
					//파일 수신 준비
					//파일 이름 수신 대기
					
					//1) 파일명
					//2) 파일 크기
					String filename = dis.readUTF();
					long filesize = dis.readLong();
					
					File file = new File(filename);
					file.createNewFile();

					FileOutputStream fos = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					
					byte []buffer = new byte[2048];
					
					//파일 사이즈 수신
					int readCnt;
					int remainSize = (int)filesize;
					
					int totalCnt = 0;
					
					while((readCnt = dis.read(buffer, 0, 
							remainSize > buffer.length ? buffer.length : remainSize)) != 0){
						
						remainSize -= readCnt;
						totalCnt += readCnt;
						bos.write(buffer, 0, readCnt);
						System.out.println(totalCnt + "/" + filesize);
					}
					
					System.out.println("파일 수신 성공!");
					bos.close();
					
					break;
				}
			}
		}catch(IOException e){
			System.out.println("Client Err");
			System.out.println(e.getMessage());
		}finally {
			try
			{
				if(dis != null){ dis.close();}
				if(dos != null){ dos.close();}
				if(cSock != null){ cSock.close();}
				if(mHash.get(NICKNAME) != null) { mHash.remove(NICKNAME); }
			}catch(IOException e){
				System.out.println(e.getMessage() + "<<<CLOSE FAILED>>>");
			}
		}
	}
	
	private void sendBroadCast(String msg) throws IOException{
		//HashMap 안쪽에 있는 nickname Set만 불러와서
		Set<String> keys =  mHash.keySet();
		//반복자 설정
		Iterator<String> keyIterator = keys.iterator();
		
		//더이상 반복할 곳이 없을 때 까지
		while(keyIterator.hasNext()){
			//키를 하나씩 얻어옴..
			String key = keyIterator.next();
			//얻어온 키값을 mHash에 대입하여 DataOutputStream(값)을 얻어옴..
			DataOutputStream tempDos = mHash.get(key);
			
			//클라이언트에게 메세지 응답 패킷 전송
			tempDos.writeInt(AckPacket.ACK_MESSAGE);
			
			//얻어온 DataOutputStream에 메세지를 writeUTF
			tempDos.writeUTF(msg);
		}
	}
}
