<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:useBean
  1) 템플릿 데이터 
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시어(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
  8) EL (Expression Language)
  9) JSP 주석
 --%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL forEach 태그 사용법2</h1>
<%-- 범위를 지정하지 않으면 전체를 반복한다. --%>

<c:forEach var="name" items="홍길동,임꺽정,유관순,신채호,윤봉길,안중근,김원봉">
${name}<br>
</c:forEach>
<hr>
<c:forTokens var="name" 
items="홍길동:임꺽정:유관순:신채호:윤봉길:안중근:김원봉"
delims=",:">
${name}<br>
</c:forTokens>
<hr>
<c:forTokens var="name" 
items="홍길동,임꺽정,유관순,신채호,윤봉길,안중근,김원봉"
delims=",:">
${name}<br>
</c:forTokens>

<%-- 특정 구분자로 나열된 문자열을 다룰 때는 forToken을 사용하라 --%>
</body>
</html>
