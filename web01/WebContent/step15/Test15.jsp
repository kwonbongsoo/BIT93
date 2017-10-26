<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:useBean
  1) 템플릿 데이터 
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시어(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
    - JSP에서 기본으로 제공하는 액션 태그만으로 프로그래밍 할 때 부족하기 때문에
      공식적으로 추가해서 만든 태그이다.
    - 이 태그를 사용하려면 이 태그를 처리하는 클래스들, 즉 JSTL 구현 라이브러리를
      다운로드 받아야 한다.
    - 여러 JSTL 구현체가 있지만, 대부분 apache.org에서 만든 것을 사용한다.
    - 그리고 JSP 페이지에서 이 라이브러리를 사용하려면
      1) 웹 애플리케이션 라이브러리로 포함시켜야 한다.
          => /WEB-INF/lib/ 폴더에 라이브러리 파일을 두라는 얘기다.
      2) JSP 페이지 에서 이 라이브러리의 어떤 태그를 사용할 것인지 선언해야 한다.
          => <%@ taglib %> 태그를 사용하여 라이브러리 정보를 선언하라는 얘기다.
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
<h1>JSTL 개요</h1>




</body>
</html>