/* 웹 애플리케이션 실행하기
 * 1) 클라이언트가 요구하는 자원의 경로를 알아내기
 * 2) 클라이언트가 요청한 자원을 처리
 * 3) HttpProcessor 클래스 패키지 멤버 클래스로 분리
 * 4) command 패턴적용
 * 5) 서브릿 객체 생성 자동화
 * 6) 애노테이션을 적용하여 서블릿 객체 생성 자동화
 *      - 서블릿 클래스에 대해서 특별한 주석을 붙여 서블릿임을 표시한다
 *      - HttpServer는 서블릿임을 표시한 클래스를 찾아서 자동으로 생성하여 맵에 저장한다
 *      - 작업
 *       1. 클래스에 붙일 애노테이션 정의
 *          => WebServlet
 *       2. 각 서블릿 클래스에 WebServlet 애노테이션을 붙인다.
 *          => HelloServlet, OkServlet, ErrorServlet
 */
package step23.ex12;

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
    props.load(new FileReader("src/step23/ex12/web.properties"));
    
    
    Set<String> urlSet = props.stringPropertyNames();
    for (String url : urlSet) {
      String classFullName = props.getProperty(url);
      Class clazz = Class.forName(classFullName); //클래스 로딩한 후 그 클래스를 다루는 도구
      servletMap.put(url, ((Command)clazz.newInstance()));
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
