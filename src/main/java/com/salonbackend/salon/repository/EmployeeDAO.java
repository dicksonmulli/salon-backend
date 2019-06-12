package com.salonbackend.salon.repository;

import com.salonbackend.salon.model.Employee;
import com.salonbackend.salon.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    private static Employees employees = new Employees();

    /**
     * Gets all employees
     * @return
     */
    public Employees getAllEmployees() {
        return employees;
    }

    public Integer addEmployee(Employee employee) {
        Employee employeeCreated = new Employee(employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail());

        employees.getEmployeeList().add(employeeCreated);

        return employeeCreated.getId();
    }

    /**
     * Get a single employee by id
     * @param id unique identifier of the employee
     * @return Employee
     */
    public Employee getEmployeeById(Integer id) {

        Employee requestedEmployee = new Employee();

        if (id < 0 || employees.getEmployeeList().isEmpty()) {
            return requestedEmployee;
        }

        for (Employee employee: employees.getEmployeeList()) {
            if (employee.getId().equals(id)) requestedEmployee = employee;
        }

        return requestedEmployee;
    }
}
