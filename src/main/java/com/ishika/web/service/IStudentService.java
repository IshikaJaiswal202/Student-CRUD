package com.ishika.web.service;

import java.util.List;

import com.ishika.web.bean.ApiResponse;
import com.ishika.web.bean.Student;

public interface IStudentService {

	public ApiResponse createStudent(Student student);

	public List<Student> getAllStudents();

	public Student getStudentById(Integer id);

	public ApiResponse deleteStudent(Integer id);

	public ApiResponse deleteStudent(String email);

	public ApiResponse updateStudnetByID(Integer id, Student student);

}
