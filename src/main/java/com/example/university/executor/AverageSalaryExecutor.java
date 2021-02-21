package com.example.university.executor;

import com.example.university.exception.DepartmentNotFoundException;
import com.example.university.service.DepartmentService;

import java.math.BigDecimal;


public class AverageSalaryExecutor extends BaseDepartmentCheacker implements Executor {
    private String departmentName;

    public AverageSalaryExecutor(DepartmentService departmentService) {
        super(departmentService);
    }

    @Override
    public void execute() {
        try {
            verifyDepartment(departmentName);
            BigDecimal avgSalary = departmentService.getAverageSalaryByDepartmentName(departmentName);
            String answer = String.format("The average salary of %s is %s", departmentName, avgSalary);
            System.out.println(answer);
        } catch (DepartmentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setIncomeParameter(String parameter) {
        this.departmentName = parameter;
    }

}
