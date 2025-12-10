package com.test.code_test_instructions.controllers;

import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.services.UrlBeanProcessingService;
import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tools.jackson.databind.ObjectMapper;


import java.net.URL;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@WebMvcTest(controllers = URLHandlingController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class URLHandlingControllerTest {
   /*
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private UrlBeanProcessingService urlBeanProcessingService;


    @Test
    public void createCustomURLTest() throws Exception {
        URL originalUrl = new URL("http://google.com");
        URL customURL = new URL("http://Mygoogle.com");
        URLBean urlBean = new URLBean(originalUrl, customURL);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/customizeTheURL)")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(urlBean))

        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getOriginalUrlTest() throws Exception {
        URL CustomizedURL = new URL("http://Mygoogle.com");

        mockMvc.perform(
                MockMvcRequestBuilders.get("/customizeTheURL)")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(CustomizedURL))

        ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void deleteURLRecordTest() throws Exception {
        URL CustomizedURL = new URL("http://Mygoogle.com");

        ResultActions resultActions;
        resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/customizeTheURL)")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(objectMapper.writeValueAsString(CustomizedURL))


        ).andExpect(MockMvcResultMatchers.status().isOk());

    }
*/
}
