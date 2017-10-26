/* service() 파라미터 : Servlet 2 - 파라미터 값 전달하고 받기
 * => GET 요청 파라미터 값 전달하기
 *      - URL에 붙여 전달한다.
 *      - 예) http://localhost:8080/web01/Servlet02?파라미터명=값&파라미터명=값
 * => POST 요청으로 파라미터 값 전달하기
 *      - message-body 에 붙인다.
 *      - 예)
 *        POST /step02/Servlet02 HTTP/1.1
 *        HOST: ....
 *        User-Agent: ....
 *        
 *        파라미터명=값&파라미터명=값
 *        
 *        
 * => 테스트
 *      - http://localhost:8080/web01/step02/Servlet02.html
 */
package step02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/step02/Servlet02")
public class Servlet02 extends GenericServlet{
  private static final long serialVersionUID = 1L;

  public Servlet02() {
   System.out.println("Servlet02()");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.printf("parameter(name): %s\n", req.getParameter("name")); // url 뒤에 ?name=zzzz&age=123
    System.out.printf("parameter(age): %s\n", req.getParameter("age"));
    
  }
}
