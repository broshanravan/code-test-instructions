package com.test.code_test_instructions.controllers;

import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.services.UrlBeanProcessingService;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import static org.mockito.Mockito.mock;

@SpringBootTest
@AutoConfigureMockMvc
public class URLHandlingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    static UrlBeanProcessingService beanProcessingService;

    @BeforeAll
    static void init() {
        beanProcessingService = mock(UrlBeanProcessingService.class);
    }

    @Test
    public void createCustomURLTest() throws Exception {
        URL originalUrl = new URL("http://google.com");
        //
        URLBean urlBean = beanProcessingService.customizeUrl(originalUrl, "http://Mygoogle.com");
        mockMvc.perform(
                MockMvcRequestBuilders.post("/customizeTheURL)")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(urlBean))

        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getOriginalUrlTest() throws Exception {
        URL CustomizedURL = beanProcessingService.getOriginalUrl("http://Mygoogle.com");
                mockMvc.perform(
                MockMvcRequestBuilders.post("/customizeTheURL)")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CustomizedURL))


        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deleteURLRecordTest() throws Exception {
        URL CustomizedURL = beanProcessingService.getOriginalUrl("http://Mygoogle.com");
        mockMvc.perform(
                MockMvcRequestBuilders.post("/customizeTheURL)")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(CustomizedURL))


        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

  
    



}
