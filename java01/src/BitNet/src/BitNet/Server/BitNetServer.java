package BitNet.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import BitNet.Commons.Constants;
import BitNet.Server.Thread.ServerReceiveThread;

public class BitNetServer {
	public static void main(String[] args) throws IOException {
		ServerSocket sSock = new ServerSocket(Constants.PORT);
		
		//HashMap�� �ʿ��� ����
			//������ ��� Ŭ���̾�Ʈ�� �������� ���� �ϱ� ���� �ʿ�.
		HashMap<String, DataOutputStream> mHash = new HashMap<>();
		//Ŭ���̾�Ʈ ���
		//�������� -1 �Է� �� ������ ����...
		
		while(true){
			System.out.println("Ŭ���̾�Ʈ �����..");
			Socket clientSocket = sSock.accept();
			//Ŭ���̾�Ʈ ���� �� ������ Ŭ���̾�Ʈ�� ������ ����
				// => Ŭ���̾�Ʈ���� ���ÿ� �޼����� ���� �ϱ� ����
			System.out.println("Ŭ���̾�Ʈ ����");
			
			ServerReceiveThread srt = new ServerReceiveThread(clientSocket, mHash);
			srt.start();
		}
	}
}
