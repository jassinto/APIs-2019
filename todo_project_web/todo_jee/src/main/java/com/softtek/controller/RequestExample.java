package com.softtek.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestExample")
public class RequestExample extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // Read HTTP headers
	    String strHost = req.getHeader("Host");
	        
	    // Read parameters from query string: /someapp/someservlet?uid=mario
	    String strName = req.getParameter("uid");
	    
	    resp.setContentType("text/json");
	    resp.getWriter().write(String.format("{ \"Host\" : \"%s\", \"parameter\": \"%s\" }", 
	    		strHost, strName));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
	    String strName = req.getParameter("name");
	    resp.getWriter().write(String.format("Name : %s", strName));
	}

	
}
