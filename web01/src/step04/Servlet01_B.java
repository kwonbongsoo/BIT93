/* 회원 관리 만들기 : Refresh 헤더를 이용한 화면 전환 (화면2)
 * => 
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

import step03.DBConnectionPool;
import step03.Member;
import step03.MemberDao;

@WebServlet(urlPatterns="/step04/Servlet01/b")
public class Servlet01_B extends GenericServlet{
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
    out.println("<h1>화면b</h1>");
    out.println("</body>");
    out.println("</html>");

  }
}
