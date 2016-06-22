package com.vdinnosoft.rtet.datacomponent.service;



import java.util.Set;

import com.vdinnosoft.rtet.datacomponent.entity.Contact;

import com.vdinnosoft.rtet.datacomponent.entity.Ecommerce;
import com.vdinnosoft.rtet.datacomponent.entity.Employee;


public class CustomerService  {

	public Integer customerid;
	public String username;
	public String password;
	public String customertype;
	public Set<Contact> primarycontact;
	public Contact contacts;
	public Ecommerce ecommerce;
	public Employee employees;		
}
