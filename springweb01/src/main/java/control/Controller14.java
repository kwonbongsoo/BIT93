/* Spring WebMVC : Request Handler (요청을 처리하는 메서드)의 파라미터들 3 - 커스텀 프로퍼티 에디터2
 *  => 프론트 컨트롤러는 페이지 컨트롤러의 메서드를 호출 할 때,
 *       그 메서드가 어떤 파라미터 값을 요구하는 지 분석하여
 *       그에 해당하는 값을 자동으로 꼽아준다
 *  => Request Handler의 파라미터로 선언할 수 있는 것
 *       1) HttpServletRequest, ServletRequest
 *       2) HttpServletResponse, ServletResponse
 *       3) HttpSession
 *       4) Map,Model
 *       5) 요청 파라미터 
 */
package control;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller14/")
public class Controller14 {
  
  // 모든 페이지 컨트롤러가 사용할 프로퍼티 변환기 설치하기
  
  // 1) 변환기 설치전
  //     String --->java.sql.Date으로 자동 변환 가능
 
  @RequestMapping(value="ok01")
  public void ok01(
      String name, // requestParam 이 붙지않으면 선택사항이다.
      java.util.Date date, 
      boolean working, 
      HttpServletRequest request, // HttpServlet 서블릿 변수에대해서는 initBinder함수가 실행되지 않는다.
      HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("ok01");
    out.println(name);
    out.println(date);
  }

}
