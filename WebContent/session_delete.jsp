<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 삭제</title>
</head>
<body>
<%
session.invalidate();
//세션 무효화
%>
<p>세션을 삭제했습니다</p>
<a href="session_read.jsp">세션 읽ㄱ기</a>
<a href="session_write.jsp">세션 저장</a>
</body>
</html>