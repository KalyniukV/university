package com.example.university.service;

import com.example.university.data.StatisticData;
import com.example.university.domain.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;

    @Test
    void getByDepartmentName() {
        Department department = departmentService.getByDepartmentName("Economics");
        assertNotNull(department);

        Department wrongDepartment = departmentService.getByDepartmentName("Wrong department");
        assertNull(wrongDepartment);
    }

    @Test
    void getStatisticByDepartmentName() {
        StatisticData statistic = departmentService.getStatisticByDepartmentName("Economics");
        assertEquals(2, statistic.getAssistantsCount());
        assertEquals(2, statistic.getAssociateProfessorsCount());
        assertEquals(1, statistic.getProfessorsCount());
    }

    @Test
    void getAverageSalaryByDepartmentName() {
        BigDecimal avgSalary = departmentService.getAverageSalaryByDepartmentName("Economics");
        assertEquals(new BigDecimal("1800.00"), avgSalary);
    }

    @Test
    void getCountOfEmployeeByDepartmentName() {
        Integer count = departmentService.getCountOfEmployeeByDepartmentName("Economics");
        assertEquals(5, count);
    }
}