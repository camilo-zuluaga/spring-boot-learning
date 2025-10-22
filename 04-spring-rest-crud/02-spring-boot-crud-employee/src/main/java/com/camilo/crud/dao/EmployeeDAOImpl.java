package com.camilo.crud.dao;

import com.camilo.crud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee save(Employee employeeToSave) {
        // save or update
        return entityManager.merge(employeeToSave);
    }

    @Override
    public void delete(int employeeId) {
        entityManager.remove(findById(employeeId));
    }
}
