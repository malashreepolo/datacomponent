package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MOBILEDETAILS")
public class Mobile {
	
	@Id
	@Column(name="MOBILEID")
	@GeneratedValue
    private Integer mobileid;
	
	@Column(name="IMEI")
    private String imei;
 
    @Column(name="FIRSTRECORDLOCATION")
    private String firstrecordlocation;
 
    //Relating the Set of Mobiles to Employee
    @ManyToOne
	@JoinColumn(name="emlpoyeeid")
	private Employee employee;
    
    public Integer getMobileId() {
		return mobileid;
	}

	public void setMobileId(Integer mobileid) {
		this.mobileid = mobileid;
	}

    public String getImei(){
    	return imei;
    }
    public String getFirstrecordlocation() {
        return firstrecordlocation;
    }
    
    public void setFirstrecordlocation(String firstrecordlocation) {
        this.firstrecordlocation = firstrecordlocation;
    }
    
    public void setImei(String imei) {
        this.imei = imei;
    }
    
    public Mobile()
   	{
   	}
   	public Mobile( String firstrecordlocation,String imei)
   	{
   		this.firstrecordlocation=firstrecordlocation;
   		this.imei=imei;		
   	}
   	@Override
      	public String toString() {
      		return "MOBILE: " + this.firstrecordlocation + ", " + this.imei ; 
      	}
}
