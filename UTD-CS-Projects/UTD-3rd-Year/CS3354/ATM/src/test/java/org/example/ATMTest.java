package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    @BeforeEach
    void setUp() {
        System.out.println("Before each test case methods");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test case methods");
    }

    @Test
    void transfer() {
    }
}