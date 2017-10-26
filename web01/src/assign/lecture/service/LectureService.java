package assign.lecture.service;



import java.util.List;

import assign.classroom.ClassRoomDao;
import assign.lecture.dao.LectureDao;
import assign.lecture.domain.Lecture;
import assign.manager.ManagerDao;



public class LectureService {
  ClassRoomDao classroomDao;
  ManagerDao managerDao;
  LectureDao lectureDao;
  
  
  public void setClassroomDao(ClassRoomDao classroomDao) {
    this.classroomDao = classroomDao;
  }

  public void setManagerDao(ManagerDao managerDao) {
    this.managerDao = managerDao;
  }

  public void setLectureDao(LectureDao lectureDao) {
    this.lectureDao = lectureDao;
  }

  public List<Lecture> list(int pageNo, int pageSize) throws Exception{
    return lectureDao.selectList(pageNo, pageSize);
  }
  
  public Lecture get(int no) throws Exception {
    return lectureDao.selectOne(no);
  }
  
  public void add(Lecture lect) throws Exception {
    int no = lectureDao.insert(lect);
    lectureDao.insert(lect);
  }
  
  public int update(Lecture lect) throws Exception {
    int count = lectureDao.update(lect);
    if ( count < 1) {
      throw new Exception(lect.getLno() + "번 회원을 찾을 수 없습니다.");
    }
    return count;
  }
  public void remove(int no) throws Exception {
    int count = lectureDao.delete(no);
    if ( count < 1) {
      throw new Exception(no + "번 회원을 찾을 수 없습니다.");
    }
    try {
      count = lectureDao.delete(no);
    }catch (Exception e) {}
    
  }
}
