package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARD")
public class Card {
	
	@Id
	@Column(name = "CardID")
	@GeneratedValue
	private Integer cardid;
	
	@Column(name="CARDNO")
    private String cardno;
 
    @Column(name="NAMEONCARD")
    private String nameoncard;
 
    @Column(name="EXPIRYDATE")
    private String expirydate;
    
    @Column(name="CVVNO")
    private String cvvno;
    
    @Column(name="BANKNAME")
    private String bankname;
    
    @Column(name="TYPE")
    private String type;
    
    @Column(name="VENDOR")
    private String vendor;
    
    
    public Card() {
           
       }
        
       public Card(String cardno, String nameoncard, String expirydate, String cvvno,String bankname,String type,String vendor) {
           this.cardno = cardno;
           this.nameoncard = nameoncard;
           this.expirydate=expirydate;
           this.cvvno=cvvno;
           this.bankname=bankname;
           this.type=type;
           this.vendor=vendor;
           
       }
       public String getcardno() {
           return cardno;
       }     
       public String getnameoncard() {
           return nameoncard;
       }     
       public String getexpirydate() {
           return expirydate;
       }
       public String getcvvno() {
           return cvvno;
       }
       public String getbankname() {
           return bankname;
       }
       public String gettype() {
           return type;
       }
       
       public String getvendor() {
           return vendor;
       }
       public Integer getCardId() {
   		return cardid;
    	}

   	 public void setCardId(Integer cardid) {
   		this.cardid = cardid;
    	}
       public void setcardno(String cardno) {
           this.cardno = cardno;
       }
       public void setnameoncard(String nameoncard) {
           this.nameoncard = nameoncard;
       }
       public void setexpirydate(String expirydate) {
           this.expirydate = expirydate;
       }
       public void setcvvno(String cvvno) {
           this.cvvno = cvvno;
       }    
       public void setbankname(String bankname) {
           this.bankname = bankname;
       }
       public void settype(String type) {
           this.type = type;
       }
       public void setvendor(String vendor) {
           this.vendor = vendor;
       }
      
       @Override
   	public String toString() {
   		return "Card: " + this.cardno + ", " + this.nameoncard + ", " + this.expirydate+ ", " + this.cvvno+ ", " + this.bankname+ ", " + this.type+ ", " + this.vendor; 
   	}
}
