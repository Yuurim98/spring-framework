package com.example.jpa_hibernate.course.jdbc;

import com.example.jpa_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "AWS 배우기", "홍길동"));
        repository.insert(new Course(2, "Spring 배우기", "홍길동"));
        repository.insert(new Course(3, "JPA 배우기", "홍길동"));

        repository.deleteById(3);

        System.out.println(repository.findById(2));
    }
}
