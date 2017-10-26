package assign.lecture.servlet;

/* 웹 애플리케이션 공통 자원을 준비하는 서블릿
 * => DBConnectionPool과 DAO를 준비한다.
 * => ServletContext 보관소에 저장한다.
 */


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import assign.classroom.ClassRoomDao;
import assign.lecture.dao.LectureDao;
import assign.manager.ManagerDao;
import step03.DBConnectionPool;

// 웹 애플리케이션이 시작될 때 이 서블릿 객체를 자동 생성해야 하기 때문에,
// WebServlet 애노테이션에 loadOnStartup 속성을 추가한다.
@WebServlet(urlPatterns="/InitServlet", loadOnStartup=1) 
public class InitServlet  extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void init() throws ServletException {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(
          jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      LectureDao lectureDao = new LectureDao(conPool);
      ManagerDao managerDao = new ManagerDao(conPool);
      ClassRoomDao classroomDao = new ClassRoomDao(conPool);
      
      // 모든 서블릿이 사용할 수 있도록 memberDao 객체를 ServletContext에 보관한다.
      ServletContext sc = this.getServletContext();
      sc.setAttribute("lectureDao", lectureDao);
      sc.setAttribute("managerDao", managerDao);
      sc.setAttribute("classroomDao", classroomDao);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}








