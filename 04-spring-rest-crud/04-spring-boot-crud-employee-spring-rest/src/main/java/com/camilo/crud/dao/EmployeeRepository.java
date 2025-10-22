package com.camilo.crud.dao;

import com.camilo.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// less boilerplate for DAO CRUD operations, the second parameter is primary key data type
// You can change the name of the endpoints, by default is entity + s = employees
// @RepositoryRestResource(path = "members")

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
