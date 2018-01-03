package com.example.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.main.model.Student;
import com.example.main.repository.StudentRepository;

import java.util.Collection;


@RestController
@RequestMapping("/students")
public class StudentController{

	@Autowired
	StudentRepository sRepo;
	
	private String response = "{\"status\":\"success\"}";
	
	//Return list of students
	@GetMapping(value="")
	public Collection <Student> findAll(){
		Collection<Student> students = sRepo.findAll();
		return students;
	}
	
	//Return single object of student
	@GetMapping(value="/{id}")
	public Student findStudent(@PathVariable("id")Long id) {
		Student student = sRepo.findOne(id);
		return student;
	}
	
	//Post student
	@PostMapping(value="")
	public Student createStudent(@RequestBody Student student) {
		Student studentPersisted = findStudent(student.getId());
		if(studentPersisted != null) {
			return null;
		}
		Student saveStudent = sRepo.save(student);
		return saveStudent;
	}
	
	//Put student
	@PutMapping(value="")
	public Student updateStudent(@RequestBody Student student) {
		Student studentPersisted = findStudent(student.getId());
		if(studentPersisted == null) {
			return null;
		}
	    Student updateStudent = sRepo.save(student);
	    return updateStudent;
	}
	
	//Delete student
//	@CrossOrigin(origins="*", allowedHeaders="Access-Control-Allow-Origin",exposedHeaders="{Access-Control-Allow-Origin}")
//	@DeleteMapping(value="/{id}")
	@DeleteMapping(value="")
	public String deleteStudent(Long id) {
//	public String deleteStudent(@PathVariable("id")Long id) {
		sRepo.delete(id);
		return response;
	}
	
	
}
