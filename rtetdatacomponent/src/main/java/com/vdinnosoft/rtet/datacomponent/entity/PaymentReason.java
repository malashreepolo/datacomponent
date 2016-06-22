package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENTREASON_Details")
public class PaymentReason {
	
	@Id
	@Column(name = "PAYMENTREASONID")
	@GeneratedValue
	private Integer paymentreasonid;
	
	@Column(name = "TYPE")
	private String type;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	public PaymentReason() {

	}

	public PaymentReason(String type, String name, String description) {
		this.type = type;
		this.name = name;
		this.description = description;

	}
	


public Integer getPaymentReasonId() {
		return paymentreasonid;
	}

	public void setPaymentReasonId(Integer paymentreasonid) {
		this.paymentreasonid = paymentreasonid;
	}

	public String getType() {
		return type;
	}

	public String getname() {
		return name;
	}

	public String getdescription() {
		return description;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PaymentReason: " + this.type + ", " + this.name + ", " + this.description;
	}

}
