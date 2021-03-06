/* 파일 업로드 : POST 요청 데이터 형식 - application/x-www-form-urlencoded 
 * => multipart/form-data
 *      - 웹 브라우저에서 웹 서버에게 바이너리를 포함한 데이터를 보낼 때 사용하는 인코딩 방식
 *      - 보내는 요청 방식은 POST다.
 *      - 그러나 일반적인 형식인 "변수=값&변수=값&...이 아닌,
 *        바이너리 ㄱ데이터를 보내기 적합한 형식으로 보낸다.
 * =>application/x-www-form-urlencoded
 *      - POST 요청 방식으로 웹 서버에 보낼 때 사용하는 기본 인코딩 방식
 *      - 예) name=ABC%EB%B0
 *      - file 타입의 입력값을 서버에 보내면, 단지 파일의 이름만 서버에 전달된다.
 *      - 즉 서버에 바이너리 데이터를 보내지 않는다.
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
@WebServlet("/step14/Servlet01")
@SuppressWarnings("serial")
public class Servlet01 extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    //포스트 방식은 이렇게 해야 한글로 나온다.
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
