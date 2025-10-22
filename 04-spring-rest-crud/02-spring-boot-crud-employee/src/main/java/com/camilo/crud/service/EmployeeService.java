package com.camilo.crud.service;

import com.camilo.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employeeToSave);

    void delete(int employeeId);
}
