package com.spring.playground;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QueryController.class)

@ContextConfiguration(classes = {QueryController.class})
public class QueryControllerTest{

    @Autowired
    private MockMvc mvc;

    @Test
    public void testMathPiEndpoint() throws Exception {
        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void mathCalulate_sumsNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=5&y=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5 + 2 = 7"));
    }

    @Test
    public void mathCalulate_subtactsNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=5&y=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5 - 2 = 3"));
    }

    @Test
    public void mathCalulate_multipliesNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=multiply&x=5&y=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5 * 2 = 10"));
    }

    @Test
    public void mathCalulate_dividesNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=divide&x=5&y=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5 / 2 = 2.5"));
    }

    @Test
    public void mathCalulate_defaultSumsNumbers() throws Exception {
        this.mvc.perform(get("/math/calculate?x=5&y=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5 + 2 = 7"));
    }

    @Test
    public void mathCalculate_Sum() throws Exception {
        this.mvc.perform(post("/math/sum?n=3&n=4&n=5"))
                .andExpect((status().isOk()))
                .andExpect(content().string("3 + 4 + 5 = 12"));
    }
}