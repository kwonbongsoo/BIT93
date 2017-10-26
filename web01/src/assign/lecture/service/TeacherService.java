package assign.lecture.service;



import java.util.List;

import assign.lecture.dao.MemberDao;
import assign.lecture.dao.TeacherDao;
import assign.lecture.domain.Teacher;



public class TeacherService {
  MemberDao memberDao;
  TeacherDao teacherDao;
  
  public void setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  public void setTeacherDao(TeacherDao teacherDao) {
    this.teacherDao = teacherDao;
  }
  
  public List<Teacher> list(int pageNo, int pageSize) throws Exception{
    return teacherDao.selectList(pageNo, pageSize);
  }
  
  public Teacher get(int no) throws Exception {
    return teacherDao.selectOne(no);
  }
  
  public void add(Teacher teacher) throws Exception {
    int no = memberDao.insert(teacher);
    System.out.println(no);
    teacherDao.insert(teacher,no);
  }
  
  public int update(Teacher teacher) throws Exception {
    int count = memberDao.update(teacher);
    if ( count < 1) {
      throw new Exception(teacher.getNo() + "번 회원을 찾을 수 없습니다.");
    }
    count = teacherDao.update(teacher);
    
    if ( count < 1) {
      throw new Exception(teacher.getNo() + "번 회원을 찾을 수 없습니다.");
    }
    
    return count;
  }
  public void remove(int no) throws Exception {
    int count = teacherDao.delete(no);
    if ( count < 1) {
      throw new Exception(no + "번 회원을 찾을 수 없습니다.");
    }
    try {
      count = memberDao.delete(no);
    }catch (Exception e) {}
    
  }
}
