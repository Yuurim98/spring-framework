package com.example.jpa_hibernate.course;

import com.example.jpa_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository repository;


    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "AWS 배우기", "홍길동"));
        repository.save(new Course(2, "Spring 배우기", "홍길동"));
        repository.save(new Course(3, "JPA 배우기", "홍길동"));

        repository.deleteById(3L);

        System.out.println(repository.findById(2L));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("홍길동"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Spring 배우기"));
    }
}
