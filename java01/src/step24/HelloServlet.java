/* 서블릿 만들기
 * 1) 서블릿을 만드는 데 필요한  라이브러리를 가져온다.
 *      -> mvnrepository.com 에서 "servlet-api"를 검색한다.
 *      -> 3.1.x 버전의 gradle 라이브러리 정보를 복사한다.
 *      -> build.gradle 파일의 dependencies {} 블록에 추가한다.
 *      -> 터미널에서 "gradle eclipse" 를 실행하여 이클립스 
 *          설정 파일을 (.classpath, .project) 갱신한다.
 *      -> 이클립스 설정 파일을 갱신하였다면,
 *          프로젝트를 "Refresh" 해야한다.
 *          
 *          
 * 2) javax.serlet.Servlet 규칙에 따라 클래스를 작성한다.
 * 
 * 서블릿 배포하기
 * 1) 톰켓 서버에 웹 애플리케이션 폴더를 만든다.
 *      => $톰켓홈/webapps/test/
 * 2) 클래스 파일을 배치한다.
 *      => $톰캣홈/webapps/test/WEB-INF/classes/step24/HelloServlet.class
 * 3) 서블릿 정보를 DD 파일에 등록한다.
 *      => $톰캣홈/webapps/test/WEB-INF/web.xml
 *      => $톰캣홈/webapps/ROOT/WEB-INF/web.xml를 복사하여 사용한다.
 *           다음과 같이 편집한다.
 *           
 * 
 * ----------------------------------------------------------------------------------------------------
 * 
 *   <display-name>Welcome to Tomcat</display-name>
  <description>
     Welcome to Tomcat
  </description>
  
<!-- HelloServlet에 URL을 부여한다. -->
  <servlet>
    <servlet-name>hello</servlet-name>
    <servlet-class>step24.HelloServlet</servlet-class>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>hello</servlet-name>
    <url-pattern>/hi</url-pattern>
  </servlet-mapping>

</web-app>
 * -----------------------------------------------------------------------------------
 * 
 * 서블릿 실행
 * 1) 톰캣 서버를 실행한다.
 * 2) 웹브라우저로 다음 URL을 요청한다.
 *     http://localhost:8080/test/hi
 */
package step24;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet implements Servlet {

  public HelloServlet() {
    System.out.println("HelloServlet()");
  }
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConfig()"); 
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("service()");
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println("Hello world!");
    
  }

  @Override
  public String getServletInfo() {
     System.out.println("getServletInfo()");
    return null;
  }

  @Override
  public void destroy() {
    System.out.println("destroy()");
    
  }
  
}
