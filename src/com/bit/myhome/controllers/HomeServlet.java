package com.bit.myhome.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action = req.getParameter("a"); //처음엔 작성 안했는데? 파라미터값 넣으면서 넣음. 지워도 되는지는 확인 못하겠음
		
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/myhome/home.jsp");
			rd.forward(req, resp);
	}
			
		
	
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
}
