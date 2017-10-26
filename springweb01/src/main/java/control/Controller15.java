/* Spring WebMVC : Request Handler의 리턴 값 다루기
 * => 리턴 타입으로 가능한 것들
 *    1) ModelAndView
 *    2) Model, Map
 *    3) 
 */
package control;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/control/controller15/")
public class Controller15 {
  
 // 1) void : 요청 핸들러에서 직접 출력하기
  @RequestMapping(value="ok1")
    public void ok01(HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("ok1() 안녕하세요");
  }
  
  
  // 1) String : 리턴 값을 클라이언트로 보내기
  @RequestMapping(path="ok2", produces="text/plain;charset=UTF-8")
  @ResponseBody// <=== 리턴 값이 응답 데이터임을 표시하는 애노테이션
  // 리턴 값을 바로 출력할 때는 @RequestMapping의 produces 속성을 이용하여
  // 뭐를 출력하는지 알려줘야한다.
    public String ok02() throws Exception{

    return "ok2() 안녕하세요";
  }
  
  
//1) void : 요청 핸들러에서 직접 출력하기
 @RequestMapping(value="ok3")
 @ResponseBody 
   public String ok03(HttpServletResponse response) throws Exception{
   //@ResponseBody를 사용하여 리턴 값을 바로 클라이언트로 출력할 때는
   // 다음과 같이 UTF-8 처리를 지정할수 없다.
   // 해결책? 위의 ok2() 메서드에서처럼 @RequestMapping의 produces 속성으로 지정해야 된다.
   response.setContentType("text/plain;charset=UTF-8");

   return "ok3() 안녕하세요";
 }
 
 // 4) String : jsp로 포워딩하기
 //   => @ResponseBody가 붙지 않으면 리턴 값을 JSP URL로 취급한다.
 @RequestMapping(path="ok4")
 public String ok4() throws Exception {
//   return "/controller15_ok4".jsp; // InternalResourceViewResolver 를설정하기전엔 ok
   // 설정후에는 오류 발생
   // 왜? 리턴 값 앞뒤에 문자열이 붙기 때문이다.
   // "/" +"/controller15_ok4".jsp" + ".jsp"가 붙는다.
   // 그래서 최종 url은 /controller15_ok4.jsp.jsp 를 찾기 때문에 에러가 뜬다.
   
   // InternalResourceViewResolver의 설정을 고려하여 리턴 값을 결정
   return "/controller15_ok4";
 }
 
 // 5) void : 클라이언트로 출력하지도 않고, JSP URL로 리턴하지 않으면
 // => 기본 JSP URL로 현재 URL과 같은 JSP를 찾는다.
 // => 단 이럴 경우 스프링 설정 파일에 JSP를 어디에서 찾을 것인지 지정해야 한다.
 //      그렇지 않으면 URL이
 @RequestMapping(path="ok5")
 public void ok5() throws Exception {
   System.out.println("ok5");
 }
 
 // 6) JSP URL을 바구니에 담아 리턴하기
 @RequestMapping(path="ok6")
 public ModelAndView ok6() throws Exception {
   ModelAndView mv = new ModelAndView();
   mv.setViewName("controller15_ok6");
   return mv;
 }
 
 // 7) JSP URL과 JSP 사용할 데이터도 함께 ModelAndView 바구니에 담아 리턴하기
 @RequestMapping(path="ok7")
 public ModelAndView ok7() throws Exception {
   ModelAndView mv = new ModelAndView();
   mv.setViewName("controller15_ok7");
   mv.addObject("title", "제목이네요");
   
   Member member = new Member();
   member.setName("홍길동");
   member.setAge(20);
   member.setWorking(true);
   mv.addObject("member", member);
   return mv;
   
   /* 이렇게 모델앤드뷰 바구니에 값을 담아두면,
    * 프론트 컨트롤러는 이 바구니에 담긴 값을 꺼내
    * JSP가 사용할수 있도록 ServletRequest 바구니에 옮긴다.
    */
 }
 
 @RequestMapping(path="ok8")
 public String ok8(Model model) throws Exception {
   model.addAttribute("title", "제목이네요");
   
   Member member = new Member();
   member.setName("홍길동");
   member.setAge(20);
   member.setWorking(true);
   model.addAttribute("member", member);
   return "controller15_ok8";
   
   /* 이렇게 모델앤드뷰 바구니에 값을 담아두면,
    * 프론트 컨트롤러는 이 바구니에 담긴 값을 꺼내
    * JSP가 사용할수 있도록 ServletRequest 바구니에 옮긴다.
    */
 }
 
 @RequestMapping(path="ok9")
 public String ok9(Map<String, Object> map) throws Exception {
   map.put("title", "제목이네요");
   
   Member member = new Member();
   member.setName("홍길동");
   member.setAge(20);
   member.setWorking(true);
   map.put("member", member);
   return "controller15_ok9";
   
   /* 이렇게 모델앤드뷰 바구니에 값을 담아두면,
    * 프론트 컨트롤러는 이 바구니에 담긴 값을 꺼내
    * JSP가 사용할수 있도록 ServletRequest 바구니에 옮긴다.
    */
 }
 
 // 10) 응답 내용을 정교하게 제어하고 싶을 때 HttpEntity나 ResponseEntity를 사용하라!
 @RequestMapping(path="ok10")
 public ResponseEntity<String> ok10() throws Exception {
   HttpHeaders headers = new HttpHeaders();
   headers.add("Content-type", "text/plain;charset=UTF-8");
   headers.add("aaa", "ohora");
   return new ResponseEntity<>(
       "안녕하세요!",
       headers,
       HttpStatus.OK 
       );
   /* 이렇게 모델앤드뷰 바구니에 값을 담아두면,
    * 프론트 컨트롤러는 이 바구니에 담긴 값을 꺼내
    * JSP가 사용할수 있도록 ServletRequest 바구니에 옮긴다.
    */
 }
 
 
 

}
