<%@page import="com.bit.myhome.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page session="true" %>
<h1>MyHome</h1>
<%
//세션 체크
UserVO loginUser = (UserVO)session.getAttribute("loginUser");
if(loginUser == null){
	//로그인 안함

%>
<a href="<%= request.getContextPath() %>/users?a=joinform">회원 가입</a>&nbsp;
<a href="<%= request.getContextPath() %>/users?a=loginform">로그인</a>
<% }else { %>
<p><%=loginUser.getName() %>님, 환영합니다</p>
<p><a href="<%= request.getContextPath() %>/users?a=logout">로그아웃</a>
<% } %>