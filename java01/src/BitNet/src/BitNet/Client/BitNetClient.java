package BitNet.Client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import BitNet.Client.Thread.ClientReceiveThread;
import BitNet.Commons.AckPacket;
import BitNet.Commons.Constants;
import BitNet.Commons.ReqPacket;

public class BitNetClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//서버에 접속
		Socket sSock = new Socket(Constants.IP, Constants.PORT);
		DataOutputStream dos = new DataOutputStream(sSock.getOutputStream());
		DataInputStream dis = new DataInputStream(sSock.getInputStream());
		Scanner scan = new Scanner(System.in);
		
		System.out.print("접속 성공! 닉네임을 입력하세요 >> ");
		String nickname = scan.nextLine();
		
		//1) 닉네임을 보내겠다고 서버에게 알린다.(패킷 전송)
		dos.writeInt(ReqPacket.REQ_NICKNAME);
		//2) 실제 닉네임을 전송
		dos.writeUTF(nickname);
		boolean isJoin = false;
		
		//3) 닉네임을 전송 하고 대기
		int ACK_PACKET = dis.readInt();
		// 서버의 응답 패킷을 분석
		switch(ACK_PACKET){
		case AckPacket.ACK_NICKNAME_Y:
			System.out.println("대화방 참가 성공");
			isJoin = true;
			break;
		case AckPacket.ACK_NICKNAME_N:
			System.out.println("대화방 참가 실패");
			System.out.println("닉네임이 공백문자거나 중복된 닉네임 입니다.");
			break;
		}
		
		//성공적으로 대화방에 입장이 됐으면 송신, 수신 동시에 진행
		//1) ClientReceiveThread 생성
		//2) 메세지 보내는 무한루프 생성
		if(isJoin)
		{
			ClientReceiveThread crt = new ClientReceiveThread(dis);
			//종속적인 스레드를 만들기
			//이 스레드를 만든 곳이 종료가 되면 같이 종료가 됨..
			//자식스레드 만들기....
			crt.setDaemon(true);
			crt.start();
			
			boolean isRunning = true;
			while(isRunning){
				
				System.out.print("[입력]>> ");
				String msg = scan.nextLine();
				
				// /w 로 시작하는 문자열이 들어오면... 귓속말로 간주
				if(msg.startsWith("/w "))
				{
					msg = msg.substring(3);
					int spaceIndex = msg.indexOf(" ");
					String nick = msg.substring(0, spaceIndex);
					String wMsg = msg.substring(spaceIndex + 1);
					
					dos.writeInt(ReqPacket.REQ_W);
					dos.writeUTF(nick);
					dos.writeUTF(wMsg);
					
				}else if(msg.toLowerCase().equals("/upload")){
					dos.writeInt(ReqPacket.REQ_FILE_UPLOAD);
					
					System.out.print("파일명 입력 : ");
					String filename = scan.nextLine();
					dos.writeUTF(filename);
					
					File file = new File(filename);
					//파일 크기 전송
					dos.writeLong(file.length());
					
					FileInputStream fis = new FileInputStream(file);
					BufferedInputStream bis = new BufferedInputStream(fis);
					
					byte []buffer = new byte[2048];
					
					int readCnt;
					long fileSize = file.length();
					int remainSize = (int)fileSize;
					int totalCnt = 0;
							
					while((readCnt = bis.read(buffer, 0, 
							remainSize > buffer.length ? buffer.length : remainSize)) != 0){
						
						remainSize -= readCnt;
						totalCnt += readCnt;
						dos.write(buffer);
						System.out.println(totalCnt + "/" + fileSize);
						
					}
					bis.close();
				}else{
					dos.writeInt(ReqPacket.REQ_MESSAGE);
					dos.writeUTF(msg);
					
					if(msg.equals("quit")){
						isRunning = false;
						System.out.println("쓰레드 종료");
						//쓰레드 강제 종료..
						//crt.interrupt();
						
						
					}
				}
			}
		}
		dos.close();
		scan.close();
		sSock.close();
	}
}
