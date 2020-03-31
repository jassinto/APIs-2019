package com.softtek.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.softtek.model.Task;
import com.softtek.service.TaskService;

@WebServlet("/api/v1/json")
public class APIJsonServlet extends HttpServlet {
	
	@Inject
	private TaskService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Task> tasks = service.get();
		
		JSONObject response = new JSONObject();
		JSONArray responseList = new JSONArray();
		
		tasks.forEach( t -> { 
			JSONObject taskJson = new JSONObject(t);
			responseList.put(taskJson);
		});
		
		response.put("response", responseList);
		resp.setContentType("text/json");
		
		PrintWriter out = resp.getWriter();
		out.write(response.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title"); 
		String description = req.getParameter("description");
		int categoryNumber = new Integer(req.getParameter("category"));
		
		Task task = service.create(title, description, categoryNumber);
		JSONObject response = new JSONObject();
		JSONObject taskJson = new JSONObject(task);
		response.put("task", taskJson);
		resp.setContentType("text/json");
		
		PrintWriter out = resp.getWriter();
		out.write(response.toString());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskIdStr = req.getParameter("taskId");
		Long id = new Long(taskIdStr);
		service.delete((long)id);
		
		resp.setStatus(200);
		resp.setContentType("text/json");
		
		JSONObject response = new JSONObject();
		response.put("taskDeleted", id);
		
		PrintWriter out = resp.getWriter();
		out.write(response.toString());
	}	
}
