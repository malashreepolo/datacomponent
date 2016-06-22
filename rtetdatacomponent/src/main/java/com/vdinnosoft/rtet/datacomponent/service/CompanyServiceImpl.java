package com.vdinnosoft.rtet.datacomponent.service;

import java.util.Set;

public class CompanyServiceImpl implements CustomerTypeService {
		
	public String servicetaxnumber;
	public String vatnumber;
	public String registeredname;
	public String registeredaadress;
	public String registeredlogo;
	public String businesscatagory;
	public String noofemployees;
	public String description;	
	public ContactService contacts;
	public Set<ContactService> ownercontacts; 
	public Set<ContactService> secondarycontacts;
}
