package com.vaibhav.myfirstapp;

import com.vaibhav.myfirstapp.dao.StudentRepository;
import com.vaibhav.myfirstapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyfirstappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfirstappApplication.class, args);
    }


    // executed after spring beans have been loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return runner -> {
            studentRepository.save(new Student("vaibhav", "tomar"));
        };
    }

}
