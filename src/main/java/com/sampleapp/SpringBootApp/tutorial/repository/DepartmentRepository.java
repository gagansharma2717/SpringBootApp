package com.sampleapp.SpringBootApp.tutorial.repository;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
public interface DepartmentRepository extends JpaRepository<entity, primary_key_datatype>
*/
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
