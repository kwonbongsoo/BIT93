/* 회원 관리 만들기 : 회원 삭제하기
 * 
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
import step03.MemberDao;

@WebServlet(urlPatterns="/assign/manager/Servlet06")
public class Servlet06 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet06() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원삭제</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원삭제</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ManagerDao managerDao = new ManagerDao(conPool);
      
      int no = Integer.parseInt(req.getParameter("no"));
      int count = managerDao.delete(no);
      MemberDao memberDao = new MemberDao(conPool);
      
      if ( count < 1) {
        throw new Exception(no+ "번 매너지를 찾을 수 없습니다.");
      }
      memberDao.delete(no);
      if ( count < 1) {
        throw new Exception(no+ "번 회원을 찾을 수 없습니다.");
      }
      out.println("<p>삭제 성공입니다</p>");
      
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