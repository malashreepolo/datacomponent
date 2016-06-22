package com.vdinnosoft.rtet.datacomponent.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	@Id
    @Column(name="EMPLOYEEID")
    @GeneratedValue
    private Integer emlpoyeeid;
     
    @Column(name="EMPLOYEENAME")
    private String employeename;
    
    @Column(name="INITIALS")
    private String initials;
    
    @Column(name="SURNAME")
    private String surname;
   
    @Column(name="USERNAME")
    private String username;
     
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="MOBILENO")
    private String mobileNo;
    
    @Column(name="GENDER")
    private String gender;
    
    @Column(name="ADDRESS")
    private String address;
    
    @Column(name="PINCODE")
    private String pincode;
    
  //Relating the Set of Mobiles 
    @OneToMany(mappedBy="employee")
    private Set<Mobile> moblies;
    
  //Relating the Set of Employees to Customer 
    @ManyToOne
	@JoinColumn(name="customerid")
	private Customer customerdetails;
    
    //Getting Set of Locations 
    @OneToMany(mappedBy="employee")
  	private Set<Location> locations; 
      
    public Set<Location> getLocations() {
  		return locations;
  	}

  	public void setLocations(Set<Location> locations) {
  		this.locations = locations;
  	}
   
    public Employee() {
        
    }
     
    public Employee(String employeename,String initials,String surname,String gender, String username, String mobileNo,String password,String address,String pincode) {
        this.employeename = employeename;
        this.username = username;
        this.mobileNo=mobileNo;
        this.address=address;
        this.password=password;
        this.initials=initials;
        this.gender=gender;
        this.pincode=pincode;
        this.surname=surname;
        
    }
    public String getPassword() {
        return password;
    }     
    public String getAddress() {
        return address;
    }     
    public String getUsername() {
        return username;
    }
    public String getMobileNo() {
        return mobileNo;
    }
    public String getSurname() {
        return surname;
    }
    public String getInitials() {
        return initials;
    }
    public String getEmployeename() {
        return employeename;
    }
    public String getGender() {
        return gender;
    }
    public String getPincode() {
        return pincode;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }    
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }
    public void setInitials(String initials) {
        this.initials = initials;
    }    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }    
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    
    public Integer getEmployeeID() {
        return emlpoyeeid;
    }
    public void setEmployeeID(Integer emlpoyeeid ) {
        this.emlpoyeeid = emlpoyeeid;
    }
    @Override
	public String toString() {
		return "Employee: " + this.username + ", " + this.initials + ", " + this.employeename+ ", " + this.mobileNo+ ", " + this.address+ ", " + this.password+ ", " + this.surname+ ", " + this.gender+ ", " + this.pincode; 
	}
}
