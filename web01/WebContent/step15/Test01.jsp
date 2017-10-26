<%-- JSP란
 => Servlet 클래스를 자동 생성할 때 참고하는 파일
 => 자동 생성?
      hello.jsp ===[JSP 엔진] ===> 서블릿 클래스 생성(ex: hello_jsp.java)
 => JSP 파일을 가지고 언제 자바 서블릿 파일을 생성하는가?
     - 웹브라우저에서 요청했을 때,
     1) JSP에 해당하는 자바 서블릿 파일이 없으면 만든다.
     2) JSP 파일이 변경되었으면 만든다.
=> 자동 생성된 서블릿 파일의 위치
     - 톰켓 서버의 경우: $톰켓홈/work/ 폴더에 있다
=> 결론
    - 결국 JSP 파일을 가지고 서블릿 클래스를 생성한다.
    - JSP가 직접 실행되는 것이 아니라 JSP로 만든 자바 서블릿 클래스가 실행되는 것이다.
    - JSP가 직접 실행되지 않는다.
 => JSP 기술이 등장한 이유?
        - 서블릿에서 콘텐츠를 출력하면 I/O 스트림 클래스를 사용하여 출력 함수를 호출해야 한다.
        - 복잡한 문자열을 출력하려면 자바 코드도 복잡해지고 코드 작성이 번거로워진다.
        - 그래서 자바로 콘텐츠를 출력하는 코드를 자동으로 만들기 위해 등장하였다.
        - 자바 언어를 모르는 사람도 쉽게 서버 프로그램을 작성할 수 있게 도와주기 위해서 등장하였다.
 => 생성된 자바 파일 예: (
 
 =>_jspService() 메서드?
  웹브라우저 요청 => 서블릿 컨테이너가
      => 서블릿 컨테이너가 service() 메서드 호출
      => service()에서 jspService() 메서드 호출
 
 
 
=> JSP 엔진이 JSP 파일을 가지고 서블릿 클래스를 만들때 반드시 지켜야 하는 규칙?
   => 물론 서블릿이 되기 위해서는 javax.servlet.Servlet 인터페이스를 구현하는것은 당연하고,
   => 추가적으로 javax.servlet.jsp.HttpJspPage 인터페이스를 구현해야 한다.
   => HttpJspPage?
        javax.servlet.Servlet
           - void jspInit()
           - void jspDestroy()
           - String getServletConfig()
           - ServletConfig petServletConfig()
        javax.servlet.jsp.JspPage extends Servlet
           - void jspInit()
           - void jspDestroy()
        javax.servlet.jsp.HttpJspPage extends JspPage
           - void _jspService(HttpServletRequest, HttpServletResponse)
           
        => 결국 javax.servlet.Servlet 인터페이스 뿐만아니라
             JspPage, HttpJspPage의 추가된 메서드 까지 구현해야 한다는 의미이다.
        
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>안녕하세요</h1>
</body>
</html>