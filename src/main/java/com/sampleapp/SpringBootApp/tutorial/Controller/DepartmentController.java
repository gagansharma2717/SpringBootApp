package com.sampleapp.SpringBootApp.tutorial.Controller;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import com.sampleapp.SpringBootApp.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    Creating logger for DepartmentController Class using Slf4j logging
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
//        Requestbody is the json format input that client is passing as a request we will catch that json request in department java object.
//        Another option is DepartmentService service = new DepartmentServiceImpl(); But we already have this object in IOC container so we will use from there only.
        logger.info("Inside Save Department method");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        logger.info("Inside Fetch Departments");
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

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentID,@RequestBody Department department){
        return departmentService.updateDepartment(departmentID,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String deptName)
    {
        return departmentService.fetchdepartmentByName(deptName);
    }
}
