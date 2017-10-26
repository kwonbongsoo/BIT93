/* Spring WebMVC : 필터 다루기
 * => 어떤 작업을 시작하기 전이나 후에 뭔가를 실행하고 싶을 때 사용하는 기술이 필터이다.
 * => 필터의 종류
 * 1) Servlet 기술에서 제공하는 필터
 *     => 서블릿 실행 전, 후에 뭔가를 삽입하는 기술
 *    javax.servlet.Filter 구현체
 * 2) Spring에서 제공하는 필터
 *    - 인터셉터 : 페이지 컨트롤러 실행 전, 후에 삽입하고 싶을 때 사용한다.
 *    - AOP 객체 : 페이지 컨트롤러 뿐만 아니라 모든 객체의 메서드 호출 전, 후에 뭔가를 삽입하는 기술!
 *     (AOP) Accept-Oriented Programing
 */
package control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/* 야 프론트 컨트롤러야 
 * ServletRequest에 옮겨주는 것을 알고 있다. 고맙다! JSP에서 잘 쓰고 있다.
 * 그런데, 혹시 Model에 저장된 값 중에 이름이 "member2"인 것이 있다면,
 * 그 객체는 ServletRequest 뿐만 아니라 세션에도 보관해주렴
 * 
 */
@Controller
@RequestMapping("/control/controller22/")
public class Controller22 {
  @Autowired MyService service;
  @RequestMapping(value="list")
    public String list() throws Exception{
    System.out.println("  Controller22.list()");
    service.list();
    System.out.println("  Controller22.list()");
     return "controller22_list";
  }
  
  @RequestMapping(value="detail")
  public String detail() throws Exception{
    System.out.println("  Controller22.detail()");
    service.detail();
    System.out.println("  Controller22.detail()");
   return "controller22_detail";
}
  
  @RequestMapping(value="insert")
  public String insert() throws Exception{
    System.out.println("  Controller22.insert()");    
    service.insert();
    System.out.println("  Controller22.insert()");    
   return "controller22_insert";
}
  @RequestMapping(value="update")
  
  public String update() throws Exception{
    System.out.println("  Controller22.update()");
    service.update();
    System.out.println("  Controller22.update()");
   return "controller22_update";
}
  @RequestMapping(value="delete")
  public String delete() throws Exception{
    System.out.println("  Controller22.delete()");
    service.delete();
    System.out.println("  Controller22.delete()");
   return "controller22_delete";
}
  
}
