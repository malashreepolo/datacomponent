package com.vdinnosoft.rtet.datacomponent.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.vdinnosoft.rtet.datacomponent.entity.Contact;

@Entity
@Table(name = "COMPANYDETAILS")
public class Company {

	@Id
	@Column(name = "COMPANYID")
	@GeneratedValue
	private Integer companyid;

	@Column(name = "SERVICETAXNUMBER")
	private String servicetaxnumber;

	@Column(name = "VATNUMBER")
	private String vatnumber;

	@Column(name = "REGISTEREDNAME")
	private String registeredname;

	@Column(name = "REGISTEREDADDRESS")
	private String registeredaadress;

	@Column(name = "REGISTEREDLOGO")
	private String registeredlogo;

	@Column(name = "BUSINESSCATAGORY")
	private String businesscatagory;

	@Column(name = "NOOFEMPLOYEES")
	private String noofemployees;

	@Column(name = "DESCRIPTION")
	private String description;

	// Getting Set of Owner Contacts
	@OneToMany(mappedBy = "companydetails")
	private Set<Contact> ownercontacts;

	// Getting Set of Secondary Contacts
	@OneToMany(mappedBy = "companydetails")
	private Set<Contact> secondarycontacts;

	public Company() {

	}

	public Company(String servicetaxnumber, String vatnumber, String registeredname, String registeredaadress,
			String registeredlogo, String businesscatagory, String noofemployees, String description) {

		this.vatnumber = vatnumber;
		this.registeredname = registeredname;
		this.registeredaadress = registeredaadress;
		this.registeredlogo = registeredlogo;
		this.businesscatagory = businesscatagory;
		this.servicetaxnumber = servicetaxnumber;
		this.noofemployees = noofemployees;
		this.description = description;

	}

	public Set<Contact> getownercontacts() {
		return ownercontacts;
	}

	public Set<Contact> getsecondarycontacts() {
		return secondarycontacts;
	}

	public String getservicetaxnumber() {
		return servicetaxnumber;
	}

	public String getvatnumber() {
		return vatnumber;
	}

	public String getregisteredname() {
		return registeredname;
	}

	public String getregisteredaadress() {
		return registeredaadress;
	}

	public String getregisteredlogo() {
		return registeredlogo;
	}

	public String getbusinesscatagory() {
		return businesscatagory;
	}

	public String getnoofemployees() {
		return noofemployees;
	}

	public String getDescription() {
		return description;
	}

	public void setownercontacts(Set<Contact> ownercontacts) {
		this.ownercontacts = ownercontacts;
	}

	public void setsecondarycontacts(Set<Contact> secondarycontacts) {
		this.secondarycontacts = secondarycontacts;
	}

	public void setservicetaxnumber(String servicetaxnumber) {
		this.servicetaxnumber = servicetaxnumber;
	}

	public void setvatnumber(String vatnumber) {
		this.vatnumber = vatnumber;
	}

	public void setregisteredname(String registeredname) {
		this.registeredname = registeredname;
	}

	public void setregisteredaadress(String registeredaadress) {
		this.registeredaadress = registeredaadress;
	}

	public void setregisteredlogo(String registeredlogo) {
		this.registeredlogo = registeredlogo;
	}

	public void setbusinesscatagory(String businesscatagory) {
		this.businesscatagory = businesscatagory;
	}

	public void setnoofemployees(String noofemployees) {
		this.noofemployees = noofemployees;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Company: " + this.servicetaxnumber + ", " + this.vatnumber + ", " + this.registeredname + ", "
				+ this.registeredaadress + ", " + this.registeredlogo + ", " + this.businesscatagory + ", "
				+ this.noofemployees + ", " + this.description;
	}

	public Integer getCompanyId() {
		// TODO Auto-generated method stub
		return companyid;
	}
	public void setCompanyId(Integer companyid) {
		this.companyid = companyid;
	}

	
}
