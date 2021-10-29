package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Companies;

@Repository
public interface CompaniesRepositry extends JpaRepository<Companies, Long>,
QuerydslPredicateExecutor<Companies>{

}
