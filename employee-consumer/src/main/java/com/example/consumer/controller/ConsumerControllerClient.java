package com.example.consumer.controller;

import com.example.consumer.model.Employee;
import com.example.consumer.service.RemoteCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ConsumerControllerClient {

    @Autowired
    private RemoteCallService remoteCallService;

    public ResponseEntity<String> getEmployee() {
        Employee employee = null;
        try {
            employee = remoteCallService.getData();
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(employee != null ? employee.toString() : "empty", HttpStatus.OK);
    }


}
