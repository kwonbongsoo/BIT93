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
		
		//1) Ŭ���̾�Ʈ ���� �Ǹ� Ŭ���̾�Ʈ�� �г����� �Է� �� �� ���� ���
		//2) ���������� �г����� ������ HashMap�� �г��Ӱ� DataOutputStream �߰�
		
			//������Ȳ 1. Ŭ���̾�Ʈ�� �г����� �Է� ���� �ʰų� ���鸸 �Է� ���� ���
			//������Ȳ 2. �ߺ��� �г����� �ִ� ���...
		
		//PACKET �̿�...
		//��� Ŭ���̾�Ʈ�� ��û�� ��Ŷ������ ó��
		try
		{
			//Ŭ���̾�Ʈ�� ���� �����͸� ������ DataInputStream
			this.dis = new DataInputStream(cSock.getInputStream());
			
			//Ŭ���̾�Ʈ���� �����͸� �۽��� DataOutputStream
			this.dos = new DataOutputStream(cSock.getOutputStream());
			
			boolean isRunning = true;
			
			while(isRunning)
			{
				//Ŭ���̾�Ʈ�� ������ ��Ŷ�� ���
				int REQ_PACKET = dis.readInt();
				//Ŭ���̾�Ʈ�� ���� ��Ŷ�� �м�
				switch(REQ_PACKET){
				case ReqPacket.REQ_NICKNAME:
					NICKNAME = dis.readUTF();
					System.out.println("[[Ŭ���̾�Ʈ�� �г��� : " + NICKNAME+"]]");
					//������ ���� ��츦 ���(�߸��� �г���)
					//trim() => �յ� ������ ����
					//���� ��Ȳ... �г����� �׳� ���鹮�ڰų� 				�ߺ��� �г����� ���..
					if(NICKNAME.trim().equals("") || mHash.get(NICKNAME) != null){
						//Ŭ���̾�Ʈ���� �������ٰ� �˷���..
						System.out.println("[[Server]] �г��� �ߺ� �Ǵ� ���鹮�� �Էµ�");
						dos.writeInt(AckPacket.ACK_NICKNAME_N);
						isRunning = false;
					}else{
						//������ �г����� ������ ���..
						System.out.println("[[Server]] ������ �г����� �Էµ�");
						dos.writeInt(AckPacket.ACK_NICKNAME_Y);
						mHash.put(NICKNAME, dos);
						sendBroadCast("["+NICKNAME+"] " + "�� ������");
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
						wDos.writeUTF(NICKNAME+"������ ���� �Ӹ� : " + says);
					}
					break;
				case ReqPacket.REQ_FILE_UPLOAD:
					//���� ���� �غ�
					//���� �̸� ���� ���
					
					//1) ���ϸ�
					//2) ���� ũ��
					String filename = dis.readUTF();
					long filesize = dis.readLong();
					
					File file = new File(filename);
					file.createNewFile();

					FileOutputStream fos = new FileOutputStream(file);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					
					byte []buffer = new byte[2048];
					
					//���� ������ ����
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
					
					System.out.println("���� ���� ����!");
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
		//HashMap ���ʿ� �ִ� nickname Set�� �ҷ��ͼ�
		Set<String> keys =  mHash.keySet();
		//�ݺ��� ����
		Iterator<String> keyIterator = keys.iterator();
		
		//���̻� �ݺ��� ���� ���� �� ����
		while(keyIterator.hasNext()){
			//Ű�� �ϳ��� ����..
			String key = keyIterator.next();
			//���� Ű���� mHash�� �����Ͽ� DataOutputStream(��)�� ����..
			DataOutputStream tempDos = mHash.get(key);
			
			//Ŭ���̾�Ʈ���� �޼��� ���� ��Ŷ ����
			tempDos.writeInt(AckPacket.ACK_MESSAGE);
			
			//���� DataOutputStream�� �޼����� writeUTF
			tempDos.writeUTF(msg);
		}
	}
}
