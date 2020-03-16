<%@page import="com.bit.myhome.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 읽기</title>
</head>
<body>
<%
//세션 불러오기 :다운 캐스팅 필요
String strVar = (String)session.getAttribute("strVar");
Integer intVar = (Integer)session.getAttribute("intVar");
UserVO user = (UserVO)session.getAttribute("user");
%>
<p>문자열 세션: <%= strVar %></p>
<p>정수 세션: <%= intVar %></p>
<p>객체 세션: <%= user %></p>

<a href="session_delete.jsp">세션 삭제</a>
</body>
</html>