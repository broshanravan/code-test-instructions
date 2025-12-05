package com.test.code_test_instructions.controllers;


import com.test.code_test_instructions.beans.URLBean;
import com.test.code_test_instructions.services.UrlBeanProcessingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
public class URLHandlingController {

    @Autowired
    UrlBeanProcessingService beanProcessingService;

    @Operation(
            summary = "This function customises an existing URL accourding user input",
            description = "Customized URL successfully created")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = " Customized URL successfully created"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "409", description = "Customized URL already exists")
            })
    @PostMapping(value = "/customizeTheURL")
    public ResponseEntity<URL> createCustomURL(@PathVariable URL originalURL, @PathVariable String newCustomizedUrl){
        URLBean urlBeam = beanProcessingService.customizeUrl(originalURL, newCustomizedUrl);

        return ResponseEntity.status(HttpStatus.CREATED).body(urlBeam.getCustomizedURL());
    }


    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = " Customized URL successfully retrieved"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "404", description = "Customized URL does not exist")
            })
    @GetMapping(value = "/getCustomizedURL")
    public ResponseEntity<URL> getOriginalUrl(@PathVariable String newCustomizedUrl){
       URL originalURL= beanProcessingService.getOriginalUrl(newCustomizedUrl);
       return ResponseEntity.status(HttpStatus.FOUND).body(originalURL);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = " Customized URL successfully removed"),
                    @ApiResponse(responseCode = "400", description = "Invalid request"),
                    @ApiResponse(responseCode = "404", description = "Customized URL does not exist")
            })
    @PostMapping(value = "/deleteUrlRecord")
    public ResponseEntity<URL>  deleteURLRecord(@PathVariable String customizedUrl){
        URL originalURL = beanProcessingService.deleteURLRecord(customizedUrl);
        return ResponseEntity.status(HttpStatus.OK).body(originalURL);
    }
}
