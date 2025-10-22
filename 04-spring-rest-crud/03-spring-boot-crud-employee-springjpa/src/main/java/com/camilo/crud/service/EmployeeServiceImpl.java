package com.camilo.crud.service;

import com.camilo.crud.dao.EmployeeRepository;
import com.camilo.crud.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// A service can integrate many DAOs for example, or integrate many data sources

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        Employee employee = null;

        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        } else {
            throw new RuntimeException("Did not find employee ID = " + employeeId);
        }

        return employee;
    }

    @Override
    public Employee save(Employee employeeToSave) {
        return employeeRepository.save(employeeToSave);
    }

    @Override
    public void delete(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
