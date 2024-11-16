package com.ishika.web.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Address> address;
       
	
	
}
