package com.javatechie.spring.mongo.api.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javatechie.spring.mongo.api.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{
	
	
	List<Employee> findAllByCompany(String company);
	
	List <Employee> findByhiredPeriodGreaterThan(int hiredPeriod);
	
	List <Employee> findByleavePeriodLessThan(int leavePeriod);
	
	
	
	List <Employee> findByPeriodBetween(int hiredPeriod,int leavePeriod);

}

/*
 * import com.example.demo.Employee;
 * 
 * import org.springframework.data.mongodb.repository.MongoRepository;
 * 
 * import java.util.List;
 * 
 * 
 * // No need implementation, just one interface, and you have CRUD, thanks
 * Spring Data! public interface EmployeeRepository extends
 * MongoRepository<Employee, String> {
 * 
 * 
 * Employee findByEmployeeFirstName(String firstName);
 * 
 * 
 * 
 * }
 */