package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Spring", "JPA");

    @Test
    void test() {
        boolean result = todos.contains("AWS");

        assertEquals(true, result);
        assertTrue(result);

        assertEquals(3, todos.size());

    }

}
