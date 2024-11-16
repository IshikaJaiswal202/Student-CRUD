package com.ishika.web.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String  cityName;
    private String  state;
    private String  pinCode;
   
    @ManyToOne
    @JoinColumn(name="studentId")
    private Student student;
}
