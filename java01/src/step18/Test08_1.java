/* 소켓 프로그래밍 : 채팅 서버 만들기 - v1
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test08_1 {
  
  class ChatJob implements Runnable {
    Socket socket;
    public ChatJob(Socket socket) {
      this.socket = socket;
    }
    @Override
    public void run() {
      try (
          Socket socket = this.socket;
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {
        String alias = in.readLine();
        out.printf("[%s]님이 입장하였습니다\n", alias);
        while (true) {
          String message = in.readLine();
          if (message == null)//클라이언트에서 종료 신호를 보내면
            break; // 끝낸다
          
       
          out.println(message);
          out.flush();
            
        }
        System.out.println("=> 클라이언트와 연결 끊김");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
  }
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
     new Thread(new ChatJob(serverSocket.accept())).start();
    }
  }
  public static void main(String[] args) throws Exception{
    Test08_1 server = new Test08_1();
    server.listen(8888);
    
    

  }
}
