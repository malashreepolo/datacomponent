package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REFUND_Details")
public class Refund {
	
	@Id
	@Column(name = "REFUNDID")
	@GeneratedValue
	private Integer refundid;
	
	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "TIMESTAMP")
	private String timestamp;
	
	public Refund() {

	}

	public Refund(Double amount, String timestamp, String paymentoption, String reason) {
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public Double getamount() {
		return amount;
	}

	public String gettimestamp() {
		return timestamp;
	}
	
    public Integer getRefundId() {
		return refundid;
	}

	public void setRefundId(Integer refundid) {
		this.refundid = refundid;
	}

	public void setamount(Double amount) {
		this.amount = amount;
	}

	public void settimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Refund: " + this.amount + ", " + this.timestamp;
	}
}
