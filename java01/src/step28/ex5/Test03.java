/* Mybatis 퍼시턴스 프레임워크: insert 한 후 자동 생성된 PK 값 받기
 */
package step28.ex5;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test03 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex5/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    ProjectDaoImpl projectDao = new ProjectDaoImpl();
    projectDao.setSqlSessionFactory(sqlSessionFactory);
    Project p= projectDao.selectOne(13);
    System.out.println(p);
  }
}
