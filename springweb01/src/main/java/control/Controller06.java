/* Spring WebMVC : http method 구분하여 처리하기
 * 요청 URL = class 붙은 URL + 메서드에 붙은 URL
 *        실행방법
 *            http:localhost:8080/controller05.html
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/control/controller06/")
public class Controller06 {
  @RequestMapping(path="ok",method=RequestMethod.GET)
  public void get(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("get");
  }
  
  @RequestMapping(value="ok",method=RequestMethod.POST)
  public void post(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("post");
  }
}
