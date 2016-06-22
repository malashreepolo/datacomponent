package com.vdinnosoft.rtet.datacomponent.dao;

import java.util.Set;

import com.vdinnosoft.rtet.datacomponent.entity.Employee;

public interface EmployeeDAO {

	public void getEmployee(Integer id);
	public void getEmployee(String name); 
	public void removeEmployee(Employee employee);
	public void removeEmployee(Integer id);

	public Integer addEmployee(Employee employee);
	public Set<Employee> getEmployee(); 	
	public void updateEmployee(Employee employee);
}
