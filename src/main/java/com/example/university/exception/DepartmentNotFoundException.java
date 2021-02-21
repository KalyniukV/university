package com.example.university.exception;

public class DepartmentNotFoundException extends Exception {

    public DepartmentNotFoundException(String departmentName) {
        super("Not found department by name: " + departmentName);
    }
}
