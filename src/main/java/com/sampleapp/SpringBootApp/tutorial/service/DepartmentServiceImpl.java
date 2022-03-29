package com.sampleapp.SpringBootApp.tutorial.service;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import com.sampleapp.SpringBootApp.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchdepartmentByID(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {
//      Department object nikala database se
        Department departmentDB = departmentRepository.findById(departmentID).get();

//      Checks for null as well as for blank if object is not null as well as value is not blank then
//      Update the value.
        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(departmentDB);
    }

    @Override
    public Department fetchdepartmentByName(String deptName) {
//        This method is not present in JPA repository so we need to declare it in our repository interface.
        return departmentRepository.findBydepartmentNameIgnoreCase(deptName);
    }

}
