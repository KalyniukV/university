package com.example.university.executor;

import com.example.university.service.LectorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GlobalSearchExecutorTest {
    @Autowired
    LectorService lectorService;
    ByteArrayOutputStream outputStreamCaptor;
    Executor executor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        executor = new GlobalSearchExecutor(lectorService);
        executor.setIncomeParameter("iy");
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void execute() {
        executor.execute();
        String answer = "Tkachuk Vitaliy, Oliynyk Olga";
        assertEquals(answer, outputStreamCaptor.toString().trim());
    }

}