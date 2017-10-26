package bitcamp.java93.control.json;
/* 로그인 서블릿 : HttpSession 객체 이용하기
 * => 특정 클라이언트 전용 HttpSession 보관소 준비하기
 *      - HttpServletRequest.getSession()
 *      => getSession실행과정
 * => 준비 과정
 *  1) 만약 클라이언트가 쿠키로 세션아이디를 보냈다면,
          1.1) => 만약 클라이언트가 쿠키로 세션아이디를 보냈고,
                     마침 서블릿 컨테이너에 그 세션아이디에 해당하는 HttpSession 객체가 있고,
                   그 HttpSession 객체가 유효하다면
           *        => 그 Httpsession 객체를 리턴한다.
           1.2)  마침 서블릿컨테이너에 그 세션아이디에 해당하는 HttpSession 객체가 있고
                  그 HttpSession 객체가 무효하다면,
                  => 새 HttpSession 객체가 만들어 리턴한다.
           2.3) 무효한 세션아이디라면,
                   => 새 HttpSession 객체를 만들어 리턴한다.
           2. 만약 클라이언트가 쿠키로 세션아이디를 보내지 않았다면,
                   => 새 HttpSession 객체를 만들어 리턴한다.
 */


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import bitcamp.java93.domain.Member;
import bitcamp.java93.service.TeacherService;

@RestController
@RequestMapping("/auth/")
@SessionAttributes(("loginMember"))
public class AuthControl{
  @Autowired
  TeacherService teacherService;
  
  @RequestMapping(path="login", method=RequestMethod.GET)
  public void form() {
    // JSP URL을 리턴하지 않으면, 요청 URL을 JSP URL로 사용한다.
  }
  
  @RequestMapping(path="login", method=RequestMethod.POST)
  public JsonResult login(String userType, String email,String password, String saveEmail, Model model, HttpServletResponse response) throws Exception {

        Member member = null;
        if (userType.equals("teacher")){
          member = teacherService.getByEmailPassword(email, password);

        }
        
        if (member != null) { //로그인 성공
          
          model.addAttribute("loginMember", member);
           // 이메일 저장
           if (saveEmail != null) {
             Cookie cookie2 = new Cookie("email", email);
             cookie2.setMaxAge(60 * 60 * 24 * 7);
             response.addCookie(cookie2);
           } else {
             Cookie cookie2 = new Cookie("email", "");
             cookie2.setMaxAge(0); // 유효기간이 0이면 즉시 무효화시키다. 제거하라는 의미!
             response.addCookie(cookie2);
           }
     
          return new JsonResult(JsonResult.SUCCESS, "ok");
        } else {
          return new JsonResult(JsonResult.FAIL, "fail");
        }
  }
  
  @RequestMapping("logout")
  public JsonResult logout(HttpSession session, SessionStatus status) throws Exception {
    status.setComplete();
    session.invalidate(); // 요청한 클라이언트의 전용 HttpSession 객체를 무효화시킨다.

    return new JsonResult(JsonResult.SUCCESS, "ok");
  }
  
  @RequestMapping("userinfo")
  public JsonResult userinfo(HttpSession session) throws Exception {
    Member loginMember = (Member)session.getAttribute("loginMember");
    return new JsonResult(JsonResult.SUCCESS, loginMember);
  }
  
}
