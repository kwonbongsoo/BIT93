/* 회원 관리 만들기 : 회원 목록 출력하기2
 * => 회원 목록을 HTML로 만들어 출력한다.
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

@WebServlet(urlPatterns="/assign/manager/Servlet02")
public class Servlet02 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet02() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    /* 페이지 번호와 페이지당 출력 개수 파라미터 받기 */
    int pageNo = 1;
    int pageSize = 5;
    
    try { // pageNo 파라미터 값이 있다면 그 값으로 설정한다
      pageNo = Integer.parseInt(req.getParameter("pageNo"));
      
    }catch (Exception e) {}
    try { // pageSize 파라미터의 값이 있다면 그 값으로 설정한다.
      pageSize = Integer.parseInt(req.getParameter("pageSize"));
      
    }catch (Exception e) {}
    
    // 이렇게 출력스트림을 얻기전에 먼저 호출해야한다.
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>매니저 관리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>매니저 목록</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ManagerDao managerDao = new ManagerDao(conPool);
      List<Manager> list = managerDao.selectList(pageNo, pageSize);
      
      out.println("<a href='form.html'>새 매니저</a>");
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr><th>번호</th><th>이름</th><th>직급</th><th>팩스</th><th>경로</th></th>");
      out.println("</thead>");
      out.println("<tbody>");
      for (Manager m : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>\n", m.getNo());
        out.printf("<td><a href='Servlet04?no=%d'>%s</a></td>\n",m.getNo(), m.getName());
        out.printf("<td>%s</a></td>\n",m.getPosi());
        out.printf("<td>%s</td>\n", m.getFax());
        out.printf("<td>%s</td>\n", m.getPath());
        out.println("</tr>");
      }
      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      out.println("오류 발생!");
      e.printStackTrace(out);
    }
    
    out.println("</body>");
    out.println("</html>");
    
  }
}
