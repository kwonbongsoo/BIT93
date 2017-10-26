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
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<!DOCTYPE html>
<html>
<head>
<%
int i = 20;
int j = 30;
%>
<meta charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>안녕하세요</h1>
<%
out.write("=>" + i * j);
%>
</body>
</html>