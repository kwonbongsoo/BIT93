/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리
 * 3) HttpProcessor 클래스 패키지 멤버 클래스로 분리
 * 4) command 패턴적용
 *      - 메서드를 객체화시키는 설계 기법.
 *      - 한 개의 메서드를 한 개의 클래스로 정의하는 방식을 말한다.
 *      - 이런 방식은 기능을 추가할때 마다 메서드를 메서드를 추가해야하는 경우에 사용한다.
 *        메서드를 추가하는 것 보다 클래스를 추가하는 방식이 유지보수에 더 좋기 때문이다.
 *      - 작업
 *      1. 호출자(HttpProcessor)와 호출당하는자(요청처리객체) 사이의 호출 규칙을 정의한다.
 *          => Command 인터페이스 정의
 *      2. 메서드를 추출하여 Command 규칙에 따라 클래스를 만든다.
 *          => HelloServlet, OkServlet, ErrorServlet 클래스 작성 
 *      3. HttpServer에서 맵에 커맨드 객체를 보관한다.
 *      4. HttpProcessor는 HttpServer에 제공해준 맵 객체에서 
 *         URL을 처리하는 커맨드 객체를 찾아 호출한다.
 *         
 *  5) 서브릿 객체 생성 자동화
 *      - 서블릿 클래스를 추가할 때 마다 HttpServer 클래스를 변경해야 한다.
 *      - 이 문제를 해결하기 위한 방안?
 *      URL과 그 URL을 처리할 객체를 별도의 외부 파일에 둔다.
 *      서버를 시작할 때 이 파일을 읽어 객체를 준비한다.
 *      - 작업
 *        1. URL과 그 URL 요청을 처리할 클래스 이름을 외부 파일에 저장한다.
 *           web.properties 
 *        2. HttpServer를 시작하면 web.properties 파일을 로딩한다.
 *        3. web.properties에 지정된 클래스를 로딩하고 그 객체를 만들어 맵에 보관한다.
 *        - 문제점.
 */
package step23.ex11;

import java.io.FileReader;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HttpServer {
  int port;
  Map<String, Command> servletMap = new HashMap<>();
  // 클라이언트 요청을 처리할 객체를 담는다.
  
  public HttpServer(int port) throws Exception{
    this.port = port;
    
    Properties props = new Properties();
    // 이클립스에서 프로그램을 실행하면, 항상 현재 폴더는 프로젝트 폴더이다.
    props.load(new FileReader("src/step23/ex11/web.properties"));
    
    
    Set<String> urlSet = props.stringPropertyNames();
    for (String url : urlSet) {
      String classFullName = props.getProperty(url);
      Class clazz = Class.forName(classFullName); //클래스 로딩한 후 그 클래스를 다루는 도구
      servletMap.put(url, ((Command)clazz.newInstance()));
      // newInstance는 자동으로 객체를 생성하는 메소드 이다.
      // 어차피 hello error ok객체는 command 인터페이스를 이용하는객체이므로 커맨드로 형변환가능하다.
      // 그객체를 서블릿맵에 집어넣겠다는 뜻이다.
    }
  }
  
  public void listen() throws Exception {
    ServerSocket serverSocket = new ServerSocket(this.port);
    System.out.println("서버 실행중..");
    
    while(true) {
      new HttpProcessor(serverSocket.accept(), servletMap).start();
    }
  }
  
  public static void main(String[] args) throws Exception{
    HttpServer server = new HttpServer(8888);
    server.listen();
  }
}
