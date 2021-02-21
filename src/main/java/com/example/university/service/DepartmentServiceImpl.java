package com.example.university.service;

import com.example.university.data.StatisticData;
import com.example.university.domain.Department;
import com.example.university.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public Department getByDepartmentName(String departmentName) {
        return departmentRepo.getByName(departmentName);
    }

    @Override
    @Transactional
    public StatisticData getStatisticByDepartmentName(String departmentName) {
        return departmentRepo.getStatisticByName(departmentName);
    }

    @Override
    public BigDecimal getAverageSalaryByDepartmentName(String departmentName) {
       return departmentRepo.getAverageSalary(departmentName).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    @Transactional
    public Integer getCountOfEmployeeByDepartmentName(String departmentName) {
        return getByDepartmentName(departmentName).getLectors().size();
    }
}
