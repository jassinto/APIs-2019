package com.crud.softtek.integrationTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.crud.softtek.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Attempt of perform an integration test which does not work Dx
 * 
 * @author jasso
 *
 */
public class IntTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testSuccessCreateTask() throws JsonProcessingException, Exception {
		Task task= new Task();
		task.setTitle("MMM");
		task.setDescription("Hdz");
		
		mockMvc.perform(post("todo/api/v1/json/today").
				contentType("application/json").
				content(objectMapper.writeValueAsString(task))).
		andExpect(status().isOk()).
		andExpect(jsonPath("$.Title", is("MMM")));
	}

}
	
