package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Student;
import com.demo.repository.StudentRepository;


@Service
public class StudentDAO {

	
	@Autowired
	StudentRepository studentRepository;
	
	public Student save(Student student){
		return studentRepository.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findOne(Long studentId){
		return studentRepository.findOne(studentId);
	}
	
	public void deleteOne(Long studentId){
		 studentRepository.delete(studentId);
	}
}
