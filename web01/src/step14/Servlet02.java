/* 파일 업로드 : POST 요청 데이터 형식 - application/x-www-form-urlencoded 
 * => multipart/form-data
 *      - 웹 브라우저에서 웹 서버에게 바이너리를 포함한 데이터를 보낼 때 사용하는 인코딩 방식
 *      - 보내는 요청 방식은 POST다.
 *      - 그러나 일반적인 형식인 "변수=값&변수=값&...이 아닌,
 *        바이너리 ㄱ데이터를 보내기 적합한 형식으로 보낸다.
 *      - 형식:
 *          => 바이너리 데이터구분하기 위해 각 데이터를 특별한 구분자를 사용하여분리한다.
 *               그리고 그 구분자사이에 데이터를 넣는다.
 *               1) 웹 서버에 데이터를 보낼 때 어떤 구분자를 사용할 지 요청 헤더에 알려준다.
 *                예) Content-Type: multipart/form-data; boundary=------WebkitFormBoundary41F
 *                2) message-body 순서에 데이터를 보낼 때 위에서 정의한 구분자를 사용한다.
 *                 예)-------------몰라
 *                 ---------------몰라
 *                 (빈줄)
 *                 홍길동
 * =>application/x-www-form-urlencoded
 *      - POST 요청 방식으로 웹 서버에 보낼 때 사용하는 기본 인코딩 방식
 *      - 예) name=ABC%EB%B0
 *      
 *      
 *      숫자를 아스키코드화 시키화 8비트가 아닌 7비트 아스키코드를 바꾸는 것을 url인코딩이라고 한다.
 */
package step14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/step14/Servlet02")
@SuppressWarnings("serial")
public class Servlet02 extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    //포스트 방식은 이렇게 해야 한글로 나온다.
    
    // multipart 형식으로 받은 데이터는 getParameter()를 호출하여 값을 꺼낼 수 없다.
 // multipart 형식의 데이터를 별도로 처리해야한다.
    // 그러나 안타깝게도 Servlet API 에서는 멀티파트 데이터를 처리하는 기능이 없다.
    // 해결책?
    // - 개발자가 직접 클라이언트가 보낸 데이터를 해석해서 처리하라!
    // - 우린 기존의 개발자가 만들어 놓은 도구를 사용하겠다.
    //   apache.org 사이트에서 제공하는 도구를 사용해보자!
    
    // 어찌 되었든, 그 도구를 사용하여 요청 데이터를 처리하기 전까지는 
    // getParameter()의 값은 null이다.
    
    String name = req.getParameter("name");
    String file1 = req.getParameter("file1");
    String file2 = req.getParameter("file2");
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    out.printf("name = %s\n", name);
    out.printf("file1 = %s\n", file1);
    out.printf("file2 = %s\n", file2);
  }
}
