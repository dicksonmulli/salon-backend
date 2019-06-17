package com.salonbackend.salon.controller;

import com.salonbackend.salon.exception.EmployeeNotFoundException;
import com.salonbackend.salon.model.Employee;
import com.salonbackend.salon.repository.EmployeeDAO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/employees/{id}")

    // Swaggar
    @ApiOperation(value = "Find employee by id", notes = "Also returns a link to retrieve all employees with rel - all-employees")
    public Employee retrieveEmployee(@PathVariable long id) {
        Optional<Employee> employee = employeeDao.findById(id);

        if (!employee.isPresent()) {
            try {
                throw new EmployeeNotFoundException("id-" + id);
            } catch (EmployeeNotFoundException e) {
            }
        }

        return employee.get();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeDao.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

        Optional<Employee> employeeOptional = employeeDao.findById(id);

        if (!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        employee.setId(id);

        employeeDao.save(employee);

        return ResponseEntity.noContent().build();
    }
}
