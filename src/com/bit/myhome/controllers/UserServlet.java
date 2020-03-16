package com.bit.myhome.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.myhome.dao.UserDao;
import com.bit.myhome.dao.UserDaoimpl;
import com.bit.myhome.vo.UserVO;
@WebServlet("/users")
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		
		if("joinform".equals(action)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/users/joinform.jsp");
			rd.forward(req, resp);
		}else if ("joinsuccess".equals(action)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/users/joinsuccess.jsp");
			rd.forward(req, resp);
		}else if("loginform".equals(action)) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/users/loginform.jsp");
			rd.forward(req, resp);
		}else if("logout".equals(action)) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect(req.getContextPath());
		}
		
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("a");
		
		if("join".equals(action)) {
			//가입 처립
			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String gender = req.getParameter("gender");
			
			UserVO user =new UserVO(name, password, email, gender);
			UserDao dao = new UserDaoimpl();
			boolean isSuccess =dao.insert(user);
			
			if(isSuccess) {
				resp.sendRedirect(req.getContextPath() + "/users?a=joinsuccess");
			}else {
				//가입실패
				resp.sendRedirect(req.getContextPath() + "/users?a=joinform");
			}
		}else if("login".contentEquals(action)) {
			//uservo를 dao로부터 받아오기
			//uservo가 null이 아니면 ->session에 세팅 -> /
			//null이면 -> /users?a=loginform으로 리다이렉트
			String email = req.getParameter("email");
			String password = req.getParameter("password");		
			UserDao dao = new UserDaoimpl();
			
			UserVO user = dao.getUserByIdAndPassword(email, password);
			if(user != null) {
				//사용자가 있다 -> 세션 설정
				HttpSession session = req.getSession();
				session.setAttribute("loginUser", user);
				resp.sendRedirect(req.getContextPath());
			}else {
				//사용자가 없다 -> 로그인 폼으로 리다이렉트
				resp.sendRedirect(req.getContextPath() + "/users?a=loginform&result=fail");
			}
				
		}else {
			resp.sendError(405);
		}
		
	}
	
}
