package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INDIVIDUAL")
public class Individual {
	@Id
	@Column(name = "INDIVIDUALID")
	@GeneratedValue
	private Integer individualid;
     
    @Column(name="NAME")
    private String name;
 
    @Column(name="INITIALS")
    private String initials;
 
    @Column(name="SURNAME")
    private String surname;
    
    @Column(name="OCCUPATION")
    private String occupation;
     
    @Column(name="DESIGNATION")
    private String designation;
    
    @Column(name="BUSINESSCATAGORY")
    private String businesscatagory;
     
    @Column(name="ORGANIZATION")
    private String organization;
public Individual() {
        
    }
     
    public Individual(String name, String initials, String surname, String occupation,String designation,String businesscatagory,String organization) {
        this.name = name;
        this.initials = initials;
        this.surname=surname;
        this.occupation=occupation;
        this.designation=designation;
        this.businesscatagory=businesscatagory;
        this.organization=organization;
    }
    
    public String getname() {
        return name;
    }
    
    public String getinitials() {
        return initials;
    }
     
    public String getsurnames() {
        return surname;
    }
    
    public String getoccupation() {
        return occupation;
    }
    
    public String getdesignation() {
        return designation;
    }
    
    public String getbusinesscatagory() {
        return businesscatagory;
    }
    
    public String getorganization() {
        return organization;
    }
    public Integer getIndividualId() {
		return individualid;
	}

	public void setIndividualId(Integer individualid) {
		this.individualid = individualid;
	}
    public void setname(String name) {
        this.name = name;
    }
    
    public void setinitials(String initials) {
        this.initials = initials;
    }
    
    public void setsurname(String surname) {
        this.surname = surname;
    }
    
    public void setoccupation(String occupation) {
        this.occupation = occupation;
    }
    
    public void setdesignation(String designation) {
        this.designation = designation;
    }
    
    public void setbusinesscatagory(String businesscatagory) {
        this.businesscatagory = businesscatagory;
    }
    
    public void setorganization(String organization) {
        this.organization = organization;
    }
    
    @Override
	public String toString() {
		return "Individual: " + this.name + ", " + this.initials + ", " + this.surname+ ", " + this.occupation+ ", " + this.designation+ ", " + this.businesscatagory+ ", " + this.organization; 
	}
    
}
