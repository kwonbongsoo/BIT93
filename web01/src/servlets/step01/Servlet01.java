/* 웹 애플리케이션 컴포넌트 : 서블릿 만들기 1 - Servlet 인터페이스 만들기
 * => 웹 애플리케이션을 구성하고 있는 구성 요소를 말한다.
 * 1) 서블릿
 *    - 클라이언트의 요청을 처리한다. 
 * 2) 필터
 *    - 서블릿을 실행하기 전이나 후에 작업을 수행한다.
 * 3) 리스너
 *    - 서블릿 컨테이너의 특정 상황에서 작업하는 객체
 *    - 그 객체를 "리스너(listener)"라 부른다.
 *    
 *    
 * 서블릿 만들기
 * 1) javax.servlet.Servlet 인터페이스를 구현하는 방법
 * 2) javax.servlet.GenericServlet 클래스를 상속 받는 방법
 * 3) javax.servlet.http.HttpServlet 클래스를 상속 받는 방법.
 * 
 * 
 * 서블릿을 실행하려면 서블릿 컨테이너에 등록해야 한다.
 * 1) web.xml(DD file)에 서블릿 정보를 등록해야 한다.
 *    예) HelloServlet 클래스
 * 2) @WebServlet 애노테이션을 붙이는 방법
 *    예) 
 * 
 */
package servlets.step01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/servlets/step01/Servlet01")
public class Servlet01 implements Servlet{
  
  
  public Servlet01() {
   System.out.println("Servlet01()");
  }
  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("init()");
    
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("getServletConifg()");
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println("Servlet01.Service()");
    
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
