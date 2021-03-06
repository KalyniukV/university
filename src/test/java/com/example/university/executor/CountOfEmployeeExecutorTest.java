package com.example.university.executor;

import com.example.university.service.DepartmentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CountOfEmployeeExecutorTest {
    @Autowired
    DepartmentService departmentService;
    ByteArrayOutputStream outputStreamCaptor;
    Executor executor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        executor = new CountOfEmployeeExecutor(departmentService);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @Transactional
    void execute() {
        executor.setIncomeParameter("Economics");
        executor.execute();
        String answer = "5";
        assertEquals(answer, outputStreamCaptor.toString().trim());
    }

    @Test
    void wrong_department_name() {
        executor.setIncomeParameter("Wrong Department Name");
        executor.execute();
        String answer = "Not found department by name: Wrong Department Name";
        assertEquals(answer, outputStreamCaptor.toString().trim());
    }
}