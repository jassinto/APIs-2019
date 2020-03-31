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

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

	@Inject
	private Cache cache;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
										.getRequestDispatcher("/login.jsp");
		
		dispatcher.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		cache.addToCache("username", username);
		cache.addToCache("password", password);
		
		resp.sendRedirect(req.getContextPath() + "/login/status");
	}
}
