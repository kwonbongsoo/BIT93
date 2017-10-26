/* 회원 관리 만들기 : 회원 변경하기
 * => MemberDao를 이용하여 클라이언트로부터 받은 회원 정보를 변경한다.
 */
package assign.manager;

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

@WebServlet(urlPatterns="/assign/manager/Servlet05")
public class Servlet05 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet05() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Manager m1 = new Manager();
    m1.member = new Member();
    m1.setNo(Integer.parseInt(req.getParameter("no")));
    
    m1.setName(req.getParameter("name"));
    m1.setPosi(req.getParameter("posi"));
    m1.setFax(req.getParameter("fax"));
    m1.setPath(req.getParameter("path"));
    m1.member.setNo(Integer.parseInt(req.getParameter("no")));
    m1.member.setName(req.getParameter("name"));
    m1.member.setTel(req.getParameter("tel"));
    m1.member.setEmail(req.getParameter("email"));
    m1.member.setPassword(req.getParameter("password"));


    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원변경</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ManagerDao managerDao = new ManagerDao(conPool);
      int count = managerDao.update(m1);
      
      if ( count < 1) {
        throw new Exception(m1.getNo() + "번 매니저를 찾을 수 없습니다.");
      }
      MemberDao memberDao = new MemberDao(conPool);
      System.out.println(m1.member.getNo());
      count = memberDao.update(m1.member);
      if (count < 1) {
        throw new Exception(m1.getNo() + "번 회원을 찾을 수 없습니다.");
      }
      
      out.println("<p>변경 성공입니다</p>");
      
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
