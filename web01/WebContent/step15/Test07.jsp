<%-- JSP 구성 요소
  1) 템플릿 데이터
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
    - 어떤 결과를 출력하는 코드를 만들고 싶을 때 사용한다
    - <%= 표현식 %>
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
  8) EL (Expression Language)
  9) JSP 주석
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String name = "홍길동"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>Expression 엘리먼트</h1>
name: <%= "$$" + name + "**" %>

</body>
</html>