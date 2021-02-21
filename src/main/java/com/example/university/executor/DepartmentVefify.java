package com.example.university.executor;

import com.example.university.domain.Department;
import com.example.university.exception.DepartmentNotFoundException;

public interface DepartmentVefify {

    Department verifyDepartment(String departmentName) throws DepartmentNotFoundException;

}
