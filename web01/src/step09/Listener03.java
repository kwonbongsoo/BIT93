/* 웹 애플리케이션 구성 요소 - ServletContextListener
 *  1) 서블릿
 *    - 클라이언트 요청 처리
 *  2) 필터
 *    - 요청 처리 전/후에 작업 수행
 *  3) 리스너 (= event handler)
 *    - 특정 상태(event)에 놓일 때 작업 수행
 * 
 * ServletContextListener?
 *  - 웹 애플리케이션이 시작되거나 종료되는 상태에 대해 작업을 수행한다.
 *  
 *  리스너 배치하기
 *    1) web.xml에 등록하기
                  <!--  
                  <listener>
                    <listener-class>step09.Listener01</listener-class>
                  </listener>
                  -->
 *    2) 애노테이션으로 등록하기
 */
package step09;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class Listener03 implements ServletRequestAttributeListener{

  @Override
  public void attributeAdded(ServletRequestAttributeEvent srae) {
    // ServletRequest 객채에 값을 저장할 때 호출된다.
    System.out.printf("====> Listener03.aattributeAdded(ServletRequestAttributeEvent srae): %s=%s\n",
        srae.getName(), srae.getValue());
  }

  @Override
  public void attributeRemoved(ServletRequestAttributeEvent srae) {
    // ServletRequest 객체에서 값을 제거할때 호출된다.
    System.out.println("====> Listener03.attributeRemoved(ServletRequestAttributeEvent srae)");
    
  }

  @Override
  public void attributeReplaced(ServletRequestAttributeEvent srae) {
    // ServletRequest 객체에 저장된 값을 변경 할떄  호출된다
    System.out.println("====>  Listener03.attributeReplaced(ServletRequestAttributeEvent srae)");
  }

}
