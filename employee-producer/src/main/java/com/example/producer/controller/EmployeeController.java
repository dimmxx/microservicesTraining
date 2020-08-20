package com.example.producer.controller;

import com.example.producer.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getDataFallBack")
    public Employee firstPage() {

        Employee employee = new Employee();
        employee.setName("emp1");
        employee.setDesignation("manager");
        employee.setEmpId("1");
        employee.setSalary(3000);


        if(true){
            throw new RuntimeException();
        }


        return employee;
    }

    public Employee getDataFallBack() {
        Employee employee = new Employee();
        employee.setName("fallback-emp1");
        employee.setDesignation("fallback-manager");
        employee.setEmpId("fallback-1");
        employee.setSalary(0);
        return employee;
    }






}
