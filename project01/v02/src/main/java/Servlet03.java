/* 회원 관리 만들기 : 회원 목록 출력하기2
 * => 회원 목록을 HTML로 만들어 출력한다.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/member/Servlet03")
public class Servlet03 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet03() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Member m1 = new Member();
    
    m1.setName(req.getParameter("name"));
    m1.setTel(req.getParameter("tel"));
    m1.setEmail(req.getParameter("email"));
    m1.setPassword(req.getParameter("password"));

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원등록</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      MemberDao memberDao = new MemberDao(conPool);
      memberDao.insert(m1);
      out.println("<p>등록성공입니다</p>");
      
      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }
    
    out.println("<a href='Servlet02'>목록</a>");
    
    out.println("</body>");
    out.println("</html>");
    
  }
}
