package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.constants.AppConstants;
import com.example.demo.mapper.EmployeesMapper;
import com.example.demo.model.Companies;
import com.example.demo.model.Employees;
import com.example.demo.model.QCompanies;
import com.example.demo.model.QEmployees;
import com.example.demo.repositry.EmployeesRepositry;
import com.example.demo.request.EmployeesRequest;
import com.example.demo.response.ApiResponse;
import com.example.demo.response.DataResponse;
import com.example.demo.response.PaginationDetails;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;

@Service
public class EmployeesService {
	
	@Autowired
	EmployeesRepositry empRepo;
	
	public ApiResponse<?> getAllEmployeeAuto(Map<String, String> requestParams, int pageNumber, int pageSize)   
	{  
		DataResponse dataResp = new DataResponse();
		
		List<Employees> listEmp = new ArrayList<Employees>();
		List<Companies> listComp = new ArrayList<Companies>();
		
		if(!ObjectUtils.isEmpty(requestParams)) {
			Sort.Direction sortDirection = StringUtils.equalsIgnoreCase(requestParams.get(AppConstants.ORDER_BY), AppConstants.ASC)
					? Sort.Direction.ASC : Sort.Direction.DESC;
			Sort sort = Sort.by(sortDirection, requestParams.get(AppConstants.SORT_BY));
			
			Pageable paging = PageRequest.of(pageNumber, pageSize, sort);
			
			BooleanBuilder booleanBuilder = new BooleanBuilder();

			booleanBuilder.and(QEmployees.employees.name.isNotEmpty());
			
			Page<Employees> employee = empRepo.findAll(booleanBuilder.getValue(), paging);
						
			PaginationDetails paginationDetails = new PaginationDetails();
			paginationDetails.setTotalItems(employee.getTotalElements());
			paginationDetails.setTotalPages(employee.getTotalPages());
			paginationDetails.setCurrentPage(employee.getNumber());
			paginationDetails.setCurrentPageItem(employee.getNumberOfElements());
			paginationDetails.setPageSize(employee.getSize());
			paginationDetails.setIsFirstPage(employee.isFirst());
			paginationDetails.setIsLastPage(employee.isLast());
			paginationDetails.setPrev(employee.hasPrevious());
			paginationDetails.setNext(employee.hasNext());
			
			for (Employees employees : employee) {
				listEmp.add(employees);
			}
			dataResp.setEmployees(listEmp);
			dataResp.setCompanies(listComp);
			//dataResp.setEmployeeWithCompany(employee1);
			dataResp.setPaginationDetails(paginationDetails);
		}
		return new ApiResponse<>(true, AppConstants.DOCUMENT_FETCHED, dataResp);
	} 
	
	public ApiResponse<?> getAllEmployeeCustom(Map<String, String> requestParams, int pageNumber, int pageSize)   
	{  
		DataResponse dataResp = new DataResponse();
		
		List<Employees> listEmp = new ArrayList<Employees>();
		List<Companies> listComp = new ArrayList<Companies>();
		
		if(!ObjectUtils.isEmpty(requestParams)) {
			Sort.Direction sortDirection = StringUtils.equalsIgnoreCase(requestParams.get(AppConstants.ORDER_BY), AppConstants.ASC)
					? Sort.Direction.ASC : Sort.Direction.DESC;
			Sort sort = Sort.by(sortDirection, requestParams.get(AppConstants.SORT_BY));
			
			Pageable paging = PageRequest.of(pageNumber, pageSize, sort);
			
			System.out.println("sort -> "+paging.getSort());
			System.out.println("sort -> "+paging.getSortOr(sort));
			
			BooleanBuilder booleanBuilder = new BooleanBuilder();

			booleanBuilder.and(QEmployees.employees.name.isNotEmpty());
			
			//Page<Employees> employee = empRepo.findAll(booleanBuilder.getValue(), paging);
			
			//List<Tuple> employee1 = empRepo.findEmployeeAndCompany(booleanBuilder.getValue());
	 
			QueryResults<Tuple> employee2 = empRepo.findEmployeeAndCompanyPage(booleanBuilder.getValue(), paging);
			
				System.err.println("==========================================");
				for (Tuple tuple : employee2.getResults()) {
				     System.out.println("QueryResults employees " + tuple.get(QEmployees.employees));
				     listEmp.add((Employees) tuple.get(QEmployees.employees));
				     System.out.println("QueryResults companies " + tuple.get(QCompanies.companies));
				     listComp.add((Companies) tuple.get(QCompanies.companies));
				}
				System.err.println("==========================================");
		
			PaginationDetails paginationDetails = new PaginationDetails((int) listEmp.size(), (int) employee2.getOffset(), 
					(double) employee2.getTotal(),
					(double) employee2.getLimit(),
					pageNumber, pageSize, false);

			dataResp.setEmployees(listEmp);
			dataResp.setCompanies(listComp);
			dataResp.setPaginationDetails(paginationDetails);
		}
		return new ApiResponse<>(true, AppConstants.DOCUMENT_FETCHED, dataResp);
	}
	
	public Employees getEmployeeById(Long id)   
	{  
	return empRepo.findById(id).get();  
	}
	
	public ApiResponse<?> saveOrUpdate(EmployeesRequest employeesRequest)   
	{  
		Employees emp = new Employees();
		if(!ObjectUtils.isEmpty(employeesRequest) && employeesRequest != null) {
			emp.setCreatedOn(new Date());
			emp.setEmail(employeesRequest.getEmail());
			emp.setMobile(employeesRequest.getMobile());
			emp.setName(employeesRequest.getName());
			emp.setPassword(employeesRequest.getPassword());
			empRepo.save(emp); 
		} 
		return new ApiResponse<>(true, AppConstants.SAVE, EmployeesMapper.convert(emp));
	}
	
	public void delete(Long id)   
	{  
		empRepo.deleteById(id);  
	} 

}
