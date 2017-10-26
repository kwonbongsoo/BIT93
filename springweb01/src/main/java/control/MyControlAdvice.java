package control;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// 스프링 WebMVC 프레임워크에게 요청을 처리할 때 마다 이 클래스에게 조언을 구할 것을 요구한다.
@ControllerAdvice
public class MyControlAdvice {
  
  // 이 클래스에 페이지 컨트롤러를 위한 다양한 충고 작업을 수행하는 코드를 두면 된다.
  
 
  @InitBinder // 다음 충고는 요청 파라미터의 데이터를 요청 핸들러의 아규먼트 값으로 바꿀 때 마다 호출하는 메서드이다.
  protected void initBinder(WebDataBinder binder) {
    System.out.println("MyControlAdvice.initBinder()....");
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
