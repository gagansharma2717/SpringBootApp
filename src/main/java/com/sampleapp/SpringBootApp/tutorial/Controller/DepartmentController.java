package com.sampleapp.SpringBootApp.tutorial.Controller;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import com.sampleapp.SpringBootApp.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
//        Requestbody is the json format input that client is passing as a request we will catch that json request in department java object.
//        Another option is DepartmentService service = new DepartmentServiceImpl(); But we already have this object in IOC container so we will use from there only.
        return departmentService.saveDepartment(department);
//

    }
}
