package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.vdinnosoft.rtet.datacomponent.entity.Company;

@Entity
@Table(name="CONTACT")
public class Contact {
	@Id
	@Column(name="CONTACTID")
	@GeneratedValue
    private Integer contactid;
	
    @Column(name="TYPE")
    private String type;
 
    @Column(name="NUMBER")
    private String number;
 
    @Column(name="NAME")
    private String name;
    
    @Column(name="INITIALS")
    private String initials;
     
    @Column(name="SURNAME")
    private String surname;
    
    @Column(name="ADDRESS")
    private String address;
     
    @Column(name="CITY")
    private String city;
    
    @Column(name="COUNTRY")
    private String country;
     
    @Column(name="PINCODE")
    private String pincode;
   
    //Relating the Set of Employees to Customer 
    @ManyToOne
	@JoinColumn(name="companyid")
	private Company companydetails;
    
  public Contact() {
	// TODO Auto-generated constructor stub
  }
     
    public Contact(String type,String name,String initials,String surname,String number, String city,String country,String address,String pincode) {
        this.name = name;
        this.city = city;      
        this.address=address;
        this.country=country;
        this.initials=initials;
        this.number=number;
        this.pincode=pincode;
        this.surname=surname;
        this.type=type;
    }
    public String getType() {
        return type;
    }     
    public String getAddress() {
        return address;
    }     
    public String getCountry() {
        return country;
    }
   
    public String getSurname() {
        return surname;
    }
    public String getInitials() {
        return initials;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public String getPincode() {
        return pincode;
    } 
    public String getNumber() {
        return number;
    } 
    public void setCountry(String country) {
        this.country = country;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setType(String type) {
        this.type = type;
    }        
    public void setName(String name) {
        this.name = name;
    }
    public void setInitials(String initials) {
        this.initials = initials;
    }    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setCity(String city) {
        this.city = city;
    }    
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setConactID(Integer contactid) {
        this.contactid = contactid;
    }
    public Integer getConactID() {
        return contactid;
    }  
    @Override
	public String toString() {
		return "Contact: " + this.name + ", " + this.initials + ", " + this.city+ ", " + this.number+ ", " + this.address+ ", " + this.country+ ", " + this.surname+ ", " + this.type+ ", " + this.pincode; 
	}
}
