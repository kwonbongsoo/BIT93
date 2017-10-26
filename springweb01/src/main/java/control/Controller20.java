/* Spring WebMVC : 세션에 보관된 데이터 출력하기
 * => 다른 페이지 컨트롤러에서 작업한 결과가 httpSession 객체에 보관소에 저장되어 있다면,
 *      당연히 꺼내 볼 수 있다.
 */
package control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/control/controller20/")
public class Controller20 {
  
  @RequestMapping(value="ok1")
    public String ok01() throws Exception{
     return "controller20_ok1";
  }
  
  @RequestMapping(value="reset")
  public String reset(SessionStatus status) throws Exception{
    status.setComplete();
   return "controller20_ok1";
}
  

}
