package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CHEQUE")
public class Cheque {
	@Id
	@Column(name = "CHEQUEID")
	@GeneratedValue
	private Integer chequeid;
	
	@Column(name="DATE")
    private String date;
 
    @Column(name="BANKBRANCH")
    private String bankbranch;
 
    @Column(name="IFSCCODE")
    private String ifsccode;
    
    @Column(name="TONAME")
    private String toname;
    
    @Column(name="BANK")
    private String bank;
    
    @Column(name="CHEQUENO")
    private String chequeno;    
    
public Cheque() {
        
    }
     
    public Cheque(String date, String bankbranch, String ifsccode, String toname,String bank,String chequeno) {
        this.date = date;
        this.bankbranch = bankbranch;
        this.ifsccode=ifsccode;
        this.toname=toname;
        this.bank=bank;
        this.chequeno=chequeno;
        
    }


public Integer getChequeId() {
		return chequeid;
	}

	public void setChequeId(Integer chequeid) {
		this.chequeid = chequeid;
	}
    public String getdate() {
        return date;
    }     
    public String getbankbranch() {
        return bankbranch;
    }     
    public String getifsccode() {
        return ifsccode;
    }
    public String gettoname() {
        return toname;
    }
    public String getbank() {
        return bank;
    }
    public String getchequeno() {
        return chequeno;
    }
    
    public void setdate(String date) {
        this.date = date;
    }
    public void setbankbranch(String bankbranch) {
        this.bankbranch = bankbranch;
    }
    public void setifsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }
    public void settoname(String toname) {
        this.toname = toname;
    }    
    public void setbank(String bank) {
        this.bank = bank;
    }
    public void setchequeno(String chequeno) {
        this.chequeno = chequeno;
    }
   
    @Override
	public String toString() {
		return "Cheque: " + this.date + ", " + this.bankbranch + ", " + this.ifsccode+ ", " + this.toname+ ", " + this.bank+ ", " + this.chequeno; 
	}
}
