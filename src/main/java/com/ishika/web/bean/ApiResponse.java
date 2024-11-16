package com.ishika.web.bean;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data


@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
 
	private String msg;
	private HttpStatus status;
	private Boolean success;
}
