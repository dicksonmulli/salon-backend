package com.salonbackend.salon.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.concurrent.atomic.AtomicInteger;

@Entity

// Swaggar
@ApiModel(description ="Details of Employee")
public class Employee {

    // You can use atomic class for the auto incrementing if you are not using db
    private static final AtomicInteger count = new AtomicInteger(0);

    @Id
    @GeneratedValue
    private Long id;

    // Swaggar
    @ApiModelProperty(notes="Name should have atleast 2 characters")

    // Validation
    @Size(min=2, message="Name should have atleast 2 characters")
    private String firstName;
    private String lastName;
    private String email;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        this.id = newId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName +
                ", lastName=" + lastName + ", email=" + email + "]";
    }
}
