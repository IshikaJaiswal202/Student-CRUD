package com.ishika.web.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ishika.web.bean.ApiResponse;
import com.ishika.web.bean.Student;
import com.ishika.web.exceptions.ResourceNotFoundExceptions;
import com.ishika.web.repo.IStudentRepo;
import com.ishika.web.service.IStudentService;

import jakarta.transaction.Transactional;
//it contain all business logic related to student
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepo repo;
	@Override
	public ApiResponse createStudent(Student student)
	{
		ApiResponse response = null;
		Optional<Student> isExists = repo.findByEmail(student.getEmail());
		if(isExists.isEmpty())
		{
		repo.save(student);
	     response=ApiResponse.builder()
				.msg("Succesfullly Added")
				.status(HttpStatus.CREATED)
				.success(true)
				.build();
		}
		else
		{
			throw new ResourceNotFoundExceptions("Student Already exists with this email,"
					+ "try with anthore one");
		}
		return response;
	}
	@Override
	public List<Student> getAllStudents() {
		List<Student> findAll = repo.findAll();
		return findAll;
	}
	@Override
	public Student getStudentById(Integer id) {
		Student student=repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundExceptions("No Student exists by This Id"));
		return student;
	}
	@Override
	public ApiResponse deleteStudent(Integer id) {
		repo.findById(id)
				.orElseThrow(()->new ResourceNotFoundExceptions("No Student exists by This Id"));
		repo.deleteById(id);
		ApiResponse response=ApiResponse.builder()
				.msg("Student Deleted SuccessFully")
				.status(HttpStatus.OK)
				.success(true)
				.build();
		return response;
	}
	@Transactional
	@Override
	public ApiResponse deleteStudent(String email) {
		 repo.findByEmail(email)
		.orElseThrow(()->new ResourceNotFoundExceptions("No Student exists by This Id"));
           repo.deleteByEmail(email);
       ApiResponse response=ApiResponse.builder()
		.msg("Student Deleted SuccessFully")
		.status(HttpStatus.OK)
		.success(true)
		.build();
      return response;
	}
	@Override
	public ApiResponse updateStudnetByID(Integer id, Student student) {
		 Student stud = repo.findById(id)
		  .orElseThrow(()->new ResourceNotFoundExceptions("No Student exists by This Id"));
         stud.setName(student.getName()==null?stud.getName():student.getName());
         stud.setPassword(student.getPassword()==null?stud.getPassword():student.getPassword());
         stud.setPhoneNumber(student.getPhoneNumber()==null?stud.getPhoneNumber():student.getPhoneNumber());
         repo.save(stud);
         ApiResponse response=ApiResponse.builder()
 				.msg("Student Update SuccessFully")
 				.status(HttpStatus.OK)
 				.success(true)
 				.build();
		return response;
	}

}
