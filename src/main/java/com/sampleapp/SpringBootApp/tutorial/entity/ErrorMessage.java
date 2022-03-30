package com.sampleapp.SpringBootApp.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
// POJO class for ErrorMessage
//POJO stands for Plain Old Java Object. It is an ordinary Java object, not bound by any special restriction
// other than those forced by the Java Language Specification and not requiring any classpath.
// POJOs are used for increasing the readability and re-usability of a program.
public class ErrorMessage {

    private HttpStatus status;
    private String message;
}
