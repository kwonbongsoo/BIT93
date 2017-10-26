package assign.lecture.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import assign.classroom.ClassRoomDao;
import assign.lecture.dao.LectureDao;
import assign.lecture.service.ClassRoomService;
import assign.lecture.service.LectureService;
import assign.lecture.service.ManagerService;
import assign.manager.ManagerDao;
import step03.DBConnectionPool;
import step03.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹 애플리케이션이 시작 될때 dao를 생성하여 ServletContext 보관소에 저장한다.
    
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb";
    String jdbcUsername = "webapp";
    String jdbcPassword = "1111";
    
    
    try {
      DBConnectionPool conPool = new DBConnectionPool(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword);
      
      LectureDao lectureDao = new LectureDao(conPool);
      ClassRoomDao classroomDao = new ClassRoomDao(conPool);
      ManagerDao managerDao = new ManagerDao(conPool);
      MemberDao memberDao = new MemberDao(conPool);
      
      ClassRoomService classroomService = new ClassRoomService();
      classroomService.setClassRoomDao(classroomDao);
      ManagerService managerService = new ManagerService();
      managerService.setManagerDao(managerDao);
      
      LectureService lectureService = new LectureService();
      lectureService.setClassroomDao(classroomDao);
      lectureService.setManagerDao(managerDao);
      lectureService.setLectureDao(lectureDao);
      
      ServletContext sc = sce.getServletContext();
      sc.setAttribute("memberDao", memberDao);
      sc.setAttribute("lectureService", lectureService);
      sc.setAttribute("managerService", managerService);
      sc.setAttribute("classroomService", classroomService);

      
      
      
      
    } catch (Exception e) {
     e.printStackTrace();
      }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // TODO Auto-generated method stub
    
  }

}
