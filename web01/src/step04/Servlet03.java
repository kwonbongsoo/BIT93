/* 화면 전환하기 : HTTP 응답의 status 코드를 사용하여 화면 전환.
 * => Refresh 방법은 일단 클라이언트에게 출력할 내용을 보낸다.
 * => 그러나 때론 클라이언트에게 출력할 내용을 보내지 않고
 *      다시 요청할 URL만 보내야 할 경우가 있다.
 * => 즉 클라이언트는 서버에 요청한 후 
 *      그 결과로서 어떠한 내용도 출력하지 않고,
 *      다시 다른 자원을 서버에 요청하는 방식이다.
 * => 방법?
 *      - 응답 상태 코드를 304로 설정한다.
 *      - 그리고 다시 요청할 URL을 알려준다.
 *      - 이것을 "리다이렉트(redirect)"라고 부른다.
 *      
 *      
HTTP/1.1 302
Location: Servlet01/a
Content-Type: text/html;charset=UTF-8
Content-Length: 0
Date: Wed, 07 Jun 2017 01:59:04 GMT
 */
package step04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step03.DBConnectionPool;
import step03.Member;
import step03.MemberDao;

@WebServlet(urlPatterns="/step04/Servlet03")
public class Servlet03 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
   

  
    
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프레시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>이 내용은 클라이언트로 보내지 않습니다.</h1>");
    for (int i = 0; i < 1000; i++) {
      out.println("1234567890");
    }
    out.println("</body>");
    out.println("</html>");

    
    
    /* 리다이렉트 기능은 HTTP 프로토콜과 관련된 기능이기 때문에
     * 이 기능을 사용하려면 ServletResponse를 원래 타입인 HttpServletResponse로 변환해야 한다.
     */

    HttpServletResponse httpRes = (HttpServletResponse) res;
    if (req.getParameter("page") == null) {
      httpRes.sendRedirect("Servlet01/a");
    } else if (req.getParameter("page").equals("b")) {
      httpRes.sendRedirect("Servlet01/b");
    }
    
    // sendRedirect()를 호출하면 이전에 출력된 내용은 취소된다.
    // 1) ? 이미 클라이언트로 출력했는데 어떻게 취소하느냐?
    // 2) 위에서 out.println()을 하면 이미 내용이 출력 되었는데,
    //    내용이 출력되었다는 것은 그전에 상태코드와 헤더가 출력되었다는 의미다.
    //    그런데 어떻게 상태 코드가 200에서 302로 바뀌는가?
    
    /* 답:
     * - 서블릿에서 응답을 하게 되면 그 모든 출력은 내부 버퍼에 임시 보관된다.
     * - 보통 버퍼의 크기는 8KB이다.
     * - 물론 서버 설정에서 이 크기를 바꿀 수 있다.
     * - 그래서 sendRedirect()를 호출 할때 기존에 버퍼로 출력된 것을 취소할 수 있는 것이다.
     * 
     * 3) 그렇다면 만약 위에서 버퍼 크기를 넘치게 출력한다면 어떻게 됩니까
     * 답:
     * - 버퍼 크기를 초과하면 자동으로 클라이언트로 보낸다.
     * - 이렇게 일단 클라이언트로 출력하게 되면 sendRedirect()를 사용할 수 없다.
     */
  }
}
