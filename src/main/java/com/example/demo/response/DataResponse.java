package com.example.demo.response;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Companies;
import com.example.demo.model.Employees;
import com.querydsl.core.Tuple;

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
public class DataResponse {
	private List<Employees> employees;
	
	private List<Companies> companies;
	
	private PaginationDetails paginationDetails;
	
}
