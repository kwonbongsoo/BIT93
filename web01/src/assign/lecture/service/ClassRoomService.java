package assign.lecture.service;



import java.util.List;

import assign.classroom.ClassRoom;
import assign.classroom.ClassRoomDao;



public class ClassRoomService {
  ClassRoomDao classroomDao;
  
  
  
  public void setClassRoomDao(ClassRoomDao classroomDao) {
    this.classroomDao = classroomDao;
  }

  public List<ClassRoom> list() throws Exception{
    return classroomDao.selectList();
  }
}
