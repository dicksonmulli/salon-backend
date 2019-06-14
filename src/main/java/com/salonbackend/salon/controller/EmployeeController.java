package com.salonbackend.salon.controller;

import com.salonbackend.salon.model.Employee;
import com.salonbackend.salon.model.Employees;
import com.salonbackend.salon.model.EmployeeResponse;
import com.salonbackend.salon.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDao;

    @GetMapping(path = "/all", produces = "application/json")
    public List<Employee> getEmployees() {
        return employeeDao.findAll();
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        Employee saveEmployee = employeeDao.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

//    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
//    public ResponseEntity getEmployee(@RequestParam(value="id") Integer id) {
//        if (id < 1) {
//            return ResponseEntity.badRequest().body("Invalid user id");
//        }
//
//        if (employeeDao.getEmployeeById(id).getId() == null) {
//            return ResponseEntity.badRequest().body("User id doesn't exist");
//        }
//        return ResponseEntity.ok().body(employeeDao.getEmployeeById(id));
//    }
}
