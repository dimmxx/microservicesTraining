package com.example.studentservice.controller;

import com.example.studentservice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StudentServiceController {

    private static final Map<String, List<Student>> schoolDB;

    static {
        schoolDB = new HashMap<>();
        List<Student> lst = new ArrayList<>();
        Student std = new Student("Sajal", "Class IV");
        lst.add(std);
        std = new Student("Lokesh", "Class V");
        lst.add(std);
        schoolDB.put("abcschool", lst);
        lst = new ArrayList<>();
        std = new Student("Kajal", "Class III");
        lst.add(std);
        std = new Student("Sukesh", "Class VI");
        lst.add(std);
        schoolDB.put("xyzschool", lst);
    }

    @GetMapping("/getStudents/{schoolName}")
    public List<Student> getStudents(@PathVariable("schoolName") String schoolName) {
        System.out.println("Getting Student details for " + schoolName);
        List<Student> studentList = schoolDB.get(schoolName);
        if (studentList == null) {
            studentList = new ArrayList<Student>();
            Student std = new Student("Not Found", "N/A");
            studentList.add(std);
        }
        return studentList;
    }


}
