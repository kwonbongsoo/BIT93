/* 회원 관리 만들기 : 회원 목록 출력하기2
 * => 회원 목록을 HTML로 만들어 출력한다.
 */
package assign.lecture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import assign.lecture.domain.Lecture;
import assign.lecture.service.LectureService;

@WebServlet(urlPatterns="/lecture/Servlet02")
public class Servlet02 extends GenericServlet{
  private static final long serialVersionUID = 1L;

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
    out.println("<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css'>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>회원관리</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원목록</h1>");

    
    
    try {
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      List<Lecture> list = lectureService.list(pageNo, pageSize);
      
      out.println("<a href='addServlet' class='btn btn-primary btn-lg active' role='button'>새강의 등록</a>");
      out.println("<div class='table-responsive'>");
      out.println("<table border='1' class='table'>");
      out.println("<thead>");
      out.println("<tr><th>수강번호</th><th>강의명</th><th>시작일</th><th>종료일</th><th>총시간</th><th>가격</th></th>");
      out.println("</thead>");
      out.println("<tbody>");
      for (Lecture l : list) {
        out.println("<tr>");
        out.printf("<td>%d</td>\n", l.getLno());
        out.printf("<td><a href='Servlet04?no=%d'>%s</a></td>\n",l.getLno(), l.getTitl());
        out.printf("<td>%s</td>\n", l.getSdt());
        out.printf("<td>%s</td>\n", l.getEdt());
        out.printf("<td>%s</td>\n", l.getThrs());
        out.printf("<td>%s</td>\n", l.getPric());
        out.println("</tr>");
      }
      out.println("</tbody>");
      out.println("</table>");
      out.println("</div>");
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("<script src=' http://code.jquery.com/jquery-latest.min.js'></script>");
    out.println("<script src='//code.jquery.com/jquery.min.js'></script>");
    out.println("<script src='//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js'></script>");
    
    out.println("</body>");
    out.println("</html>");
    
  }
}
