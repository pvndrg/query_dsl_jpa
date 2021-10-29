package com.example.demo.mapper;

import com.example.demo.model.Employees;
import com.example.demo.model.QEmployees;
import com.example.demo.modelDTO.EmployeesDTO;
import com.example.demo.request.EmployeesRequest;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EmployeesMapper {
	
	public static EmployeesRequest convert(EmployeesDTO form) {
		
		if (form == null)
		{
			return null;
		}
		
		return EmployeesRequest.builder()
				.id(form.getId())
				.email(form.getEmail())
				.mobile(form.getMobile())
				.name(form.getName())
				.build();
		}
	
	public static EmployeesDTO convert(EmployeesRequest form) {
		
		if (form == null)
		{
			return null;
		}
		
		return EmployeesDTO.builder()
				.id(form.getId())
				.email(form.getEmail())
				.mobile(form.getMobile())
				.name(form.getName())
				.build();
		}
	
	public static EmployeesDTO convert(Employees form) {
		
		if (form == null)
		{
			return null;
		}
		
		return EmployeesDTO.builder()
				.id(form.getId())
				.email(form.getEmail())
				.mobile(form.getMobile())
				.name(form.getName())
				.build();
		}
}
