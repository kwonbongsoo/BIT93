/* Spring WebMVC : JSON 콘텐츠로 응답하기
 * => @Controller+ @Repository = @RestController
 */
package control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;


/* 야 프론트 컨트롤러야 
 * ServletRequest에 옮겨주는 것을 알고 있다. 고맙다! JSP에서 잘 쓰고 있다.
 * 그런데, 혹시 Model에 저장된 값 중에 이름이 "member2"인 것이 있다면,
 * 그 객체는 ServletRequest 뿐만 아니라 세션에도 보관해주렴
 * 
 */
@RestController
@RequestMapping("/control/controller23/")
public class Controller23 {
  
  // 1) RestController
  @RequestMapping(value="ok1", produces = "application/json;charset=UTF-8")
  @ResponseBody
  public String ok1() throws Exception{
    Member member = new Member();
    member.setName("홍길동");
    member.setAge(20);
    member.setWorking(true);
   return new Gson().toJson(member);
}
  
  // 2) RestController를 사용한 방법
  @RequestMapping("ok2")
  public Member ok2() throws Exception{
    Member member = new Member();
    member.setName("홍길동");
    member.setAge(20);
    member.setWorking(true);
   return member;
}
  
  

  
}
