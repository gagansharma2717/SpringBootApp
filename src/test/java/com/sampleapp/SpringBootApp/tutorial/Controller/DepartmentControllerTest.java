package com.sampleapp.SpringBootApp.tutorial.Controller;

import com.jayway.jsonpath.JsonPath;
import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import com.sampleapp.SpringBootApp.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
//Using @WebMvcTest(DepartmentController.class) for controller Unit testing
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department  = Department.builder()
                .departmentName("HR")
                .departmentAddress("Ahemdabad")
                .departmentCode("HR231")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("HR")
                .departmentAddress("Ahemdabad")
                .departmentCode("HR231")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

//        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\":\"HR\",\n" +
                        "    \"departmentAddress\":\"Ahemdabad\",\n" +
                        "    \"departmentCode\":\"HR231\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void fetchdepartmentByID() throws Exception {
        Mockito.when(departmentService.fetchdepartmentByID(1L))
                .thenReturn(department);

//        Performing Request
        mockMvc.perform(get("/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));

    }
}