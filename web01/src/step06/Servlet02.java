/* 서블릿 끼리 값을 공유하는 방법: ServletRequest 보관소 사용하기
 * => 저장소를 이용하여 값을 공유할 수 있다.
 * 1) ServletContext
 *    - 웹 애플리케이션 당 1개 존재
 *    - 웹 애플리케이션이 시작할 때 ServletContext 객체가 생성되고,
 *      웹 애플리케이션이 종료할 때 ServletContext
 * 2) HttpSession
 *    - 클라이언트 당 1개 존재
 *    - 서버에 방문하면 서버로 부터 세션ID를 발급 받는다.
 *      세션 ID당 한 개의 HttpSession 객체가 존재한다.
 * 3) ServletRequest
 *    - 요청 때마다 생성되고 응답 후 제거됨
 *    - 포워드, 인클루드인 경우 ServletRequest를 공유하기 때문에
 *      포워드, 인클루드 하는 서블릿마다 ServletRequest를 만들지 않는다.
 * 4) PageContext
 *    - JSP을 실행할 때 마다 실행되고 실행된 후 제거됨.
 */
package step06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.RepaintManager;

@WebServlet(urlPatterns="/step06/Servlet02")
public class Servlet02 extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    String value = (String) req.getAttribute("v1");
    
   res.setContentType("text/plain;charset=UTF-8");
   PrintWriter out = res.getWriter();
   out.println(value);


    
    
    
  }
}
