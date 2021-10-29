package com.example.demo.repositry.custom;

import java.util.List;

import com.example.demo.model.Employees;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface EmployeesRepositryCustom {

	public List<Tuple> findEmployeeAndCompany(Predicate predicate);
	
	//public Page<Tuple> findEmployeeAndCompanyPage(Predicate predicate);
	
	public QueryResults<Tuple> findEmployeeAndCompanyPage(Predicate predicate,Pageable pageable);
}
