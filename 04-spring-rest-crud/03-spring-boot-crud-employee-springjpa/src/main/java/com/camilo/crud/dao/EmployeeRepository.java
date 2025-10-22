package com.camilo.crud.dao;

import com.camilo.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// less boilerplate for DAO CRUD operations, the second parameter is primary key data type
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
