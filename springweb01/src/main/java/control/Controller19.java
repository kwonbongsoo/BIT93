/* Spring WebMVC : 세션다루기
 */
package control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/control/controller19/")
public class Controller19 {
  
  @RequestMapping(value="ok1")
    public String ok01() throws Exception{
     return "controller19_ok1";
  }
  
  @RequestMapping(value="ok2")
  public String ok02(String name, HttpSession session) throws Exception{
    Member member = new Member();
    member.setName(name);
    session.setAttribute("member", member);
   return "controller19_ok2";
  }
  
  @RequestMapping(value="ok3")
  public String ok03(int age, HttpSession session) throws Exception{
    Member member = (Member)session.getAttribute("member");
    member.setAge(age);
    
   return "controller19_ok3";
  }
  
  @RequestMapping(value="ok4")
  public String ok04(boolean working ,HttpSession session) throws Exception{
    Member member = (Member)session.getAttribute("member");
    member.setWorking(working);
   return "controller19_ok4";
  }
  
  @RequestMapping(value="reset")
  @ResponseBody
  public String reset(SessionStatus status, HttpSession session) throws Exception{
  //setCompelete()
    // => 현재 페이지 컨트롤러에서 @SessionAttributes 에 설정된 객체만 세션에서 제거한다.
//    status.setComplete(); // 현재 페이지 컨트롤러에 @SessionAttributes 가 없기 때문에 제거될 것도 없다
    // SessionAttributes 가없으므로 여기선 삭제되지 않는다.
    
    //HttpSession.setAttribute()로 설정된 객체를 지우려면
    // 1) 세션 전체를 무효화시킨다.
     session.invalidate(); //로무효화시킨다.
     
     // 2) 세션에 보관된 특정 객체만 지운다
     // session.removeAttribute("member");
   return "세션을 완료 했음!";
}
}
