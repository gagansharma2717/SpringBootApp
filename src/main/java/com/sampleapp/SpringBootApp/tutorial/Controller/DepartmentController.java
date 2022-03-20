package com.sampleapp.SpringBootApp.tutorial.Controller;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @PostMapping("/departments")
    public Department saveDepartment(){

    }
}
