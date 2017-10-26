/* Mybatis 퍼시스턴스 프레임 워크:  
 */
package step28.ex6;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step28.ex4.Member;

public class Test01 {

  public static void main(String[] args) throws Exception {
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step28/ex6/application-context.xml");
    
    System.out.println("-----------------------------------------");
    // 현재 Spring IoC 컨테이너에 보관된 객체를 알아내기
    String[] names = ctx.getBeanDefinitionNames();
    for (String n : names) {
      System.out.printf("%s ====> %s\n", n, ctx.getBean(n));
    }
    
  System.out.println("---------------------------");
  
  TeacherDao teacherDao = ctx.getBean(TeacherDao.class);
  HashMap<String,Object> valueMap=new HashMap<>();
  valueMap.put("startIndex", 1);
  valueMap.put("pageSize", 100);
  List<Teacher> list = teacherDao.selectList(valueMap);
  for (Teacher t : list) {
    System.out.printf("%d, %s, %s, %s\n", t.getNo(), t.getName(), t.getEmail(), t.getTel());
  }
  }
}
