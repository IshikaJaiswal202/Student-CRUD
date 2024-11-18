package com.ishika.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ishika.web.bean.Address;
import com.ishika.web.bean.ApiResponse;
import com.ishika.web.service.IAddressService;

@RestController
@RequestMapping("address")
public class AddressController {

	//with Auto-wired ,IOC while inject the value  to service
	@Autowired
	IAddressService service;
	
	//add the data using put method while using student id;
	@PostMapping("/{id}")
	public ResponseEntity<ApiResponse> addAddressOfStudent(@PathVariable Integer id,@RequestBody Address address)
	{
		ApiResponse response = service.addAddressOfStudent(id,address);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	//get All Addresses using get http method
	@GetMapping
	  public ResponseEntity<List<Address>> getAllAddress()
	     {
	    	 List<Address> list = service.getAllAddress();
			return new ResponseEntity<List<Address>>(list,HttpStatus.OK);
	    	 
	     }
	
	//get the address with help of id
	@GetMapping("/{id}")
	  public ResponseEntity<Address> getAddressById(@PathVariable Integer id)
	     {
	         Address address = service.getAddressById(id);
			return new ResponseEntity<Address>(address,HttpStatus.OK);
	    	 
	     }
	
	// want to delete the address while using id
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteAddressById(@PathVariable Integer id)
	{
	    ApiResponse response=service.deleteAddressById(id);
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
	
	//update the value related to address
	@PutMapping
	public ResponseEntity<ApiResponse> updateAddressValue(@PathVariable Integer id, @RequestBody Address address)
	{
		 ApiResponse response=service.updateAddress(id,address);
		return new  ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}
}
