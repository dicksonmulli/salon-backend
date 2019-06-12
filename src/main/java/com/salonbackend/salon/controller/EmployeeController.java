package com.salonbackend.salon.controller;

import com.salonbackend.salon.model.Employee;
import com.salonbackend.salon.model.Employees;
import com.salonbackend.salon.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "/all", produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addEmployee(@RequestBody Employee employee) {
        employeeDao.addEmployee(employee);

        String location = "Success";

        return location;
    }
}
