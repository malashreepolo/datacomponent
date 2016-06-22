package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CASH")
public class Cash {
	
	@Id
	@Column(name = "CASHID")
	@GeneratedValue
	private Integer cushid;
	
	@Column(name = "VOUCHERNO")
	private String vouchernumber;

	@Column(name = "TONAME")
	private String toname;

	@Column(name = "SIGNEDBY")
	private String signedby;

	@Column(name = "RECIEVEDBY")
	private String recievedby;


public Integer getCushId() {
		return cushid;
	}

	public void setCushId(Integer cushid) {
		this.cushid = cushid;
	}

	public Cash() {

	}

	public Cash(String vouchernumber, String toname, String signedby, String recievedby, String designation,
			String businesscatagory, String organization) {
		this.vouchernumber = vouchernumber;
		this.toname = toname;
		this.signedby = signedby;
		this.recievedby = recievedby;

	}

	public String getvouchernumber() {
		return vouchernumber;
	}

	public String getoname() {
		return toname;
	}

	public String getsignedby() {
		return signedby;
	}

	public String getrecievedby() {
		return recievedby;
	}

	public void setvouchernumber(String vouchernumber) {
		this.vouchernumber = vouchernumber;
	}

	public void settoname(String toname) {
		this.toname = toname;
	}

	public void setsignedby(String signedby) {
		this.signedby = signedby;
	}

	public void setrecievedby(String recievedby) {
		this.recievedby = recievedby;
	}

	@Override
	public String toString() {
		return "Cash: " + this.vouchernumber + ", " + this.toname + ", " + this.signedby + ", " + this.recievedby;
	}
}
