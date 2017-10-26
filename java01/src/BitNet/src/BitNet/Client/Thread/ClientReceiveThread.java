package BitNet.Client.Thread;

import java.io.DataInputStream;
import java.io.IOException;

import BitNet.Commons.AckPacket;

//Ŭ���̾�Ʈ�� ������ � ���� ��Ŷ�� �������� �м� �ؾ� �Ѵ�.
public class ClientReceiveThread extends Thread {

	DataInputStream dis = null;

	public ClientReceiveThread(DataInputStream dis) {
		this.dis = dis;
	}

	// Ŭ���̾�Ʈ�� ���� �����尡 �� ��
	// ������ ������ ���� ��Ŷ�� �м��� ó��
	// ex) ������ �޼��� �������� �޼��� ���
	// ������ ���� �������� ���� �ٿ�ε� ó��
	// ������ ���� ���ε� ��� �ϸ� ���� ���ε� ó��

	@Override
	public void run() {
		boolean isRunning = true;
		try
		{
			while(isRunning){
				int ACK_PACKET = dis.readInt();
				switch(ACK_PACKET){
				case AckPacket.ACK_MESSAGE:
					String msg = dis.readUTF();
					System.out.println(msg);
					break;
				case AckPacket.ACK_W:
					String says = dis.readUTF();
					System.out.println(says);
					break;
				}
			}
		}catch(IOException e){
			
		}finally{
			try {
				System.out.println("Ŭ���̾�Ʈ ���� ������ ����");
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
