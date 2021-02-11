package com.javatechie.spring.mongo.api.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "employee")
public class Employee {
	
	
	@Id
	private int id;
    private String firstName;
	private String company;
	private int grosSalary ;
	private int hiredPeriod ;
	private int leavePeriod ;
	private int period ;
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getGrosSalary() {
		return grosSalary;
	}
	public void setGrosSalary(int grosSalary) {
		this.grosSalary = grosSalary;
	}
	public int getHiredPeriod() {
		return hiredPeriod;
	}
	public void setHiredPeriod(int hiredPeriod) {
		this.hiredPeriod = hiredPeriod;
	}
	public int getLeavePeriod() {
		return leavePeriod;
	}
	public void setLeavePeriod(int leavePeriod) {
		this.leavePeriod = leavePeriod;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}

	
	
	
	}
	



