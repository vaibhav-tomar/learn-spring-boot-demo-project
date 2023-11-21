package com.vaibhav.myfirstapp.rest;

import com.vaibhav.myfirstapp.dao.StudentRepository;
import com.vaibhav.myfirstapp.entity.Student;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentRepository studentRepository;

    List<Student> students;

    @PostConstruct
    private void loadData() {
        students = new ArrayList<>();
        students.add(new Student("abhishek", "tomar"));
        students.add(new Student("swati", "tomar"));
        studentRepository.saveAll(students);
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int studentId) {

        if(studentId < 0) {
            throw new StudentNotFoundException("Student id not found : " + studentId);
        }
        return studentRepository.findById(studentId).get();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }

}
