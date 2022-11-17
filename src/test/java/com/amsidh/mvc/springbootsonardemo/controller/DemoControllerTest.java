package com.amsidh.mvc.springbootsonardemo.controller;

import com.amsidh.mvc.springbootsonardemo.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = {DemoController.class})
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void hello() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/demo").accept(MediaType.TEXT_PLAIN);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Assertions.assertEquals("Hello World Springboot Demo App", response);
    }

    @Test
    void getPerson() throws Exception {

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/demo/person/{personId}","123").accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
        String expectedResponse = mvcResult.getResponse().getContentAsString();
        String person= "{\"personId\":\"123\",\"personName\":\"Amsidh\",\"age\":38}";
        Assertions.assertEquals(person, expectedResponse);
    }
}