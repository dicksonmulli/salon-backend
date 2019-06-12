package com.salonbackend.salon.controller;

import com.salonbackend.salon.model.Employee;
import com.salonbackend.salon.model.Employees;
import com.salonbackend.salon.model.EmployeeResponse;
import com.salonbackend.salon.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "/all", produces = "application/json")
    public Employees getEmployees() {
        return employeeDao.getAllEmployees();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public EmployeeResponse addEmployee(@RequestBody Employee employee) {
        Integer employerCreatedId = employeeDao.addEmployee(employee);

        EmployeeResponse employeeResponse;

        if (employerCreatedId < 10) {
            employeeResponse = new EmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR, "ServerError", "User " + employerCreatedId + " could not be created");
        } else {
            employeeResponse = new EmployeeResponse(HttpStatus.ACCEPTED, "Success", "User " + employerCreatedId + " was created successfully");
        }

        return employeeResponse;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public Employee getEmployee(@RequestParam(value="id") Integer id) {
        return employeeDao.getEmployeeById(id);
    }
}
