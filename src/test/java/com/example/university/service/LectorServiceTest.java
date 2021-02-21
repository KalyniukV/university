package com.example.university.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LectorServiceTest {
    @Autowired
    LectorService lectorService;

    @Test
    public void test() {
        List<String> result = lectorService.globalSearch("iy");
        assertEquals("Tkachuk Vitaliy", result.get(0));
        assertEquals("Oliynyk Olga", result.get(1));
    }

}