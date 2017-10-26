/* Spring WebMVC : 페이지 컨트롤러 만들기 
 * => Spring에서 제공하는 프론트 컨트롤러와 협업할 페이지 컨트롤러 만들기
 * => Spring WebMVC 프로젝트 설정
 * => 방법
 *      1) web.xml에 Spring webmvc 프론트 컨트롤러를 설정한다.
 *        /WEB-INF/web.xml
 *      2) Spring 설정 파일을 준비한다.
 *        /src/main/step01/application-context.xml
 *      3) Gradle 설정 파일 준비
 *        build.gradle
 *      4) "gradle eclipse"실행
 *      
 *      
 * => 페이지 컨트롤러 만들기
 *      1) 클래스를 페이지 컨트롤러로 만들기 위해서는 @Controller 애노테이션을 붙인다.
 *      2) 요청이 처리할 메서드 앞에 URL 정보를 붙인다.
 *          - @RequestMapping(URL) 애노테이션을 붙인다.
 */
package control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Controller02 {
  @RequestMapping("/control/controller02/a") //어떤 요청을 처리할 지 표시
  public void service(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("aaa");
  }
  
  @RequestMapping("/control/controller02/b") //어떤 요청을 처리할 지 표시
  public void service2(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("bbbb");
  }
  
  @RequestMapping("/control/controller02/c") //어떤 요청을 처리할 지 표시
  public void service3(HttpServletRequest request, HttpServletResponse response) throws Exception{
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("ccccc");
  }
}
