package com.camilo.crud.dao;

import com.camilo.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int employeeId);

    Employee save(Employee employeeToSave);

    void delete(int employeeId);
}
