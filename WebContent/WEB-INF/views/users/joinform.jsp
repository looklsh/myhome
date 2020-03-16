<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 폼</title>
</head>
<body>
<!-- header 동적 포함 -->
	<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
	
	<form name="joinform" method="post" action="<%=request.getContextPath() %>/users">
	
	<input type="hidden" name="a" value="join">
	<label for="name">이름</label>
	<input type="text" name="name"><br/>
	<label for="password">암호</label>
	<input type="password" name="password"><br>
	<label for="email">이메일</label>
	<input type="text" name="email"><br>
	<fieldset>
	<legend>약관동의</legend>
	<label>여</label>
	<input type="radio" name="gender" value="F" checked>
	<label>남</label>
	<input type="radio" name="gender" value="M">
	</fieldset>
	<input type="submit" value="가입">
	<input type="reset" value="다시 작성">
	</form>
	<!-- footer -->
	<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
</body>
</html>