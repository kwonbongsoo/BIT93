/* Spring WebMVC : 요청 프로토콜의 Accept 헤더의 값에 따라 호출될 메서드 결정
 * => 실행방법
 *        
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller09/")
public class Controller09 {
  
  // produce의 의미
  // => 이 메서드를 생산하는 콘텐트의 타입을 가리킨다
  @RequestMapping(path="ok", produces="text/plain")
  public void get(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("text/plain");
  }
  
  @RequestMapping(value="ok",produces="application/json")
  public void post(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("application/json");
  }
}
