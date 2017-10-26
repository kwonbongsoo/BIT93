/* Spring WebMVC : 요청 URL 계산하기
 * => 요청 URL = class에 붙은 URL + 메서드에 붙은 URL
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller03/")
public class Controller03 {
  @RequestMapping("a") //어떤 요청을 처리할 지 표시
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("aaa");
  }
  
  @RequestMapping("b") //어떤 요청을 처리할 지 표시
  public void service2(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("bbbb");
  }
  
  @RequestMapping("c") //어떤 요청을 처리할 지 표시
  public void service3(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ccccc");
  }
}
