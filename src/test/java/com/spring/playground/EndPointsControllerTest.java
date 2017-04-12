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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EndPointsController.class)

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