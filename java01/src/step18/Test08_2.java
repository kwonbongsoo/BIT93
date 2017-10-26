/* 소켓 프로그래밍 : 채팅 서버 만들기 - v2
 * => 다른 ChatJob들의 연락처를 구축하여 공유한다.
 * => 이렇게 구축된 연락처는 
 *      
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Test08_2 {
  ArrayList<ChatJob> chatJobs = new ArrayList<>();
  
  
  
  public void listen(int port) throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");
    
    while (true) {
     new Thread(new ChatJob(serverSocket.accept())).start();
    }
  }
  // 먼저 요청한 스레드 순서대로 작업을 실행시킨다. 뮤텍스
  synchronized public void sendAll(String message) {

      for (int i = chatJobs.size() -1; i >= 0; i--) {
        try {
          chatJobs.get(i).send(message);
        } catch (Exception e) {
          chatJobs.remove(i);
        }
      }
  }
  public static void main(String[] args) throws Exception{
    Test08_2 server = new Test08_2();
    server.listen(8888);
    
  }
  
  class ChatJob implements Runnable {
    Socket socket;
    PrintStream out;
    String address;
    public ChatJob(Socket socket) {
      this.socket = socket;
      chatJobs.add(this);
      this.address =((InetSocketAddress)socket.getRemoteSocketAddress()).getHostString();
    }
    @Override
    public void run() {
      try (
          Socket socket = this.socket;
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {
        this.out = out;
        String alias = in.readLine();
        sendAll(String.format("[%s]님이 입장하였습니다",alias));
        
        
        while (true) {
          String message = in.readLine();
          if (message == null)//클라이언트에서 종료 신호를 보내면
            break; // 끝낸다
          sendAll(String.format("[%s: %s]: %s",alias, this.address ,message));

            
        }
        System.out.println("=> 클라이언트와 연결 끊김");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    public void send(String message) {
      try {
        out.println(message);
      }catch (Exception e) {
        chatJobs.remove(this);
      }
    }
  }
}
