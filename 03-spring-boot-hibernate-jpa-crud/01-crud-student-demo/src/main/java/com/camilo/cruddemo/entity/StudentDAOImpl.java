package com.camilo.cruddemo.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// Specialized annotation for DAO implementation

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        // inject entityManager by spring using constructor injection
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        // Transactional to run this as transaction
        // It will handle the transaction aspect for us
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> jpql = entityManager.createQuery("FROM Student", Student.class);
        return jpql.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=?1", Student.class);
        query.setParameter(1, lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student studentToRemove = findById(id);
        entityManager.remove(studentToRemove);
    }

    @Override
    @Transactional
    public int deleteAll() {
        // return rows deleted
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
