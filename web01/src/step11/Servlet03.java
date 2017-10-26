/* HttpServlet 추상 클래스 상속 받아 서블릿 만들기 2
 * => HttpServlet 추상 클래스에 추가한 service() 메서드 오버라이딩
 *      Servlet.service(ServletRequest, ServletResponse)
 *          -> Servlet.service(HttpServletRequest req, HttpServletResponse res)
 *                -> doGet()
 *                -> doPost()
 *                -> doHead()
 *                -> doTrace()
 *                -> doDelete()
 *                      
 */
package step11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/step11/Servlet03")
public class Servlet03 extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println(req.getMethod());
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println(req.getMethod());
  }
}
