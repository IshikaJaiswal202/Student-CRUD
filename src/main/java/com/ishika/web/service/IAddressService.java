package com.ishika.web.service;

import java.util.List;

import com.ishika.web.bean.Address;
import com.ishika.web.bean.ApiResponse;

public interface IAddressService
{

	public ApiResponse addAddressOfStudent(Integer studentId, Address address);

	public List<Address> getAllAddress();

	public Address getAddressById(Integer id);

	public ApiResponse deleteAddressById(Integer id);

	public ApiResponse updateAddress(Integer id, Address address);


}
