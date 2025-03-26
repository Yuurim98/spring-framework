package com.example.spring_boot;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getCourseList() {
        return Arrays.asList(
            new Course(1, "Spring", "홍길동"),
            new Course(2, "Spring Boot", "홍길동")
        );
    }
}
