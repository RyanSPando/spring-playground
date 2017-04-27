package com.spring.playground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndPointsController.class)

@ContextConfiguration(classes = {EndPointsController.class})
public class EndPointsControllerTest {

    @Autowired
        private MockMvc mvc;

	@Test
	public void rootLoads() throws Exception {
		this.mvc.perform(get("/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello from Spring!"));
	}

	@Test
	public void testPostMessageEndpoint() throws Exception {
		this.mvc.perform(post("/messages"))
				.andExpect(status().isOk())
				.andExpect(content().string("Post Return"));
	}


	@Test
	public void testPutMessageEndpoint() throws Exception {
		this.mvc.perform(patch("/messages"))
				.andExpect(status().isOk())
				.andExpect(content().string("Patch Return"));
	}

	@Test
	public void testDeletetMessageEndpoint() throws Exception {
		this.mvc.perform(delete("/messages"))
				.andExpect(status().isOk())
				.andExpect(content().string("Delete Return"));
	}
}