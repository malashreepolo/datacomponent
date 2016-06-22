package com.vdinnosoft.rtet.datacomponent.dao;

import java.util.Set;

import com.vdinnosoft.rtet.datacomponent.entity.Customer;
public interface CustomerDAO {
	
	public Integer addCustomer(Customer customer);
	public Set<Customer> getCustomer(); 
	public void removeCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void getCustomer(Integer id);
	public void getCustomer(String name); 
	public void removeCustomer(Integer id);

}
