package step28.ex3;
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

public class MemberDaoImpl implements MemberDao{
  SqlSessionFactory sqlSessionFactory;
  
  

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Member> selectList(int pageNo, int pageSize) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();  
    try {
      HashMap<String, Object>valueMap = new HashMap<>();
      valueMap.put("startIndex", (pageNo - 1) * pageSize);
      valueMap.put("pageSize", pageSize);
      
      return sqlSession.selectList("step28.ex3.MemberDao.selectList", valueMap);
    } finally {
      sqlSession.close();
    }
  }
  public Member selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      // SqlSession.selectOne()을 실행할 때는 반드시 결과를 한 개만 만드는 select문을 지정해야 한다.
      return sqlSession.selectOne("step28.ex3.MemberDao.selectOne", no);
    } finally {
      sqlSession.close();
    }
  }
  
  public int insert(Member member) throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      // SqlSession.selectOne()을 실행할 때는 반드시 결과를 한 개만 만드는 select문을 지정해야 한다.
      int count = sqlSession.insert("step28.ex3.MemberDao.insert", member);
      // insert(), update(), delete()을 호출한 후에는
      // DBMS에 최종 명령을 보내야 실행이 완료 된다.
      sqlSession.commit();
      
      /* insert(), update(), delete()을 호출한 후 DBMS에 자동으로
       * 최종적으로 확정하는 명령을 보내고 싶다면,
       * sqlSession을 얻을 때 미리 설정해야 한다.
       * 코드 :
       * SqlSession sqlSession = sqlSessionFactory.openSession(true); 
       */ 
      
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    try {
      return sqlSession.update("step28.ex3.MemberDao.delete", no);
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Member member) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      // SqlSession.selectOne()을 실행할 때는 반드시 결과를 한 개만 만드는 select문을 지정해야 한다.
      int count = sqlSession.update("step28.ex3.MemberDao.update", member);
      // insert(), update(), delete()을 호출한 후에는
      // DBMS에 최종 명령을 보내야 실행이 완료 된다.
      sqlSession.commit();
      
      /* insert(), update(), delete()을 호출한 후 DBMS에 자동으로
       * 최종적으로 확정하는 명령을 보내고 싶다면,
       * sqlSession을 얻을 때 미리 설정해야 한다.
       * 코드 :
       * SqlSession sqlSession = sqlSessionFactory.openSession(true); 
       */ 
      
      return count;
    } finally {
      sqlSession.close();
    }
  }
public Member selectOneByEmailPassword (String email, String password) throws Exception {
  
  SqlSession sqlSession = sqlSessionFactory.openSession();
  try {
    // SqlSession.selectOne()을 실행할 때는 반드시 결과를 한 개만 만드는 select문을 지정해야 한다.
    HashMap<String, Object>valueMap = new HashMap<>();
    valueMap.put("email", email);
    valueMap.put("password", password);
    return sqlSession.selectOne("step28.ex3.MemberDao.selectOneByEmailPassword", valueMap);
  } finally {
    sqlSession.close();
  }
 }

@Override
public List<Member> selectList(int pageNo, int pageSize, String search, String value) throws Exception {
  SqlSession sqlSession = sqlSessionFactory.openSession();  
  try {
    HashMap<String, Object>valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    valueMap.put("search", search);
    valueMap.put("value", value);
    
    return sqlSession.selectList("step28.ex3.MemberDao.selectList", valueMap);
  } finally {
    sqlSession.close();
  }
}

@Override
public List<Member> selectListByNames(int pageNo, int pageSize, String[] names) throws Exception {
  SqlSession sqlSession = sqlSessionFactory.openSession();  
  try {
    HashMap<String, Object>valueMap = new HashMap<>();
    valueMap.put("startIndex", (pageNo - 1) * pageSize);
    valueMap.put("pageSize", pageSize);
    valueMap.put("names", names);
    
    return sqlSession.selectList("step28.ex3.MemberDao.selectListByNames", valueMap);
  } finally {
    sqlSession.close();
  }
}

}
