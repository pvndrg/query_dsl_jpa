package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.AppConstants;
import com.example.demo.mapper.EmployeesMapper;
import com.example.demo.model.Employees;
import com.example.demo.modelDTO.EmployeesDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.EmployeesService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeesControllers {
	
	@Autowired
	EmployeesService empService;
	
	
	@GetMapping("/getAllEmployeeAuto"+"/{pageNumber}/{pageSize}")  
	private ApiResponse<?> getAllEmployeeAuto(
			@RequestParam Map<String, String> requestParams,
			@PathVariable("pageNumber") int pageNumber,
            @PathVariable("pageSize") int pageSize)   
	{  
		if (requestParams.isEmpty() || StringUtils.isBlank(requestParams.get(AppConstants.ORDER_BY))
                || StringUtils.isBlank(requestParams.get(AppConstants.SORT_BY))) {
            requestParams.put(AppConstants.SORT_BY, "id");//address
            requestParams.put(AppConstants.ORDER_BY, "DESC");
        }
		ApiResponse<?> apiResponse = empService.getAllEmployeeAuto(requestParams, pageNumber, pageSize);
		return apiResponse;
	}  
	
	@GetMapping("/getAllEmployeeCustom"+"/{pageNumber}/{pageSize}")  
	private ApiResponse<?> getAllEmployeeCustom(
			@RequestParam Map<String, String> requestParams,
			@PathVariable("pageNumber") int pageNumber,
            @PathVariable("pageSize") int pageSize)   
	{  
		if (requestParams.isEmpty() || StringUtils.isBlank(requestParams.get(AppConstants.ORDER_BY))
                || StringUtils.isBlank(requestParams.get(AppConstants.SORT_BY))) {
            requestParams.put(AppConstants.SORT_BY, "address");
            requestParams.put(AppConstants.ORDER_BY, "DESC");
        }
		ApiResponse<?> apiResponse = empService.getAllEmployeeCustom(requestParams, pageNumber, pageSize);
		return apiResponse;
	}  
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/employee/{id}")  
	private Employees getEmployee(@PathVariable("id") Long id)   
	{  
	return empService.getEmployeeById(id);  
	}  
	
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/employees/{id}")  
	private void deleteEmployee(@PathVariable("id") Long id)   
	{  
		empService.delete(id);  
	} 
	
	//creating post mapping that post the book detail in the database  
	@PostMapping("/employees")  
	private ApiResponse<?> saveEmployees(@RequestBody EmployeesDTO employeesReq)   
	{  
		ApiResponse<?> apiResponse = empService.saveOrUpdate(EmployeesMapper.convert(employeesReq));  
	return apiResponse;  
	} 
	
	//creating put mapping that updates the book detail   
	@PutMapping("/employees")  
	private ApiResponse<?> update(@RequestBody EmployeesDTO employeesReq)   
	{  
		ApiResponse<?> apiResponse = empService.saveOrUpdate(EmployeesMapper.convert(employeesReq));  
		return apiResponse;  
	}  
}
