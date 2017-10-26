/* 회원 관리 만들기 : 회원 목록 출력하기2
 * => 회원 목록을 HTML로 만들어 출력한다.
 */
package assign.classroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/assign/classroom/Servlet03")
public class Servlet03 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet03() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    ClassRoom c = new ClassRoom();
    
    c.setName(req.getParameter("name"));

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의실 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 등록</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      step03.DBConnectionPool conPool = new step03.DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ClassRoomDao classroomDao = new ClassRoomDao(conPool);
      classroomDao.insert(c);
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
