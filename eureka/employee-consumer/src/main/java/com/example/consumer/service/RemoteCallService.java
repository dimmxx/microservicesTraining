package com.example.consumer.service;

import com.example.consumer.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employee-producer")
public interface RemoteCallService {

    @RequestMapping(method = RequestMethod.GET, value = "/employee")
    public Employee getData();
}
