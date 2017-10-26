/* 소켓 프로그래밍 : connectionless 서버 만들기
 * => 서비스를 요청할 때 마다 연결하고, 요청 처리가 끝나면 연결을 끊는다.
 * => 장점
 *      계속 연결된 상태가 아니기 때문에,
 *         - 요청할 때만 일시적으로 연결되어 작업을 수행한다.
 *         - 보다 많은 클라이언트의 요청을 처리할 수 있다.
 * => 단점
 *      계속 연결된 상태가 아니기 때문에,
 *         - 요청할 때 마다 연결하기 때문에 네트워크 오버헤드가 발생한다.
 *         - 클라이언트의 연결을 지속해서 관리할 수 없다.
 *         
 * => 대표적인 프로토콜: HTTP, 메신저 등
 */
package step18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

public class Test07_2 {
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
          String json = in.readLine();
          if (json == null)
            return;
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
           */
          // 클라이언트가 요청할 때마다 이 객체가 만들어지기 때문에 
          // count 변수는 영원히 0이다
          // 그래서 같은 클라이언트가 몇 번 요청했는지 알 수 없다.
          if (++count > 5) { 
            out.println("무료 사용 끝!");
          } else {
            out.println(result);
          }
          out.flush();
            
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
    Test07_2 server = new Test07_2();
    server.listen(8888);
    
    

  }
}
