package com.example.university.executor;

import com.example.university.domain.Department;
import com.example.university.exception.DepartmentNotFoundException;
import com.example.university.service.DepartmentService;


public class CountOfEmployeeExecutor extends BaseDepartmentCheacker implements Executor {
    private String departmentName;

    public CountOfEmployeeExecutor(DepartmentService departmentService) {
        super(departmentService);
    }


    @Override
    public void execute() {
        try {
            Department department = verifyDepartment(departmentName);
            int countOfEmployee = department.getLectors().size();
            System.out.println(countOfEmployee);
        } catch (DepartmentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setIncomeParameter(String parameter) {
        this.departmentName = parameter;
    }
}
