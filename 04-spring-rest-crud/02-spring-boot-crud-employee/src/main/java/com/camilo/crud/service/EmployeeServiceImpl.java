package com.camilo.crud.service;

import com.camilo.crud.dao.EmployeeDAO;
import com.camilo.crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

// A service can integrate many DAOs for example, or integrate many data sources

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    // It is good practice to do Transactional handling on the service layer

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Transactional
    @Override
    public Employee save(Employee employeeToSave) {
        return employeeDAO.save(employeeToSave);
    }

    @Transactional
    @Override
    public void delete(int employeeId) {
        employeeDAO.delete(employeeId);
    }
}
