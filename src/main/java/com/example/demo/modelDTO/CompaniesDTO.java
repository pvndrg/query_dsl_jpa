package com.example.demo.modelDTO;

import javax.persistence.Column;

import com.example.demo.model.Companies;

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
public class CompaniesDTO {
private Long id;
	
	private String name;
	
	private String address;
	
	private String mobile;
	
	private String email;
}
