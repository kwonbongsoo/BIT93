/* 소켓 프로그래밍 : connectionful 서버 만들기
 * => 한 번 서버와 연결되면 명시적으로 연결이 끊을 떄 까지 데이터를 주고 받는 방법
 * => 장점
 *      - 계속 연결된 상태로 있기 때문에,
 *         바로 데이터를 주고 받을 수 있어 편리하다.
 *      - 작업 상태를 계속 유지할 수 있다.
 * => 단점
 *      계속 연결된 상태로 있기 때문에,
 *          - 사용 중이지 않을 때도 연결을 유지한다. 메모리 낭비!
 *          - 많은 클라이언트의 요청을 처리할 수 없다.
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test07_1 {
  class Value {
    int v1;
    int v2;
    String op;
  }
  
  class CalculatorJob implements Runnable {
    Socket socket;
    public CalculatorJob(Socket socket) {
      this.socket = socket;
    }
    @Override
    public void run() {
      int count = 0;
      try (
          Socket socket = this.socket;
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {
        while (true) {
          String json = in.readLine();
          if (json == null)
            break;
          System.out.println(json);
          
          //Gson 객체를 이용해 JSON 문자열을 Value 객체로 만든다.
          // => Gson 라이브러리 추가
          //    1) build.gradle에 repositories {}, dependencies {} 블록추가
          //    2) 명령창에서 "gradle eclipse"를 실행하여 이클립스 설정 파일 갱신
          //    3) 이클립스에서 프로젝트 "represh" 할것
          Gson gson = new Gson();
          Value value = gson.fromJson(json, Value.class);
          
          float result = 0f;
          switch (value.op) {
          case "+": result = (float)value.v1 + value.v2; break;
          case "-" : result = (float)value.v1 - value.v2; break;
          case "*" : result = (float)value.v1 * value.v2; break;
          case "/" : result = (float)value.v1 / value.v2; break;
          case "%" : result = (float)value.v1 % value.v2; break;
          }
          
          /* connectionful
           *  => 커넥션풀 방식에서는 클라리언트와 연결된 후 count 변수 처럼 그 클라이언트의 상태를 관리할 수 있다.
           *  => 단점:
           *      1) 클라이언트가 연결을 끊을 때까지 그 상태 값을 유지해야 하기 때문에
           *       메모리 낭비가 발생하고,
           *     2)  보다 많은 클라이언트의 요청을 처리할 수 없다.
           *     3)  그리고 클라이언트가 서버를 사용하지 않더라도,
           *       연결을 끊지 않는 한 계속 클라이언트의 정보를 유지해야 하는
           *       문제가 발생한다.
           *       
           *       
           *        => 대표적인 프로토콜: Telnet, FTP,  채팅 등
           */
          if (++count > 5) {
            out.println("무료 사용 끝!");
          } else {
            out.println(result);
          }
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
     new Thread(new CalculatorJob(serverSocket.accept())).start();
    }
  }
  public static void main(String[] args) throws Exception{
    Test07_1 server = new Test07_1();
    server.listen(8888);
    
    

  }
}
