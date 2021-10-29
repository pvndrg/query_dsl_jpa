package com.example.demo.mapper;

import com.example.demo.model.Companies;
import com.example.demo.modelDTO.CompaniesDTO;
import com.example.demo.request.CompaniesRequest;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CompaniesMapper {
	
	public static CompaniesRequest convert(CompaniesDTO form) {
		if (form == null)
		{
			return null;
		}
		
		return CompaniesRequest.builder()
				.id(form.getId())
				.address(form.getAddress())
				.email(form.getEmail())
				.mobile(form.getMobile())
				.name(form.getName())
				.build();
	}
	
	public static CompaniesDTO convert(CompaniesRequest form) {
		if (form == null)
		{
			return null;
		}
		
		return CompaniesDTO.builder()
				.id(form.getId())
				.address(form.getAddress())
				.email(form.getEmail())
				.mobile(form.getMobile())
				.name(form.getName())
				.build();
	}

	public static CompaniesDTO convert(Companies form) {
		// TODO Auto-generated method stub
		if (form == null)
		{
			return null;
		}
		
		return CompaniesDTO.builder()
				.id(form.getId())
				.address(form.getAddress())
				.email(form.getEmail())
				.mobile(form.getMobile())
				.name(form.getName())
				.build();
	}
}
