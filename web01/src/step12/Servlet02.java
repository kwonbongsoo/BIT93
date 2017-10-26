
package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/step12/Servlet02")
public class Servlet02 extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /* 쿠키 보내기 2
   * => \   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    Cookie cookie = new Cookie("c2", "bbbbbb");
    cookie.setPath(req.getContextPath()); // getContextPath() ---> "/web01"
    
    
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet02: 쿠키 보냈음.");
  }
}


/* URL 인코딩?
 * HTTP/1.1 200
   Set-Cookie: c2=bbbbbb; Path=/web01
   Content-Type: text/plain;charset=UTF-8
   Content-Length: 30
   Date: Mon, 12 Jun 2017 05:12:12 GMT
 */