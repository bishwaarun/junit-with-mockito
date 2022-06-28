package com.mrcoder.junit.mockito.controller;

import com.mrcoder.junit.mockito.controllers.HelloWorldController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void helloWorld_basis() throws Exception {
        // call GET 'hello-world'  application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/hello-world")
                .accept("application/json");
        MvcResult mvcResult =  mockMvc.perform(requestBuilder).andReturn();
        // verify Hello World
        Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void helloWorld_response_matchers() throws Exception {
        // call GET 'hello-world'  application/json
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/hello-world")
                .accept("application/json");
        MvcResult mvcResult =  mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andReturn();
        // verify Hello World
        //Assertions.assertEquals("Hello World",mvcResult.getResponse().getContentAsString());
    }
}
