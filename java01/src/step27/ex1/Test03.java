/* 스프링 사용법 : 객체 생성하기
 * =>singleton : 객체를 한 개만 생성
 * => prototype : getBean()을 호출할 때 마다 생성한다.
 */
package step27.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
  public static void main(String[] args) throws Exception{
    ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("step27/ex1/application-context-02.xml");
    
    // getBean(빈의 Id)
    Car obj1 = (Car)ctx.getBean("c1");
    Car obj2 = (Car)ctx.getBean("c2");
    Car obj3 = (Car)ctx.getBean("c3");
    Car obj4 = (Car)ctx.getBean("c4");
    Car obj5 = (Car)ctx.getBean("c5");
    
    if (obj2 == obj5) {
      System.out.println("c2나 c5나 같다");
    }
    Car obj6 = (Car)ctx.getBean("c6");
    System.out.println(obj6);
    System.out.println((Car)ctx.getBean("c7"));
    System.out.println((Car)ctx.getBean("c8"));
    System.out.println((Car)ctx.getBean("c9"));
    
    String[] aliases = ctx.getAliases("c7");
    for (String s : aliases) {
      System.out.println(s);
    }
//    System.out.println(ctx.getBean("c10"));
    System.out.println(ctx.getBean("c10 c11 c12"));
    
  }
  
}
