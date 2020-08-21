package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import com.example.studentservice.service.StudentServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SchoolServiceController {

    @Autowired
    StudentServiceDelegate studentServiceDelegate;

    @GetMapping("/getSchoolDetails/{schoolName}")
    public String getStudents(@PathVariable("schoolName") String schoolName) {
        return studentServiceDelegate.callStudentServiceAndGetData(schoolName);
    }
















}
