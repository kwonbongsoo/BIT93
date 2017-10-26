/* Spring WebMVC : Request Handler (요청을 처리하는 메서드)의 파라미터들 4 - 커스텀 프로퍼티 에디터2
 *  => 커스텀 프로퍼티 에디터를 등록하는 방법
 *  1) 각각의 페이지 컨트롤러에 @InitBinder 애노테이션이 붙은 메서드 만들기
 *        => Controller13.java 참고!
 *  2) WebBindingInitializer 인터페이스를 구현한 클래스를 만들어 설정 파일에 등록하기
 *        => MyWebBindingInitializer.java와 application-context.xml 파일 참고
 *  3) 페이지 컨트롤러가 작업하기 전에 충고를 하는 클래스 만들기
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
@RequestMapping("/control/controller13/")
public class Controller13 {
  
  // 클라이언트가 보낸 파라미터 값은 문자열이다.
  // 프론트 컨트롤러는 이 문자열은 페이지 컨트롤러의 메서드를 호출할 때 파라미터 타입에 맞춰 변환해 준다.
  // 단 원시 타입(byte, short, long, float, double, char)으로만 변환해준다.
  
  // 1) 변환기 설치전
  //     String --->java.sql.Date으로 자동 변환 가능
  @RequestMapping(value="ok01")
  public void ok01(java.sql.Date date, boolean working, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("ok01");
    out.printf("date: %s\n", date.toString());
  }
  
  @RequestMapping(value="ok02")
  public void ok02(
      String name, // requestParam 이 붙지않으면 선택사항이다.
      java.util.Date date, 
      boolean working, 
      HttpServletRequest request, // HttpServlet 서블릿 변수에대해서는 initBinder함수가 실행되지 않는다.
      HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("ok02");
    out.printf("date: %s\n", date.toString());
  }
  // @InitBinder가 붙은 메서드는
  // 클라이언트에서 보낸 각각의 요청 파라미터에 대해  요청 핸들러의 아규먼트 값으로 바꿀 때 마다 호출된다.
  // => 기능? 요청 파라미터를 아규먼트 값으로 바꿔주는 변환기를 등록한다.
  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    System.out.println("initBinder()....");
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      dateFormat.setLenient(false);
      // 다음 메서드를 호출하여 String --> java.util.Date 객체로 바꾸는 변환기를 등록한다.
      binder.registerCustomEditor(
          java.util.Date.class, /* 현재 페이지 컨트롤러의 요청 처리기의 아규먼트 타입 */
         // 첫 번째 파라미터: 문자열을 변환하여 만들 객체의 타입
          new CustomDateEditor( // 이 프로퍼티 변환기는 스프링에서 기본으로 제공 --> java.util.Date
              dateFormat, // yyyy-MM--dd 형식으로 된 무자열을 분석하여 java.util.Date 객체 생성
              false/* 파라미터 값 필수!*/)
          );
  }
}
