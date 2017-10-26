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
		
		//HashMap이 필요한 이유
			//접속한 모든 클라이언트의 정보들을 저장 하기 위해 필요.
		HashMap<String, DataOutputStream> mHash = new HashMap<>();
		//클라이언트 대기
		//서버에서 -1 입력 시 서버를 종료...
		
		while(true){
			System.out.println("클라이언트 대기중..");
			Socket clientSocket = sSock.accept();
			//클라이언트 접속 시 접속한 클라이언트의 쓰레드 생성
				// => 클라이언트마다 동시에 메세지를 수신 하기 위해
			System.out.println("클라이언트 접속");
			
			ServerReceiveThread srt = new ServerReceiveThread(clientSocket, mHash);
			srt.start();
		}
	}
}
