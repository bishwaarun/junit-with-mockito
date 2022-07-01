package com.mrcoder.junit.mockito.controller;

import com.mrcoder.junit.mockito.controllers.ItemController;
import com.mrcoder.junit.mockito.models.Item;
import com.mrcoder.junit.mockito.services.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(1,"Item1",10,20),
                        new Item(2,"Item2",11,21)
                ));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-item-from-database")
                .accept("application/json");
        MvcResult mvcResult =  mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1,name:Item1,price:10},{id:2,name:Item2,price:11}]"))
                .andReturn();
    }

    @Test
    public void itemFromBusinessService_basis() throws Exception {
        when(itemBusinessService.readHardCodedItem()).thenReturn(new Item(1,"Car"));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept("application/json");
        MvcResult mvcResult =  mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1,name:Car}"))
                .andReturn();
    }

    @Test
    public void dummyItem_basis() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept("application/json");
        MvcResult mvcResult =  mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Tea\"}"))
                .andReturn();
    }
}
