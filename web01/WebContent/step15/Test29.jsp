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
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL c:parseDate 태그 사용법</h1>
<jsp:useBean id="data1" class="java.util.Date"/>
<fmt:formatDate value="${data1}" pattern="yyyy-MM-dd"/><br>
<fmt:formatDate value="${data1}" pattern="MM/dd/yyyy"/><br>
<fmt:formatDate value="${data1}" pattern="MM/dd/yy"/><br>
<fmt:formatDate value="${data1}" pattern="MM/dd/yyyy hh:mm"/><br>
<fmt:formatDate value="${data1}" pattern="MM/dd/yyyy hh:mm" var="str1"/><br>
<h2>${str1}</h2>
</body>
</html>