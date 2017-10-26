/* 회원 관리 만들기 : 회원 변경하기
 * => MemberDao를 이용하여 클라이언트로부터 받은 회원 정보를 변경한다.
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
import assign.lecture.domain.Lecture;
import assign.lecture.service.LectureService;

@WebServlet(urlPatterns="/lecture/Servlet05")
public class Servlet05 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet05() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Lecture lecture = new Lecture();
    
    lecture.setLno(Integer.parseInt(req.getParameter("lno")));
    lecture.setQty(Integer.parseInt(req.getParameter("qty")));
    lecture.setPric(Integer.parseInt(req.getParameter("pric")));
    lecture.setThrs(Integer.parseInt(req.getParameter("thrs")));
    lecture.setMrno(Integer.parseInt(req.getParameter("mrno")));
    lecture.setCrmno(Integer.parseInt(req.getParameter("crmno")));
    lecture.setDscp(req.getParameter("dscp"));
    lecture.setSdt(req.getParameter("sdt"));
    lecture.setEdt(req.getParameter("edt"));
    lecture.setTitl(req.getParameter("titl"));




    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의실 정보 변경</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의실 정보 변경</h1>");
    
    
    
    try {
      
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      int count = lectureService.update(lecture);
      if ( count < 1) {
        throw new Exception(lecture.getLno() + "번 강의실을 찾을 수 없습니다.");
      }
      out.println("<p>변경 성공입니다</p>");
      
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
