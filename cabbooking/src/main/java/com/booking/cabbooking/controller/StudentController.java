package com.booking.cabbooking.controller;

import com.booking.cabbooking.domain.model.Student;
import com.booking.cabbooking.domain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseBody
    @GetMapping("/student")
    public String getStudents(){
        return "Hello Bridgestone guys";
    }

    @ResponseBody
    @GetMapping("/students")
    public List<Student> getallStudents(){
        return studentService.queryStudents();
    }


}
