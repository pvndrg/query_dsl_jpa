package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employees;
import com.example.demo.repositry.custom.EmployeesRepositryCustom;
//import com.example.demo.repositry.custom.EmployeesRepositryCustom;

@Repository
public interface EmployeesRepositry extends 
JpaRepository<Employees, Long>,
QuerydslPredicateExecutor<Employees>,
EmployeesRepositryCustom
{
	
}
