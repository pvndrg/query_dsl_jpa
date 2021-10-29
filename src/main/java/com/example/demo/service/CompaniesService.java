package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.constants.AppConstants;
import com.example.demo.mapper.CompaniesMapper;
import com.example.demo.mapper.EmployeesMapper;
import com.example.demo.model.Companies;
import com.example.demo.model.Employees;
import com.example.demo.repositry.CompaniesRepositry;
import com.example.demo.repositry.EmployeesRepositry;
import com.example.demo.request.CompaniesRequest;
import com.example.demo.request.EmployeesRequest;
import com.example.demo.response.ApiResponse;


@Service
public class CompaniesService {
	
	@Autowired
	CompaniesRepositry compRepo;
	
	public List<Companies> getAllEmployee()   
	{  
	List<Companies> companies = new ArrayList<Companies>();  
	compRepo.findAll().forEach(companies1 -> companies.add(companies1));  
	return companies;  
	} 
	
	public Companies getCompaniesById(Long id)   
	{  
	return compRepo.findById(id).get();  
	}
	
	public ApiResponse<?> saveOrUpdate(CompaniesRequest companiesRequest)   
	{  
		Companies comp = new Companies();
		if(!ObjectUtils.isEmpty(companiesRequest) && companiesRequest != null) {
			comp.setCreatedOn(new Date());
			comp.setEmail(companiesRequest.getEmail());
			comp.setMobile(companiesRequest.getMobile());
			comp.setName(companiesRequest.getName());
			comp.setAddress(companiesRequest.getAddress());
			compRepo.save(comp); 
		} 
		return new ApiResponse<>(true, AppConstants.SAVE, CompaniesMapper.convert(comp));
	}
	
	public void delete(Long id)   
	{  
		compRepo.deleteById(id);  
	} 

}
