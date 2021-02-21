package com.example.university.executor;

import com.example.university.domain.Department;
import com.example.university.exception.DepartmentNotFoundException;
import com.example.university.service.DepartmentService;


public class HeadOfDepartmentExecutor extends BaseDepartmentCheacker implements Executor {
    private String departmentName;

    public HeadOfDepartmentExecutor(DepartmentService departmentService) {
        super(departmentService);
    }

    @Override
    public void execute() {
        try {
            Department department = verifyDepartment(departmentName);
            String fullName = department.getHeadOfDepartment().getFullName();
            String answer = String.format("Head of %s department is %s", departmentName, fullName);
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
