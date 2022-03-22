package com.sampleapp.SpringBootApp.tutorial.service;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
