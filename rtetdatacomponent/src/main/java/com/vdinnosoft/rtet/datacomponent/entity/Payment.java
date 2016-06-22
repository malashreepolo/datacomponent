package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_Details")
public class Payment {
	
	@Id
	@Column(name = "PAYMENTID")
	@GeneratedValue
	private Integer paymentid;
	
    @Column(name="AMOUNT")      
    private Double amount;
     
    @Column(name="TIMESTAMP")
    private String timestamp;
    
public Payment() {
        
    }
     
    public Payment(Double amount, String timestamp, String paymentoption, String reason) {
        this.amount = amount;
        this.timestamp = timestamp;
        
    }
    public Double getamount() {
        return amount;
    }     
    public String gettimestamp() {
        return timestamp;
    }     


public Integer getPaymentId() {
		return paymentid;
	}

	public void setPaymentId(Integer paymentid) {
		this.paymentid = paymentid;
	}
    
    public void setamount(Double amount) {
        this.amount = amount;
    }
    public void settimestamp(String timestamp) {
        this.timestamp = timestamp;
    }   
   
    @Override
	public String toString() {
		return "Payment: " + this.amount + ", " + this.timestamp ; 
	}
}
