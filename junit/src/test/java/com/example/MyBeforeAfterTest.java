package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("모든 테스트 전");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트 후");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("테스트 전");
    }

    @AfterEach
    void afterEach() {
        System.out.println("테스트 후");
    }

    @Test
    void test1() {
        System.out.println("test1");

    }

    @Test
    void test2() {
        System.out.println("test2");

    }

    @Test
    void test3() {
        System.out.println("test3");

    }
}
