package com.example.consumer.controller;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class ConsumerControllerClient {

    public ResponseEntity<String> getEmployee(){

        String baseUrl = "http://localhost:8080/employee";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = null;

        try {
            responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return responseEntity;
    }

    private static HttpEntity<?> getHeaders() throws IOException{
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity(headers);
        return httpEntity;
    }












}
