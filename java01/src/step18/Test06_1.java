/* 파일 전송 프로그램 -  Echo 서버 만들기
 */
package step18;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test06_1 {
  static class EchoThread extends Thread {
    Socket socket;
    public EchoThread(Socket socket) {
      this.socket = socket;
    }
    public void run() {
      try (
          Socket socket = this.socket;
          Scanner in = new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {
        String message = in.nextLine();
        out.println("[charm true real story]"+message);
        
      } catch (Exception e) {}
    }
  }
  public static void main(String[] args) throws Exception{
    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("서버 시행 중....");
    
    while (true) {
      new EchoThread(serverSocket.accept()).start();
      //클라이언트가 접속하길 기다리다가. 연결을 시켜준다... 무한루프.
    }

  }
}
