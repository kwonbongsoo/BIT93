<%-- JSP 구성 요소
  1) 템플릿 데이터 
    - 화면에 출력할 콘텐츠
    - 아래에 지정된 문법을 제외하고 JSP 파일에 그냥 작성하는 모든 텍스트는 템플릿 데이터이다.
    - 자바 코드 
      out.write("템플릿데이터");
      out.printl("템플릿데이터");
      다음과 같이 출력문을 만든다.
      - 템플릿 데이터를 가지고 만든 코드는 _jspService() 메서드에 순서대로 삽입된다.
      
  2) 스크립트릿(scriptlet) 엘리먼트
  3) 지시(diretive) 엘리먼트
     - <% page %>
      language 속성 : 스크립트릿 등에서 사용하는 프로그래밍 언어가 무엇인지 지정.
                           현재 java 밖에 안된다.
                           원래 의도는 다른 프로그래밍 언어를 사용할 경우도 고려했다.
        contentType 속성 : response.setContentType()
        pageEncoding 속성 : JSP 파일이 어떤 인코딩으로 저장되었는지 저장한다.
                                   JSP 엔진이 자바 서블릿 파일을 만들 때 참조한다.
        trimDirectiveWhitespaces 속성: JSP 태그를 상응한 후 줄 바꿈 코드가 있을 때 제거 여부
        buffer 속성:
            출력 스트림의 기본 버퍼 크기를 지정한다.
            기본이 8kb
        import 속성:
            import 문을 추가할 때 사용
            콤마(,)로 여러 개의 패키지를 지정할수 있다.
            또는 여러 개의 <
     - <% include %> : 
        file 속성:
          이 속성에 지정된 파일을 그대로 읽어서 jsp 파일에 이 태그가 있는  그 자리에 그대로 포함시킨다.
          그런후 자바 서블릿 클래스를 만든다
          참고로 <jsp:include>는 requestDispatcher의 include()를 호출한 것과 같다.
          지정된 파일이 jsp라면 실행할것이고, 일반 텍스트라면 그대로 그 내용을 출력할 것이다.
     - <%taglib %> : 
  4) 표현식 (expression) 엘리먼트
  5) 선언문 (declaration) 엘리먼트
  6) JSP 액션 태그
  7) JSP 확장 태그 (JSTL)
  8) EL (Expression Language)
  9) JSP 주석
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>지시 엘리먼트 </h1>
<hr>
<% String name = "홍길동"; %>
<%@ include file="a.jsp" %>
<hr>
<%--  
<jsp:include page="a.jsp" />
--%> 
</body>
</html>