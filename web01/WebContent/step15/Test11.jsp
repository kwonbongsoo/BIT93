<%-- JSP 구성 요소 : JSP 액션 태그 - jsp:useBean
  1) 템플릿 데이터 
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시어(diretive) 엘리먼트
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
    jsp:useBean
    => JSP에서 기본으로 제공하는 태그이다.
    => 이 태그를 사용하기 위해 따로 라이브러리를 가져오는 taglib를 선언할 필요가 없다.
    => ServletContext(application), HttpSession(session), ServletRequest(request),
         PageContext(page)
        - id 속성: 값을 보관소에 저장할 때 사용할 이름. 변수명으로도 사용.
        - class 속성 : 변수의 타입. 보관소에 객체가 없드면 이 클래스의 인스턴스를 생성함.
                          import를 했는지 여부와 상관없이 반드시 전체 클래스 이름을 적어야 한다.
        - scope 속성: 객체를 꺼내는 보관소를 가리킴. 기본이 PageContext이다.
                          만약 보관소에 객체가 없다면 생성한다.
        - type 속성 : 변수의 타입을 지정한다. type 속성이 없으면 class 속성의 값이
                         변수의 타입이 될 것이다.
                         객체를 생성하지 않는다.
  7) JSP 확장 태그 (JSTL)
  8) EL (Expression Language)
  9) JSP 주석
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSP 액션 태그 - jsp:useBean3</h1>
<jsp:useBean id="list" 
type="java.util.List"
class="java.util.ArrayList"
scope="page"></jsp:useBean>
<%-- 
    위의 태그는 다음과 비슷한 자바 코드를 생성한다.
    java.util.ArrayList list = (java.util.ArrayList)PageContext.getAttribute("list");
    if (list == null) {
      throw new .... // 보관소에 객체가 없으면 예외를 던진다
    }
 --%>

 <%
 out.println(list + "<br>");
  list.add("홍길동");
  list.add("임꺽정");

  
  out.println(list + "<br>");
  for (Object value : list) {
    out.println(value + "<br>");
  }
%>

</body>
</html>