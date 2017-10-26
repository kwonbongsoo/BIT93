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
  <h1>파일업로드 결과</h1>
  name: ${name}<br>
  age: ${age}<br>
  file1: ${file1}<br>
  <img id="img1"  height="150"><br>
  file2: ${file2}<br>
  <img id="img2"  height="150"><br>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script>
   setTimeout(()=> {
	   $("#img1").attr("src", "${pageContext.request.contextPath}/upload/${file1}")
	   $("#img2").attr("src", "${pageContext.request.contextPath}/upload/${file2}")
   },5000)
  </script>
</body>
</html>