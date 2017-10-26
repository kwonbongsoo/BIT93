/* 회원 관리 만들기 : 회원 삭제하기
 * 
 */
package assign.lecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import assign.lecture.dao.LectureDao;
import assign.lecture.service.LectureService;

@WebServlet(urlPatterns="/lecture/Servlet06")
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
    out.println("  <title>강의 삭제</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 삭제</h1>");

    try {
      
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      int no = Integer.parseInt(req.getParameter("lno"));
      lectureService.remove(no);
      
      out.println("<p>삭제 성공입니다</p>");
      
      out.println("</tbody>");
      out.println("</table>");
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("<a href='Servlet02'>목록</a>");
    
    out.println("</body>");
    out.println("</html>");
    
  }
}
