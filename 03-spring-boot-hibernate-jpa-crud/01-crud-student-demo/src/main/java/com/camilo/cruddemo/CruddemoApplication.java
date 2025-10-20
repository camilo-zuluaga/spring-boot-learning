package com.camilo.cruddemo;

import com.camilo.cruddemo.entity.Student;
import com.camilo.cruddemo.entity.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		// Executed after the beans are loaded
		return runner -> {
//			createStudent(studentDAO);
			
			createMultipleStudents(studentDAO);
			
//			readStudent(studentDAO);
			
//			queryForStudents(studentDAO);
			
//			queryByLastName(studentDAO);

//			updateStudent(studentDAO);
			
//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowsDeleted = studentDAO.deleteAll();
		System.out.printf("Deleted %d rows.%n", rowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int idToDelete = 1;
		studentDAO.delete(idToDelete);
		Student student = studentDAO.findById(idToDelete);
		if (student == null) {
			System.out.printf("Student ID: %d not found.%n", idToDelete);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		student.setLastName("Zuluaga");

		studentDAO.update(student);
		System.out.println("Updated student: " + student);
	}

	private void queryByLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("Doe");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		Student student = new Student("John", "Doe", "john@gmail.com");

		studentDAO.save(student);

		System.out.println("ID Generated: " + student.getId());

		// retrieve student
		Student foundStudent = studentDAO.findById(student.getId());
		System.out.println(foundStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 students...");
		Student student1 = new Student("Samuel", "Porras", "samuel@gmail.com");
		Student student2 = new Student("David", "Castro", "david@gmail.com");
		Student student3 = new Student("Jhojan", "Garcia", "jhojan@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Students saved.");
		System.out.println("Saved student 1. Generated ID: " + student1.getId());
		System.out.println("Saved student 2. Generated ID: " + student2.getId());
		System.out.println("Saved student 3. Generated ID: " + student3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating the student...");
		Student student = new Student("Juan", "Camilo", "camilo@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student. Generated ID: " + student.getId());
	}
}
