<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 결과</title>
</head>
<body>
  <h1>페이지1</h1>
  <form action="ok4.do" method="post">
    이름: ${member.name}<br>
    나이: ${member.age}<br>
    백수냐: <input type="radio" name="working" value="true">재직중
              <input type="radio" name="working" value="false" checked>백수<br>
    <button>다음</button>
  </form>
</body>
</html>