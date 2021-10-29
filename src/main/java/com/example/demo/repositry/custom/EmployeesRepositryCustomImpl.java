package com.example.demo.repositry.custom;

import java.util.List;

import com.example.demo.model.QCompanies;
import com.example.demo.model.QEmployees;
import com.example.demo.repositry.BaseRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.Querydsl;

import java.util.List;

public class EmployeesRepositryCustomImpl extends BaseRepository implements EmployeesRepositryCustom {

	@Override
	public List<Tuple> findEmployeeAndCompany(Predicate predicate) {
		// TODO Auto-generated method stub
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		JPAQuery<Tuple> jpaQuery = queryFactory.select(QEmployees.employees,QCompanies.companies)
                .from(QEmployees.employees)
                .leftJoin(QCompanies.companies)
                       .on(QCompanies.companies.employees().id.longValue().eq(QEmployees.employees.id.longValue()));
		jpaQuery.where(predicate);
		return jpaQuery.fetch();
	}
	
	@Override
	public QueryResults<Tuple> findEmployeeAndCompanyPage(Predicate predicate, Pageable pageable) {
		// TODO Auto-generated method stub
		JPAQueryFactory queryFactory = new JPAQueryFactory(em);
		JPAQuery<Tuple> jpaQuery = queryFactory.select(QEmployees.employees,QCompanies.companies)
                .from(QEmployees.employees)
                .leftJoin(QCompanies.companies)
                       .on(QCompanies.companies.employees().id.longValue().eq(QEmployees.employees.id.longValue()))
                      				.orderBy(QCompanies.companies.address.desc())//address
                                               .offset(pageable.getOffset())
                                               .limit(pageable.getPageSize());
				
        return jpaQuery.fetchResults();
	}
}



