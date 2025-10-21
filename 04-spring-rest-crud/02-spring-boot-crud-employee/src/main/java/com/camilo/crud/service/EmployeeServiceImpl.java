package com.camilo.crud.service;

import com.camilo.crud.dao.EmployeeDAO;
import com.camilo.crud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

// A service can integrate many DAOs for example, or integrate many data sources

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
