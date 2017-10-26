/* Spring WebMVC : Request Handler (요청을 처리하는 메서드)의 파라미터들 1
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

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/control/controller11/")
public class Controller11 {
  
  //consumes 의 의미?
  // => 클라이언트가 보낸 데이터의 형식 중에서 이 메서드가 처리할 수 있는 형식을 지정.
  @RequestMapping(path="ok1")
  public void ok1() throws Exception{

    System.out.println(" ok2() 프론트 컨트롤러로 부터 아무것도 받지 않는다.");
  }
  
  @RequestMapping(value="ok2")
  public void ok2(HttpServletRequest request) throws Exception{
    System.out.println("ok2");
  }
  
  @RequestMapping(value="ok3")
  public void ok3(HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok3");
  }
  
  @RequestMapping(value="ok4")
  public void ok4(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok4");
  }
  
  @RequestMapping(value="ok5")
  public void ok5(HttpSession session, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ok5");
  }
  // 프론트 컨트롤러가 줄 수 없는 값을 메서드에서 요구할 경우,
  // 즉 파라미터에 선언할 경우,
  // 실행할 때 오류가 발생한다.
  // 예) 다음 메서드에서 FileInputStream 파라미터가 이런경우이다.
  @RequestMapping(value="ok6")
  public void ok6(Socket socket, FileInputStream in, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    System.out.println(socket);
    System.out.println(in);
    out.println("ok6");
  }
  
  // 이 메서드에서 실행한 결과를 담을 바구니를 요구 할 수 있다.
  // 이 바구니에 값을 담으면, JSP에서 꺼내 쓸 수 있다.
  // 자수이릐 차맂릉 MSP 꼬응 Model 등이 가능하다.
  @RequestMapping(value="ok7")
  public void ok7(Map<String, Object> store, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    store.put("name", "홍길동");
    store.put("age", 20);
    out.println(store);
    out.println("ok7");
    
    // 이렇게 바구니에 담은 데이터는
    // 스프링의 프론트 컨트롤러가 ServletRequest에 보관한다.
    // 그래서 JSP에서 꺼내 쓸 수 있는 것이다.
  }
  @RequestMapping(value="ok8")
  public void ok8(Model store, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    store.addAttribute("name", "홍길동");
    store.addAttribute("age", 20);
    out.println(store);
    out.println("ok8");
    
  }
  
  // 클라이언트가 보낸 데이터를 꺼내기
  @RequestMapping(value="ok9")
  public void ok9(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    
    out.println("ok9");
    out.printf("name : %s\n", request.getParameter("name"));
    out.printf("age : %d\n", Integer.parseInt(request.getParameter("age")));
    out.printf("working: %b\n", Boolean.parseBoolean(request.getParameter("working")));
  }
  
  //클라이언트가 보내는 데이터의 이름가 동일한 이름으로 파라미터 변수를 선언한다.
  // 그러면, 프론트 컨트롤러가 파라미터 이름과 같은 데이터를 찾아서
  // 호출할 때 꼽아준다.
  // 프론트 컨트롤러는 문자열을 원시타입의 값으로 자동으로 바꿔준다.
  // 그 외의 타입에 대해서는 오류 발생!
  // 해결책? 웹 파라미터 타입 변환기를 설치해야 한다.
  @RequestMapping(value="ok10")
  public void ok10(String name, int age, boolean working, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("ok10");
    out.printf("name : %s\n", name);
    out.printf("age : %d\n", age);
    out.printf("working: %b\n", working);
  }
  
}
