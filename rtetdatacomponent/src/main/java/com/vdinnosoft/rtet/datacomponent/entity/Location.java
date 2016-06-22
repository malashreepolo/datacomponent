package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONDETAILS")
public class Location {
	@Id
    @Column(name="LOCATIONID")
    @GeneratedValue
    private Integer locationid;

    @Column(name="LATTITUDE")
    private Double lattitude;
 
    @Column(name="LONGITUDE")
    private Double longitude;
     
    @Column(name="TIMESTAMP")
    private String timestamp;
    
    @Column(name="IMEI")
    private String imei;
     
    @Column(name="MOBILENUMBER")
    private String mobilenumber;
    
  //Relating the Set of Locations to Employee
    @ManyToOne
	@JoinColumn(name="emlpoyeeid")
	private Employee employee;
    
    public String getMobileNumber(){
    	return mobilenumber;
    } 
    
    public String getImei(){
    	return imei;
    }
    public Double getLongitude() {
        return longitude;
    }
    public String getTimeStamp() {
        return timestamp;
    }
    public Double getLattitude() {
        return lattitude;
    }
    
    public void seMobileNumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    } 
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }    
    public void setImei(String imei) {
        this.imei = imei;
    }
    
    public void setTimeStamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }
   
    public Integer getLocationId() {
        return locationid;
    }
    public void setLocationId(Integer locationid) {
        this.locationid = locationid;
    }
    @Override
   	public String toString() {
   		return "Location: " + this.mobilenumber + ", " + this.lattitude + ", " + this.longitude+ ", " + this.imei+ ", " + this.timestamp; 
   	}
	public Location()
	{
	}
	public Location( String mobilenumber,Double longitude, Double lattitude,String imei,String timestamp)
	{
		this.mobilenumber=mobilenumber;
		this.longitude=longitude;
		this.lattitude=lattitude;
		this.timestamp=timestamp;
		this.imei=imei;
		
	}

}
