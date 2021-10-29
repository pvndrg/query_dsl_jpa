package com.example.demo.request;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployeesRequest {
	
	private Long id;
	
	private String name;
	
	private String mobile;
	
	private String email;
	
	private String password;
}
