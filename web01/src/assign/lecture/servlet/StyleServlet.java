package assign.lecture.servlet;
/* 웹페이지의 css 스타일 코드를 출력하는 서블릿
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/style/core")
public class StyleServlet extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public StyleServlet() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
   
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    
    out.println("<link rel='stylesheet' href='../css/common.css'>");
    
  }
}