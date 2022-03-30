package com.sampleapp.SpringBootApp.tutorial.repository;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;
//    With the help of this testEntityManager data will persist in the database,
//    only when the particular test cases is running.
    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Noida")
                .departmentCode("IT102")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void findByID_thenreturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"IT");
    }

//    This is almost same as service layer but the main difference is we are using @DataJPATest annotation with class
//    and testEntityManager with the help of this data will not get stored in database.
}