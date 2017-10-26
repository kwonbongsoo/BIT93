package assign.lecture.servlet;
/* 역할 : Http */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns="/auth/logout")
public class LogoutServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    req.getSession().invalidate(); // 요청한 클라이언트의 전용 HttpSession 객체를 무효화시킨다.
    
    res.sendRedirect("../auth/login");
  }
}
