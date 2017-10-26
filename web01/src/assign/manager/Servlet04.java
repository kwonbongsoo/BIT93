/* 회원 관리 만들기 : 회원  조회하기
 * => MemberDao를 이용하여 클라이언트로 부터 받은 번호에 해당하는 회원 정보 찾아
 *      HTML 만들어 출력한다.
 */
package assign.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import step03.DBConnectionPool;

@WebServlet(urlPatterns="/assign/manager/Servlet04")
public class Servlet04 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet04() {
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
    out.println("  <title>매니저 조회</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>매니저 조회</h1>");
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      ManagerDao managerDao = new ManagerDao(conPool);
      int no = Integer.parseInt(req.getParameter("no"));
      Manager manager = managerDao.selectOne(no);
      
      
      if (manager == null) {
        throw new Exception(no + "번 회원이 없습니다");
      }
      out.println("<form action='Servlet05' method='POST'>");
      out.printf("번호:<input type='text' name='no' value='%d' readonly><br>\n",manager.getNo());
      out.printf("이름:<input type='text' name='name' value='%s'><br>\n",manager.member.getName());
      out.printf("전화:<input type='text' name='tel' value='%s'><br>\n", manager.member.getTel());
      out.printf("이메일:<input type='text' name='email' value='%s'><br>\n", manager.member.getEmail());
      out.printf("암호:<input type='text' name='password'><br>");
      out.printf("직급:<input type='text' name='posi' value='%s'><br>\n", manager.getPosi());
      out.printf("팩스:<input type='text' name='fax' value='%s'><br>\n", manager.getFax());
      out.printf("경로:<input type='text' name='path' value='%s'><br>\n", manager.getPath());
      out.println("<button>변경</button>");
      out.println("<button type='button' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' onclick='doList()'>목록</button>");
      out.println("</form>");
      
    } catch (Exception e) {
      out.println("오류 발생!");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
      out.println("<a href='Servlet02'>목록</a>");
    }
    out.println("<script>");
    out.println("  function doDelete() {");
    out.printf("    location.href = 'Servlet06?no=%s'\n", req.getParameter("no"));
    out.println(" }");
    
    out.println("  function doList() {");
    out.println("    location.href = 'Servlet02'");
    out.println(" }");
    out.println("</script>");
    
    out.println("</body>");
    out.println("</html>");
    
  }
}
