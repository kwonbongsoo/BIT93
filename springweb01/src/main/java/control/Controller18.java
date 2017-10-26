/* Spring WebMVC : 클라이언트로 부터 jsp를 감추기
 * => mvc 아키텍처에서는 요청을 처리할 때
 *      페이지 컨트롤러가 Service, DAO와 협업하여 JSP가 출력할 데이터를 준비한다.
 *      그런 후에 JSP로 포워딩시켜 출력을 완료한다
 *      그러므로 MVC 아키텍처에서는 JSP를 그냥 실행시키는 것은 아무런 의미도 없다.
 * => 그래서 웹 브라우저가 JSP를 찾지 못하도록 WEB-INF 밑에 숨겨둔다.
 */
package control;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/control/controller18/")
public class Controller18 {
  
  
  // ServletContext 객체는 Request Handler의 아규먼트로 받을 수 없다.
  // 대신에 주입시켜 달라고 요청하라
  @Autowired ServletContext servletContext;
  
 // 1) 업로드 파일 받기
  //  =>controller16_ok1_form.html 에서 요청할것
  @RequestMapping(value="ok1")
    public String ok01(Model model) throws Exception{
     Member member = new Member();
     member.setName("홍길동");
     member.setAge(20);
     member.setWorking(true);
     
     model.addAttribute("member", member);
     
     return "controller18_ok1";
  }
}
