<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:useBean
  1) 템플릿 데이터 
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시어(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
      => c:out
         => 출력문을 만드는 태그
  8) EL (Expression Language)
  9) JSP 주석
 --%>
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
<h1>JSTL c:out 태그 사용법</h1>
<% // PageContext 보관소에 값을 저장한 후 그 값을 출력해 보자!
pageContext.setAttribute("name", "홍길동");
%>
<c:set var="name" value="임꺽정1" />
<c:set var="name" value="임꺽정2" scope="page" /> <%-- pageContext --%>
<c:set var="name" value="임꺽정3" scope="request" /> <%-- servletRequest --%>
<c:set var="name" value="임꺽정4" scope="session"/> <%-- HttpSession --%>
<c:set var="name" value="임꺽정5" scope="application"/> <%-- ServletContext --%>
기본<c:out value="${pageScope.name}"/><br>
pageContext<c:out value="${pageScope.name}"/><br>
ServletRequest<c:out value="${requestScope.name}"/><br>
HttpSession<c:out value="${sessionScope.name}" /><br>
ServletContext<c:out value="${applicationScope.name}" /><br>
</body>
</html>