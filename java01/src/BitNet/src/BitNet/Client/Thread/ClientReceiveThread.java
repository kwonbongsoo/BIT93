package BitNet.Client.Thread;

import java.io.DataInputStream;
import java.io.IOException;

import BitNet.Commons.AckPacket;

//클라이언트는 서버가 어떤 응답 패킷을 보내는지 분석 해야 한다.
public class ClientReceiveThread extends Thread {

	DataInputStream dis = null;

	public ClientReceiveThread(DataInputStream dis) {
		this.dis = dis;
	}

	// 클라이언트의 수신 스레드가 할 일
	// 서버가 보내는 응답 패킷을 분석후 처리
	// ex) 서버가 메세지 보냈으면 메세지 출력
	// 서버가 파일 보냈으면 파일 다운로드 처리
	// 서버가 파일 업로드 허락 하면 파일 업로드 처리

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
				System.out.println("클라이언트 수신 스레드 종료");
				dis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
