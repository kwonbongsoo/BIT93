
package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/step12/Servlet03")
public class Servlet03 extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /* 쿠키 보내기 3
   * => 사용 기간 지정하기
   *      사용 기간을 지정하지 않으면, 웹브라우저가 실행되는 동안만 보관된다.
   *      웹브라우저를 ** 모두 ** 닫으면 사용기간을 기간을 지정하지 않은 쿠키는 버려진다.  
   * => 사용기간을 지정하면,
   *     - 컴퓨터를 껏다 켜도 그 기간 동안 유지된다.
   *     - 웹브라우저는 보낼 쿠키를 검사할 때 사용 기간이 지난 쿠키는 제거한다.
   * */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    Cookie cookie = new Cookie("c3", "cccc"); // 단위: 초
    //쿠키의 사용 기간을 명시한다.
    cookie.setMaxAge(60);
    resp.addCookie(cookie);
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.println("Servlet03: 쿠키 보냈음.");
  }
}


/* URL 인코딩?
 * HTTP/1.1 200
   Set-Cookie: c2=bbbbbb; Path=/web01
   Content-Type: text/plain;charset=UTF-8
   Content-Length: 30
   Date: Mon, 12 Jun 2017 05:12:12 GMT
 */