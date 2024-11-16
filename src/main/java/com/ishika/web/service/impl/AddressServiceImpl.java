package com.ishika.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ishika.web.bean.Address;
import com.ishika.web.bean.ApiResponse;
import com.ishika.web.bean.Student;
import com.ishika.web.exceptions.ResourceNotFoundExceptions;
import com.ishika.web.repo.IAddressRepo;
import com.ishika.web.repo.IStudentRepo;
import com.ishika.web.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressRepo addressRepo;
	@Autowired
	private IStudentRepo studentRepo;
	
	@Override
	public ApiResponse addAddressOfStudent(Integer studentId, Address address) {
		
            Student student=studentRepo.findById(studentId).orElseThrow(()->new ResourceNotFoundExceptions("Student Not found"));
             address.setStudent(student);
             addressRepo.save(address);
             ApiResponse response=ApiResponse.builder()
            		 .msg("Successfully Added")
            		 .status(HttpStatus.OK)
            		 .success(true)
            		 .build();
                     return response;
	}

	@Override
	public List<Address> getAllAddress() {
		List<Address> findAll = addressRepo.findAll();
		return findAll;
	}

	@Override
	public Address getAddressById(Integer id) {
		Address address = addressRepo.findById(id)
		.orElseThrow(()->new ResourceNotFoundExceptions("Address Not found by This Id"));
         
		return address;
	}
   
}
