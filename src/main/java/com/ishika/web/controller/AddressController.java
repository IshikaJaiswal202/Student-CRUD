package com.ishika.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishika.web.bean.Address;
import com.ishika.web.bean.ApiResponse;
import com.ishika.web.service.IAddressService;

@RestController
@RequestMapping("address")
public class AddressController {

	@Autowired
	IAddressService service;
	@PostMapping("/{id}")
	public ResponseEntity<ApiResponse> addAddressOfStudent(@PathVariable Integer id,@RequestBody Address address)
	{
		ApiResponse response = service.addAddressOfStudent(id,address);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	@GetMapping
	  public ResponseEntity<List<Address>> getAllAddress()
	     {
	    	 List<Address> list = service.getAllAddress();
			return new ResponseEntity<List<Address>>(list,HttpStatus.OK);
	    	 
	     }
	@GetMapping("/{id}")
	  public ResponseEntity<Address> getAddressById(@PathVariable Integer id)
	     {
	         Address address = service.getAddressById(id);
			return new ResponseEntity<Address>(address,HttpStatus.OK);
	    	 
	     }
}
