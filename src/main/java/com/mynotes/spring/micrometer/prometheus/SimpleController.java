package com.mynotes.spring.micrometer.prometheus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SimpleController {
    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @GetMapping("/helloMicrometer")
    public String hello() {
        restcall();
        return "Hello from test service!!";
    }

    public void restcall(){
        logger.info("From SimpleController:restcallRequest ");
        String sampleUrl = String.format("https://hwq7mt9d4h.execute-api.us-east-1.amazonaws.com/test2/helloworld1?name=John&city=Seattle");
        ResponseEntity<String> albumsListResponse = restTemplate.exchange(sampleUrl, HttpMethod.GET, null, String.class);
        String resp = albumsListResponse.getBody();
        logger.info("Response from rest call "+resp);
    }

}
