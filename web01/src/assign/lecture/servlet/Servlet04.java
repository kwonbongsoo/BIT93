/* 회원 관리 만들기 : 회원  조회하기
 * => MemberDao를 이용하여 클라이언트로 부터 받은 번호에 해당하는 회원 정보 찾아
 *      HTML 만들어 출력한다.
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

import assign.classroom.ClassRoom;
import assign.lecture.domain.Lecture;
import assign.lecture.service.ClassRoomService;
import assign.lecture.service.LectureService;
import assign.lecture.service.ManagerService;
import assign.manager.Manager;

@WebServlet(urlPatterns="/lecture/Servlet04")
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
    out.println("<link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css'>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>강의 조회</title>");
    RequestDispatcher rd = req.getRequestDispatcher("/style/core");
    rd.include(req, res);
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강의 조회</h1>");
    

    

    try {
      ManagerService managerService = (ManagerService)this.getServletContext().getAttribute("managerService");
      List<Manager>mlist = managerService.list();
      ClassRoomService classroomService = (ClassRoomService)this.getServletContext().getAttribute("classroomService");
      List<ClassRoom> clist = classroomService.list();
      LectureService lectureService = (LectureService)this.getServletContext().getAttribute("lectureService");
      Lecture l =lectureService.get(Integer.parseInt(req.getParameter("no")));

      out.println("<form action='Servlet05' method='POST'>");
      out.printf(" <input type='text' name='lno' value='%d' class='form-control' readonly>\n",l.getLno());
      out.println(" <div>");
      out.println("   <label >강의명</label>");
      out.println("   <div>");
      out.println("    <input type='text' class='form-control' name='titl' placeholder='강의명' value='"+l.getTitl()+"'>");
      out.println("  </div>");
      out.println(" </div>");
      out.println(" <div>");
      out.println(" <label>설명</label>");
      out.println(" <div>");
      out.println("   <textarea class='form-control' name='dscp'");
      out.println("     placeholder='강의에 대한 상세 설명'");
      out.println("         rows='4'>"+ l.getDscp()+"</textarea>");
      out.println("   </div>");
      out.println("  </div>");
      out.println("  <div >");
      out.println("   <label>강의 기간</label>");
      out.println("   <div >");
      out.println("     <input type='date' name='sdt' class='form-control' placeholder='시작일' value='"+l.getSdt()+"'>");
      out.println("    ~");
      out.println("     <input type='date' name='edt' class='form-control' placeholder='종료일' value='"+l.getEdt()+"'>");
      out.println("   </div>");
      out.println(" </div>");
      out.println("  <div >");
      out.println("   <label >수강인원</label>");
      out.println("   <div>");
      out.println("     <input type='number' class='form-control' name='qty' placeholder='최대 수강 인원' value='"+l.getQty()+"'>");
      out.println("   </div>");
      out.println(" </div>");
      out.println(" <div >");
      out.println("   <label >강의시간</label>");
      out.println("   <div >");
      out.println("     <input type='number' class='form-control' name='thrs' placeholder='총 강의 시간' value='" +l.getThrs()+"''>");
      out.println("   </div>");
      out.println("  </div>");
      out.println("  <div >");
      out.println("    <label >수업료</label>");
      out.println("    <div >");
      out.println("     <input type='number' class='form-control' name='pric' placeholder='수업료' value='"+l.getPric()+"'>");
      out.println("   </div>");
      out.println(" </div>");
      out.println(" <div >");
      out.println("   <label >강의실</label>");
      out.println("   <div >");
      out.println("     <select name='crmno' class='form-control'>");
      out.println("       <option value='0'>강의실을 선택하세요!</option>");
      for ( ClassRoom c : clist) {
        if (c.getNo() == l.getCrmno()) {
          out.print("<option value='"+c.getNo()+"' selected>");
        }else {
          out.print("<option value='"+c.getNo()+"' >");
        }
        out.print(c.getName()+"</option>");
      }
      out.println("     </select>");
      out.println("   </div>");
      out.println(" </div>");
      out.println("  <div >");
      out.println("   <label >매니저</label>");
      out.println("   <div >");
      out.println("     <select name='mrno' class='form-control'>");
      out.println("       <option value='0'>매니저를 선택하세요!</option>");
      for ( Manager m : mlist) {
        if (m.getNo()== l.getMrno()) {
          out.print("<option value='"+m.getNo()+"'  selected>");
        }else {
          out.print("<option value='"+m.getNo()+"' >");
        }
        out.print(m.getName()+"</option>");
      }
      out.println("    </select>");
      out.println("   </div>");
      out.println(" </div>");
      out.println("   <div >");
      out.println("   <div >");
      out.println("          <button type='submit' class='btn btn-success'>변경</button>");
      out.println("<button type='button' class='btn btn-primary' onclick='doDelete()'>삭제</button>");
      out.println("<button type='button' class='btn btn-danger' onclick='doList()'>목록</button>");
      out.println("  </div>");
      out.println("  </div>");
      out.println("</form>");
      out.println(" </div>");
      
      
    } catch (Exception e) {
      req.setAttribute("error", e);
      rd = req.getRequestDispatcher("/error");
      rd.forward(req, res);
      return;
    }
    out.println("<script src=' http://code.jquery.com/jquery-latest.min.js'></script>");
    out.println("<script src='//code.jquery.com/jquery.min.js'></script>");
    out.println("<script src='//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js'></script>");
    
    out.println("<script>");
    out.println("  function doDelete() {");
    out.printf("    location.href = 'Servlet06?lno=%s'\n", req.getParameter("no"));
    out.println(" }");
    out.println("  function doList() {");
    out.println("    location.href = 'Servlet02'");
    out.println(" }");
    out.println("</script>");
    
    rd = req.getRequestDispatcher("/footer");
    rd.include(req, res);
    out.println("</body>");
    out.println("</html>");
    
    
  }
}
