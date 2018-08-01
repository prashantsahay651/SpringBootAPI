package com.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.StudentDAO;
import com.demo.model.Student;



@RestController
@RequestMapping("/company")
public class StudentController {

	@Autowired
	StudentDAO studentDAO;

	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentDAO.save(student);

	}

	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return studentDAO.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
		Student student = studentDAO.findOne(studentId);
		if (student == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateSrudent(@PathVariable(value="id") Long studentId,@Valid @RequestBody Student student){
		
		Student student2=studentDAO.findOne(studentId);
		if(student2==null){
			return ResponseEntity.notFound().build();
		}
		
		student2.setStudentName(student.getStudentName());
		student2.setFathersName(student.getFathersName());
		student2.setMothersName(student.getMothersName());
		student2.setDateAdded(student.getDateAdded());
		
		Student updateStudent=studentDAO.save(student2);
		
		return ResponseEntity.ok(updateStudent);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable(value="id") Long studentId){
		Student student = studentDAO.findOne(studentId);
		if (student == null) {
			return ResponseEntity.notFound().build();
		}
		
		studentDAO.deleteOne(studentId);
		
		return ResponseEntity.ok().build();
	}
}
