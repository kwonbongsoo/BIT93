/* Spring WebMVC : 필터 다루기
 * => 어떤 작업을 시작하기 전이나 후에 뭔가를 실행하고 싶을 때 사용하는 기술이 필터이다.
 * => 필터의 종류
 * 1) Servlet 기술에서 제공하는 필터
 *     => 서블릿 실행 전, 후에 뭔가를 삽입하는 기술
 *    javax.servlet.Filter 구현체
 * 2) Spring에서 제공하는 필터
 *    - 인터셉터 : 페이지 컨트롤러 실행 전, 후에 삽입하고 싶을 때 사용한다.
 *    - AOP 객체 : 페이지 컨트롤러 뿐만 아니라 모든 객체의 메서드 호출 전, 후에 뭔가를 삽입하는 기술!
 *     (AOP) Accept-Oriented Programing
 */
package control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/* 야 프론트 컨트롤러야 
 * ServletRequest에 옮겨주는 것을 알고 있다. 고맙다! JSP에서 잘 쓰고 있다.
 * 그런데, 혹시 Model에 저장된 값 중에 이름이 "member2"인 것이 있다면,
 * 그 객체는 ServletRequest 뿐만 아니라 세션에도 보관해주렴
 * 
 */
@WebFilter({"/control/controller22/list.do", "/control/controller22/detail.do"})
public class Controller22_Filter implements Filter{

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub
    System.out.println("Controller22_Filter.init()");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // TODO Auto-generated method stub
    System.out.println("Controller22_Filter.doFilter()========>");
    chain.doFilter(request, response);
    System.out.println("Controller22_Filter.doFilter()<=======");
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    System.out.println("Controller22_Filter.destory()");
  }
  
  
}
