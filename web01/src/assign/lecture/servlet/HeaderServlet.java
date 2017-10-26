package assign.lecture.servlet;
/* 페이지 상단에 HttpSession 보관소에 꺼낸 로그인 회원 정보 
 * 
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.lecture.domain.Member;



@WebServlet(urlPatterns="/header")
public class HeaderServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;


  @Override
  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<div class='header'>");
    out.println(" <div id='logo'>비트캠프</div>");
    out.println(" <div id='login'>");
    Member loginMember = (Member)req.getSession().getAttribute("loginMember");
    if (loginMember != null) {
      out.printf("%s(%s)\n", loginMember.getName(), loginMember.getEmail());
      out.printf("   <a href='%s/auth/logout'>로그아웃</a>\n", req.getContextPath());
    }
    out.println(" </div>");
    out.println("</div>");
    
    
  }
}