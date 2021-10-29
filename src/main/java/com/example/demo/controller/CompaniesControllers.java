package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.CompaniesMapper;
import com.example.demo.mapper.EmployeesMapper;
import com.example.demo.model.Companies;
import com.example.demo.model.Employees;
import com.example.demo.modelDTO.CompaniesDTO;
import com.example.demo.modelDTO.EmployeesDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.CompaniesService;
import com.example.demo.service.EmployeesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CompaniesControllers {
	
	@Autowired
	CompaniesService compService;
	
	
	@GetMapping("/companies")  
	private List<Companies> getAllCompanies()   
	{  
	return compService.getAllEmployee();  
	}  
	
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/companies/{id}")  
	private Companies getEmployee(@PathVariable("id") Long id)   
	{  
	return compService.getCompaniesById(id);  
	}  
	
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/companies/{id}")  
	private void deleteCompanies(@PathVariable("id") Long id)   
	{  
		compService.delete(id);  
	} 
	
	//creating post mapping that post the book detail in the database  
	@PostMapping("/companies")  
	private ApiResponse<?> saveCompanies(@RequestBody CompaniesDTO companiesReq)   
	{  
		ApiResponse<?> apiResponse = compService.saveOrUpdate(CompaniesMapper.convert(companiesReq));  
	return apiResponse;  
	} 
	
	//creating put mapping that updates the book detail   
	@PutMapping("/companies")  
	private ApiResponse<?> update(@RequestBody CompaniesDTO companiesReq)   
	{  
		ApiResponse<?> apiResponse = compService.saveOrUpdate(CompaniesMapper.convert(companiesReq));  
		return apiResponse;  
	}  
}
