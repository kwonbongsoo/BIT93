/* Mybatis 퍼시스턴스 프레임 워크: 조인 결과 가져오기
 * => 동적(dynamic) SQL?
 *    - 조건에 따라 SQL문이 변경되는 것을 말한다.
 * => 특정 조건에 따라 SQL문이 약간씩 변경되어야 하는 경우,
 *      1) 각각의 조건에 해당하는 SQL문을 만든다.
 *          예) step28.ex2 패키지의 MemberDao.xml
 *      2) 조건에 따라 SQL문이 자동으로 바뀌도록 만든다.
 *          예) step28.ex3 패키지의 예제이다.
 */
package step28.ex5;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream("step28/ex5/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    
    TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    teacherDao.setSqlSessionFactory(sqlSessionFactory);
    Teacher t= teacherDao.selectOne(213);
    System.out.println(t);
  }
}
