<%@page import="com.bit.myhome.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
    <!-- jsp내에서 session을 사용하려면 page session=true지정 -->
    <%
    session.setAttribute("strVar", "문자열 세션");
    session.setAttribute("intVar", 2019);
    UserVO user = new UserVO("홍길동", "1234", "looklsh@naver.com", "M");
    session.setAttribute("user", user);
    //어떤 객체든 다 집어넣을 수 있다
    session.setMaxInactiveInterval(2*60*60);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 저장</title>
</head>
<body>
	<p>세션이 저장되었습니다.</p>
	<a href="session_read.jsp">세션 확인</a>
</body>
</html>