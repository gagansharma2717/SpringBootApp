package com.sampleapp.SpringBootApp.tutorial.Controller;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import com.sampleapp.SpringBootApp.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
//        Requestbody is the json format input that client is passing as a request we will catch that json request in department java object.
//        Another option is DepartmentService service = new DepartmentServiceImpl(); But we already have this object in IOC container so we will use from there only.
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){

        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchdepartmentByID(@PathVariable("id") Long departmentId){
        return departmentService.fetchdepartmentByID(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByID(@PathVariable("id") Long departmentId)
    {
        departmentService.deleteDepartmentById(departmentId);
        return "Data Deleted Successfully!!!";
    }


}
