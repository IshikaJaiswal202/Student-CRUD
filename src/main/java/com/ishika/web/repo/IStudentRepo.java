package com.ishika.web.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishika.web.bean.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

	Optional<Student> findByEmail(String email);

	void deleteByEmail(String email);

}
