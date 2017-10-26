/* 회원 관리 만들기 : Refresh 헤더를 이용한 화면 전환
 * => 화면을 전환한다는 것은 웹 브라우저가 다시 웹 서버에게 다시 요청한다는 의미다
 * => 리프레시(refresh)?
 *      특정 시간이 지나면(timeout) 지정된 URL을 웹서버에 다시 요청하는 기법
 * => 리프레시 방법?
 *      1) 응답 헤더에 추가하기
 *          예) Refresh: 1;url=Servlet02
 *      2) HTML 문서에 삽입하기
 *          예) <html>
 *                  <head>
 *                      <meta http-equiv="Refresh" content="1;url=Servlet02>
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

@WebServlet(urlPatterns="/step04/Servlet02")
public class Servlet02 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
   

    
  
    
    
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    if (req.getParameter("page") == null) {
      out.println("<meta http-equiv='Refresh' content='1;url=Servlet01/a'>");
    } else if (req.getParameter("page").equals("b")) {
      out.println("<meta http-equiv='Refresh' content='1;url=Servlet01/b'>");
    }
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>리프레시</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>화면1</h1>");
    out.println("</body>");
    out.println("</html>");


    
    
    
  }
}
