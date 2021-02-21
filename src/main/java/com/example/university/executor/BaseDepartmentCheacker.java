package com.example.university.executor;

import com.example.university.domain.Department;
import com.example.university.exception.DepartmentNotFoundException;
import com.example.university.service.DepartmentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseDepartmentCheacker implements DepartmentVefify {
    protected final DepartmentService departmentService;

    @Override
    public Department verifyDepartment(String departmentName) throws DepartmentNotFoundException {
        Department department = departmentService.getByDepartmentName(departmentName);
        if (department != null) {
            return department;
        } else {
            throw new DepartmentNotFoundException(departmentName);
        }
    }
}
