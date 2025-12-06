package com.test.code_test_instructions.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
class HealthCheckController {


    String pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> healthcheck(@RequestParam String format, ResponseEntity response) {
        String status = "";
        if ("short".equalsIgnoreCase("format")){
            status = "{\"status\": \"OK\"  + }";
            return new ResponseEntity(status, HttpStatus.OK );
        }else if("full".equalsIgnoreCase("format")){
            String time =simpleDateFormat.format(new Date());
            status = "{ \"currentTime:" + time + ",\"application\": \"OK\" }";
            return new ResponseEntity(status,HttpStatus.OK );
        }else{
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

    }


    @PostMapping(value = "/healthcheck")
    public void healthcheckPost() {
        return;
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthcheckDelete() {
        return;
    }

}
