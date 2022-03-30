package com.sampleapp.SpringBootApp.tutorial.service;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import com.sampleapp.SpringBootApp.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
// This annotation is used for test classes.
class DepartmentServiceTest {

    @Autowired
    DepartmentService departmentService;

    @MockBean
//  This annotation is used for mocking the bean for testing.
    DepartmentRepository departmentRepository;

    @BeforeEach
//    This setup will be called for each testcase added to this class.
//    We also have @BeforeAll annotation which will call setup method only once for all test cases defined in the class.
//    We also have @AfterAll and @AfterEach annotation. We are used in cleanup processing after executing the test cases.
    void setUp() {
//          Test Data created using Builder pattern
            Department department = Department.builder().departmentName("IT")
                .departmentAddress("Noida")
                .departmentCode("IT101")
                .departmentId(1L).build();

//      When this departmentRepository.findBydepartmentNameIgnoreCase(String departmentName) is called with
//      Input IT as departmentName thenReturn this test data then we just created above.
        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("IT")).thenReturn(department);


    }

    @Test
//    This annotation is used to treat the method as a test case.
    @DisplayName("Test Case 1")
//  We also have @Disabled annotation that we can use if we want to disable any particular test case.
    public void validate_departmentName()
    {
        String departmentName = "IT";
        Department found = departmentService.fetchdepartmentByName(departmentName);

//        AssetEquals basically will compare the values of departmentName and found.getDepartmentName()
        assertEquals(departmentName,found.getDepartmentName());
    }

}