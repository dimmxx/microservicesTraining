package com.example.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class ConsumerControllerClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public ResponseEntity<String> getEmployee(){

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("employee-producer");
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        String baseUrl = serviceInstance.getUri().toString();
        baseUrl = baseUrl + "/employee";

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
