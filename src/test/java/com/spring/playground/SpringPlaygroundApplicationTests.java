package com.spring.playground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(SpringPlaygroundApplication.class)

public class SpringPlaygroundApplicationTests {

	@Autowired
	private MockMvc mvc;

//	@Test
//	public void rootLoads() throws Exception {
//		System.out.println("this.mvc.perform(get(\"/\") = " + this.mvc.perform(get("/")));
//		this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
//				.andExpect(status().isOk())
//				.andExpect(content().string("This is the endpoint you are looking for"));
//	}

//	@Test
//	public void testPostMessageEndpoint() throws Exception {
//		this.mvc.perform(post("/messages"))
//				.andExpect(status().isOk())
//				.andExpect(content().string("POST to messages route"));
//	}

}
