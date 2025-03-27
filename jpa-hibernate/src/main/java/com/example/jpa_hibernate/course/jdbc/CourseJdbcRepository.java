package com.example.jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY =
        """
            insert into course (id, name, author)
            values(1, 'AWS 배우기', '홍길동');
        """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
