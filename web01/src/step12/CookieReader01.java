package step12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/step12/CookieReader01")
public class CookieReader01 extends HttpServlet{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  /* 쿠키 보내기 1
   * => 쿠기(Cookie)?
   *    - 웹서버가 웹브라우저에게 보내는 데이터이다.
   *    - 웹브라우저는 웹서버로부터 받은 쿠키 데이터를 내부 메모리 또는 별도의 폴더에 저장한다.
   *    - 그리고 그 웹 서버를 방문할 때 마다 쿠키를 요청 헤더에 담아 다시 전달한다.
   *    
   *    
   *    Cookie:c1=aaaaaa
   *    
   *    
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    resp.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = resp.getWriter();
    /*  1) 요청 헤더에서 쿠키 정보를 추출하기
     * => 웹브라우저가 쿠키를 보내지 않았다면, null을 리턴한다.
     */
    Cookie[] cookies = req.getCookies();
    //2) 읽은 쿠키 정보 출력하기
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.printf("%s = %s, %s , %s, %s\n", 
            cookie.getName(),
            cookie.getValue(), // 쿠키 값
            cookie.getDomain(), // 쿠키의 사용 범위(도메인)
            cookie.getPath(), // 쿠키의 사용 범위(경로)
            cookie.getMaxAge() // 쿠키의 생존 날짜
            );
      }
    }else {
      out.println("쿠키가 하나도 없습니다.");
    }
    
  }
}


/* URL 인코딩?
 * => 7비트만 처리할 수 있는 장비를 고려하여,
 *      8비트 데이터를 보낼 수 있게 만드는 인코딩 기술이다.
 * => 8비트 값을 7비트화 시키는 것을 "URL 인코딩"이라 부른다.
 * 
 * => 방법
 *      문제) 보내려는 데이터가 영어 알파벳 'A' 라고 가정하자!
 *            'A'의 코드 값 : 0x41 (01000001) <-- 7비트 장비를 통과하더라도 데이터를 잃지 않는다.
 *            '가' 의 코드 값: 0xAC00(10101100 00000000) <---- 7비트 장비 통과후 데이터가 깨진다.
 *      해결) 
 *            '가'의 코드 값 (0xAC00)을 ASCII 문자화 시킨다.
 *              유니 코드 값을 그대로 ASCII 문자화 시킨다면,
 *                => %AC%00 : %(25) A(41) C(43) %(25) 0(30) 0(30)
 *             2 바이트를 보내면 될 것을 ASCII 문자화 시키면 6바이트를 보내야 한다.
 *             보내는 데이터의 크기는 커지지만 7비트 장비를 무사히 통과할 수 있다.
 * => GET 또는 POST 요청할 때 보내는 데이터는 웹 브라이주거 자동으로 URL 인코딩한다.
 *      개발자가 따로 인코딩/디코딩 할 필요가 없다.
 * => 단, 쿠키로 데이터를 보낼 때는 개발자가 인코딩 해줘야 하고,
 *      그것을 다시 읽을 때는 개발자가 디코딩을 해줘야 한다.
 */