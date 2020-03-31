package com.softtek.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softtek.model.Cache;

@WebServlet("/login/status")
public class LoginStatusServlet extends HttpServlet {

	@Inject
	private Cache cache;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = (String) cache.getFromCache("username");
		req.setAttribute("username", username);
		RequestDispatcher dispatcher = 
				getServletContext().getRequestDispatcher("/WEB-INF/login_status.jsp");
		
		dispatcher.forward(req, resp);
	}
}
