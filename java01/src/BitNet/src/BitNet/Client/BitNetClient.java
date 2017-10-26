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
		//������ ����
		Socket sSock = new Socket(Constants.IP, Constants.PORT);
		DataOutputStream dos = new DataOutputStream(sSock.getOutputStream());
		DataInputStream dis = new DataInputStream(sSock.getInputStream());
		Scanner scan = new Scanner(System.in);
		
		System.out.print("���� ����! �г����� �Է��ϼ��� >> ");
		String nickname = scan.nextLine();
		
		//1) �г����� �����ڴٰ� �������� �˸���.(��Ŷ ����)
		dos.writeInt(ReqPacket.REQ_NICKNAME);
		//2) ���� �г����� ����
		dos.writeUTF(nickname);
		boolean isJoin = false;
		
		//3) �г����� ���� �ϰ� ���
		int ACK_PACKET = dis.readInt();
		// ������ ���� ��Ŷ�� �м�
		switch(ACK_PACKET){
		case AckPacket.ACK_NICKNAME_Y:
			System.out.println("��ȭ�� ���� ����");
			isJoin = true;
			break;
		case AckPacket.ACK_NICKNAME_N:
			System.out.println("��ȭ�� ���� ����");
			System.out.println("�г����� ���鹮�ڰų� �ߺ��� �г��� �Դϴ�.");
			break;
		}
		
		//���������� ��ȭ�濡 ������ ������ �۽�, ���� ���ÿ� ����
		//1) ClientReceiveThread ����
		//2) �޼��� ������ ���ѷ��� ����
		if(isJoin)
		{
			ClientReceiveThread crt = new ClientReceiveThread(dis);
			//�������� �����带 �����
			//�� �����带 ���� ���� ���ᰡ �Ǹ� ���� ���ᰡ ��..
			//�ڽĽ����� �����....
			crt.setDaemon(true);
			crt.start();
			
			boolean isRunning = true;
			while(isRunning){
				
				System.out.print("[�Է�]>> ");
				String msg = scan.nextLine();
				
				// /w �� �����ϴ� ���ڿ��� ������... �ӼӸ��� ����
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
					
					System.out.print("���ϸ� �Է� : ");
					String filename = scan.nextLine();
					dos.writeUTF(filename);
					
					File file = new File(filename);
					//���� ũ�� ����
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
						System.out.println("������ ����");
						//������ ���� ����..
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
