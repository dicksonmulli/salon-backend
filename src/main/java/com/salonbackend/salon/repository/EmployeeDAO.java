package com.salonbackend.salon.repository;

import com.salonbackend.salon.model.Employee;
import com.salonbackend.salon.model.Employees;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    private static Employees list = new Employees();

    /**
     * Gets all employees
     * @return
     */
    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }

    /**
     * Get a single employee by id
     * @param id unique identifier of the employee
     * @return Employee
     */
    public Employee getEmployeeById(Integer id) {

        Employee requestedEmployee = new Employee();
        if (id < 0 || list.getEmployeeList().isEmpty()) {
            return requestedEmployee;
        }

        for (Employee employee: list.getEmployeeList()) {
            if (employee.getId().equals(id)) requestedEmployee = employee;
        }

        return requestedEmployee;
    }
}
