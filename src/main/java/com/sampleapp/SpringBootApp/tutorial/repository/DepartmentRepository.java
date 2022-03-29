package com.sampleapp.SpringBootApp.tutorial.repository;

import com.sampleapp.SpringBootApp.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
public interface DepartmentRepository extends JpaRepository<entity, primary_key_datatype>
*/
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
//    These are some conventions used for this method declaration like findBy then Entity Name.
//    Note :- Entity Name should exactly be the same that you defined in your entity class.
//    There are different keywords available to create the query and also there is an option of JPQL query which also you can refer in below link.
//    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
//    You can also use @Query annotation. Example given below
//    public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.emailAddress = ?1") //?1 is the first parameter which is basically String emailAddress in this case.
//    User findByEmailAddress(String emailAddress); }
//    There is also an option of @Query(value="", nativeQuery = true) //In value you will enter your query

    //    This method will be able to handle the case.
    public Department findBydepartmentName(String departmentName);

    public Department findBydepartmentNameIgnoreCase(String departmentName);

}
