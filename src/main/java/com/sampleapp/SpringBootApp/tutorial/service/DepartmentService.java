package com.sampleapp.SpringBootApp.tutorial.service;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchdepartmentByID(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentID, Department department);
}
