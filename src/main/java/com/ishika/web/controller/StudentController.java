package com.ishika.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishika.web.bean.ApiResponse;
import com.ishika.web.bean.Student;
import com.ishika.web.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController
{
	@Autowired
	IStudentService service;
	@PostMapping
  public ResponseEntity<ApiResponse> createStudent(@RequestBody Student student)
  {
	  ApiResponse response = service.createStudent(student);
	return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	
	}
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents()
	{
		List<Student> studentList=service.getAllStudents();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id)
	{
		Student student = service.getStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	@DeleteMapping("deleteId/{id}")
	public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable Integer id)
	{
		ApiResponse response=service.deleteStudent(id);
		return  new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	@DeleteMapping("deleteEmail/{email}")
	public ResponseEntity<ApiResponse> deleteStudentByEmail(@PathVariable String email)
	{
		ApiResponse response=service.deleteStudent(email);
		return  new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponse> updateStudnetByID(@PathVariable Integer id ,@RequestBody Student student)
	{
		ApiResponse response=service.updateStudnetByID(id,student);
		return  new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
}
