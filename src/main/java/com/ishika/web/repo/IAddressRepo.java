package com.ishika.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishika.web.bean.Address;

public interface IAddressRepo extends JpaRepository<Address, Integer> {

}
