/* 웹 애플리케이션에서 사용할 자원을 준비하는 방법 : 서블릿을 이용하기
 * => 클라이언트가 요청하지 않아도 웹 애플리케이션이 시작 될때 
 *      서블릿 객체를 자동 생성하는 방법?
 *      1) web.xml
 *        <servlet>
 *          <servlet-name>...</servlet-name>
 *          <servlet-class>...</servlet-class>
 *          <load-on-startup>1</load-on-startup>
 *        </servlet>
 *        2) @WebServlet 애노테이션에 설정하는 방법
 *            @WebServlet (
 *                urlPatterns="...",
 *                loadStartup=1)
 * => <load-on-startup> 또는 loadOnStartup?
 *       - 웹 애플리케이션이 시작될 때 자동으로 생성될 서블릿을 지정하는 방법이다
 *       - 숫자는 생성되는 순서이다. 작은 값의 서블릿 부터 먼저 생성된다.
 *       - 같은 값이 여러 개면 먼저 나온 순서대로 서블릿을 생성한다.
 *       - 이 태그나 속성이 붙지 않은 서블릿은 자동으로 생성되지 않는다.
 *         반드시 클라이언트의 요청이 있어야만 생성된다.
 *         
 * => 자동 생성되는 서블릿의 경우 
 *      보통 직접 클라이언트에게 뭔가를 서비스하기 위해 만든 서블릿이 아니다.
 *      그래서 가능한 클라이언트가 직접 요청하지 못하도록 막아야 한다.
 *      방법은?
 *      URL을 지정하지 않는것이다.
 */
package step08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup=1)
public class Servlet02 extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    // Servlet 인터페이스의 init(ServletConfig) 메서드 대신에
    // 이 메서드 오버라이딩 하라고 GenericServlet 클래스에서 제공해 준다.
    // 개발자는 서블릿이 생성될 때 뭔가를 준비시키고 싶다면,
    // 오리지널 init(ServletConfig) 대신 이 메서드를 오버라이딩 하여 코드를 작성해라!
    System.out.println("==============> step08.Servlet.init()");
    ServletContext sc = this.getServletContext();
    sc.setAttribute("v2", "hi");
  }
  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    // 클라이언트가 요청할 때 마다 자원을 준비하는 것이 아니기 때문에
    // 이 메서드가 호출될 때 특별히 뭔가 작업할 필요가 없다.
    System.out.println("===============> step08.Servlet.service()");
  }
}
