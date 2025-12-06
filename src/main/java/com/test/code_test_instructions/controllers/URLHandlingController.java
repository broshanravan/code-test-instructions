package com.test.code_test_instructions.controllers;


import com.test.code_test_instructions.beans.URLBean;

import com.test.code_test_instructions.services.UrlBeanProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class URLHandlingController {

    @Autowired
    UrlBeanProcessingService beanProcessingService;

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = " Customized URL successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "409", description = "Customized URL already exists")
            })
    @PostMapping(value = "/customizeTheURL")
    public ResponseEntity<URL> createCustomURL(@RequestParam String originalURLStr, @RequestParam String newCustomizedUrl) throws MalformedURLException {
        URL originalUrl = new URL("http://" + originalURLStr);

        if(!beanProcessingService.customUrlExists(newCustomizedUrl)){
            URLBean urlBean = beanProcessingService.customizeUrl(originalUrl, newCustomizedUrl);
            return ResponseEntity.status(HttpStatus.CREATED).body(urlBean.getCustomizedURL());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new URL("http://" + originalURLStr));
    }


    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = " Customized URL successfully retrieved"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "404", description = "Customized URL does not exist")
            })
    @GetMapping(value = "/getOriginalURL")
    public ResponseEntity<URL> getOriginalUrl(@RequestParam String newCustomizedUrl) throws MalformedURLException {
       URL originalURL= beanProcessingService.getOriginalUrl(newCustomizedUrl);
       return ResponseEntity.status(HttpStatus.FOUND).body(originalURL);
    }


    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = " Customized URL successfully removed"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "404", description = "Customized URL does not exist")
            })
    @DeleteMapping(value = "/deleteUrlRecord")
    public ResponseEntity<URL>  deleteURLRecord(@RequestParam String customizedUrl) throws MalformedURLException {
        URL customizedURL = new URL("http://" + customizedUrl);//beanProcessingService.deleteURLRecord(customizedUrl);
        beanProcessingService.deleteURLRecord(customizedUrl);
        return ResponseEntity.status(HttpStatus.OK).body(customizedURL);
    }


}
