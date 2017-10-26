package step28.ex4;
/* 역할:
 * => memb 테이블의 데이터를 다루는 메서드를 모아둔 클래스이다.
 * => 출력하는 역할은 호출자에게 맡긴다.
 * => DAO의 역할은 결과를 리턴하면 된다.
 * => 커넥션은 DBConnectionPool로부터 얻어서 사용하고,
 *      사용한 후에는 반납한다.
 */


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class TeacherDaoImpl implements TeacherDao{
SqlSessionFactory sqlSessionFactory;
  
  

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }
  
  public List<Teacher> selectList(int pageNo, int pageSize) throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();  
    try {
      HashMap<String, Object>valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      
      return sqlSession.selectList("step28.ex4.TeacherDao.selectList", valueMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public Teacher selectOne(int no) throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();  
    try {
      return sqlSession.selectOne("step28.ex4.TeacherDao.selectOne", no);
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Teacher teacher) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();  
    try {
      int count =  sqlSession.selectOne("step28.ex4.TeacherDao.insert", teacher);
      
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
public List<String> selectPhotoList(int no) throws Exception {
  /*
  //사용할 커넥션을 DBConnectionPool로부터 빌린다.
  Connection con = conPool.getConnection();
  try ( 
    PreparedStatement stmt = con.prepareStatement("select path from tch_phot where tno=?"); ) { 
    stmt.setInt(1, no);
    ArrayList<String> list = new ArrayList<>();
    try (ResultSet rs = stmt.executeQuery(); ) {
      while (rs.next()) { 
        list.add(rs.getString("path"));
      }
     }
    return list; 
  } finally {
    conPool.returnConnection(con);
  }*/ return null;
}
}
