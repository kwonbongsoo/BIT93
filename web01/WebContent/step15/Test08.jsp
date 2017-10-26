<%-- JSP 구성 요소
  1) 템플릿 데이터 
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시어(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
    - JSP 파일을 이용하여 만든 서블릿 클래스에 빌드나 메서드를 추가하고 싶을 때 사용한다.
    - <%! 자바코드 %>
     자바 서블릿:
     class 서블릿 extends .... {
      자바 코드
      }
      
     - _jspService() 메서드 안에 놓여지는 것이 아니라,
      class 블록 안에 놓여진다.
      따라서 클래스 블록 안에 작성할 수 있는 것은 모두 된다.
    - 그래서 태그를 선언하는 순서는 상관없다.
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
  8) EL (Expression Language)
  9) JSP 주석
 --%>
 <%! String name = "홍길동"; %>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%!int age = 20; %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>Expression 엘리먼트</h1>
name: <%= name %>
age: <%= age%>
<%plus(10, 20); %>
10 + 20 = <%= result %><br>
</body>
</html>
<%  %> <!-- 이거는 _jspService 메서드안에 들어간다, -->
<%!
 int result;
void plus(int a, int b) {
  this.result = a+ b;
}
%>