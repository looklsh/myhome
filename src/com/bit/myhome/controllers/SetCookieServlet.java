package com.bit.myhome.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/set")

public class SetCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//cookie 를 만들고 response로 쿠키를 전송
		PrintWriter out =resp.getWriter();
		out.println("<h1>Cookie 저장</h1>");
		
		//쿠키설정: 브라우저 식별을 위한 작은 저장소(브라우저에 저장됨)
		Cookie c= new Cookie("testCookie", URLEncoder.encode("Servlet에서 쿠키를 저장합니다.","UTF-8"));
		//쿠키 유지시간 (초)
		c.setMaxAge(24 * 60 * 60);
		out.printf("<p>%s를 쿠키 이름 %s로 저장했습니다.</p>", c.getValue(), c.getName());
		//응답과 함께 쿠키 전송
		resp.addCookie(c);
		out.println("<p>쿠키를 브라우저로 전송했습니다.</p>");
	}
	
}
