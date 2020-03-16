<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
	
	<form method="post" action="<%=request.getContextPath() %>/users">
	<input type="hidden" name="a" value="login">
	<label for="email">이메일</label>
	<input type="text" name="email" placeholder="이메일을 입력하세요">
	<br>
	<label for="password">비밀번호</label>
	<input type="password" name="password" placeholder="비밀번호를 입력하세요">
	<br>
	<input type="submit" value="로그인">
	
	</form>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>