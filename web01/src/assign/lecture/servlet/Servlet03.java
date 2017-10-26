/* 회원 관리 만들기 : 회원 목록 출력하기2
 * => 회원 목록을 HTML로 만들어 출력한다.
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

@WebServlet(urlPatterns="/lecture/Servlet03")
public class Servlet03 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet03() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    Lecture l = new Lecture();
    
    l.setTitl(req.getParameter("titl"));
    l.setDscp(req.getParameter("dscp"));
    l.setSdt(req.getParameter("sdt"));
    l.setEdt(req.getParameter("edt"));
    l.setQty(Integer.parseInt(req.getParameter("qty")));
    l.setPric(Integer.parseInt(req.getParameter("pric")));
    l.setThrs(Integer.parseInt(req.getParameter("thrs")));
    l.setCrmno(Integer.parseInt(req.getParameter("crmno")));
    l.setMrno(Integer.parseInt(req.getParameter("mrno")));
    System.out.println(req.getParameter("crmno"));
    System.out.println(req.getParameter("mrno"));

    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의 등록</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 등록</h1>");
    
    
    try {
      
      LectureDao lectureDao = (LectureDao)this.getServletContext().getAttribute("lectureDao");
      lectureDao.insert(l);
      out.println("<p>등록성공입니다</p>");
      
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
