package bitcamp.java93.dao;
/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *      사용한 후에는 반납한다.
 */


import java.util.List;
import java.util.Map;

import bitcamp.java93.domain.Teacher;

public interface TeacherDao {
  List<Teacher> selectList(Map<String,Object> valueMap) throws Exception;
  Teacher selectOne(int no) throws Exception;
  int countAll() throws Exception;
  int insert(Teacher teacher) throws Exception;
  int update(Teacher teacher) throws Exception;
  int delete(int no) throws Exception;
  void  insertPhoto(Map<String,Object> valueMap) throws Exception;
  void deletePhoto(int teacherNo) throws Exception;
  Teacher selectOneByEmailPassword (Map<String,Object> valueMap) throws Exception;
  List<String> selectPhotoList(int no) throws Exception;
}
