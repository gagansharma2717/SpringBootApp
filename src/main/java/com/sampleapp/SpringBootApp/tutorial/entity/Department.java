package com.sampleapp.SpringBootApp.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

// Introducing Lambok
@Entity
@Data
// Data is equivalent to getters, setters , toString, hasCode, RequiredArgsConstructor
// Or You can simply use @Getter if you want only getter. In our we need everything, so we will go ahead with @Data
//We also want default constructor, so we will use @NoArgsConstructor as well
@NoArgsConstructor
@AllArgsConstructor
// Parameterized Constructor with all arguments.
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add Department Name")

    /*
    Other Validations
    @Length(max = 5, min = 1)
    @Size(max = 10, min = 1)
    @Email You can use the regex as well in email for validation

    Numbers :-
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero

    Dates :-
    @Future
    @FutureOrPresent
    @Past
    @PastOrPresent
    */
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
/*
    public Department(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
*/

}
