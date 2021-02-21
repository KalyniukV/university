package com.example.university.service;

import com.example.university.data.StatisticData;
import com.example.university.domain.Department;

import java.math.BigDecimal;


public interface DepartmentService {

    Department getByDepartmentName(String departmentName);

    StatisticData getStatisticByDepartmentName(String departmentName);

    BigDecimal getAverageSalaryByDepartmentName(String departmentName);

    Integer getCountOfEmployeeByDepartmentName(String departmentName);
}
