package com.camilo.cruddemo.entity;

// Student's Data Access Object
// DAO is used as a helper class to communicate with the database
// where DAO classes are responsible for providing CRUD operations on database tables
// Using entity manager and the data source

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
