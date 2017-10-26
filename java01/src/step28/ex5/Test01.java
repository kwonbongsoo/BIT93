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
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step28/ex5/application-context.xml");
    
    System.out.println("-----------------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames();
    for (String n : names) {
      System.out.printf("%s ====> %s\n", n, ctx.getBean(n));
    }
    
  System.out.println("---------------------------");
  
  TeacherDao teacherDao = ctx.getBean(TeacherDao.class);
  List<Teacher> list = teacherDao.selectList(1,100);
  for (Teacher t : list) {
    System.out.println(t);
  }
  }
}
