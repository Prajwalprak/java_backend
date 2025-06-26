package com.booking.cabbooking.domain.serviceImpl;

import com.booking.cabbooking.domain.model.Student;
import com.booking.cabbooking.domain.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> queryStudents() {
        List<Student> student = new ArrayList<>();

        Student s1 = new Student();
        s1.setId(1);
        s1.setFirstName("Prajwal");
        s1.setLastName("Naik");
        s1.setEmail("prajwal@gmail.com");
        s1.setAge(12);
        s1.setGender("Male");
        s1.setGrade("A");

        student.add(s1);

        return student;
    }
}
