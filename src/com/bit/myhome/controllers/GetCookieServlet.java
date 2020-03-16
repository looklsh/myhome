package com.bit.myhome.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/get")
public class GetCookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		//a parameter확인
		//a=delete이면 쿠키 삭제
		//없으면 해당 요청 내의 쿠키확인
		String action = req.getParameter("a");
		if("delete".equals(action)) {
			//쿠키 삭제
			//허용시간을 0으로 설정, 사용불가하게 만든다
			Cookie[] cookies = req.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("testCookie")) {cookie.setMaxAge(0);
																resp.addCookie(cookie);
					PrintWriter out = resp.getWriter();
					out.println("<p>쿠키를 삭제했습니다</p>");
					}
				}
			}
		}else {
			//쿠키 내용 확인
			Cookie[] cookies = req.getCookies();
			if(cookies != null) {
				PrintWriter out = resp.getWriter();
				for (Cookie cookie: cookies) {
					out.printf("%s: %s%n", cookie.getName(), URLDecoder.decode(cookie.getValue(), "UTF-8"));
					out.println("<br/>");
				}
			}
		}
		
	}
	
}
