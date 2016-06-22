package com.vdinnosoft.rtet.datacomponent.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.vdinnosoft.rtet.datacomponent.entity.Employee;

@Entity
@Table(name = "CUSTOMERDETAILS")
public class Customer {
	
	@Id
	@Column(name = "CUSTOMERID")
	@GeneratedValue
	private Integer customerid;
	
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	// Getting Set of Employees
	@OneToMany(mappedBy = "customerdetails")
	private Set<Employee> employees;

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Customer() {

	}

	public Customer( String password, String username){
		this.username = username;
		this.password = password;		
		
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}		
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	@Override
	public String toString() {
		return "CUSTOMER: " + ", " + this.username + ", " + this.password;
				
	}

}
