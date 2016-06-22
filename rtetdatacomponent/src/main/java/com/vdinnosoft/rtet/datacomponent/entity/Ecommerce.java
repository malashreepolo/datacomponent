package com.vdinnosoft.rtet.datacomponent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ECOMMERCE")
public class Ecommerce {
	
	@Id
	@Column(name = "ECOMMERCE")
	@GeneratedValue
	private Integer ecommerceid;

	@Column(name = "SUBSCRIPTIONSTATUS")
	private String subscriptionstatus;

	@Column(name = "LISCENCE")
	private String liscence;
	
	 public Integer getEcommerceId() {
			return ecommerceid;
		}

		public void setEcommerceId(Integer ecommerceid) {
			this.ecommerceid = ecommerceid;
		}
	
    public String getSubscriptionstatus() {
        return subscriptionstatus;
    }
    public String getLiscenceliscence() {
        return liscence;
    }
    
    public void setSubscriptionstatus(String subscriptionstatus) {
        this.subscriptionstatus = subscriptionstatus;
    }    
    public void setLiscence(String liscence) {
        this.liscence = liscence;
    }
    public Ecommerce()
	{
	}
	public Ecommerce( String subscriptionstatus,String liscence)
	{
		this.subscriptionstatus=subscriptionstatus;
		this.liscence=liscence;		
	}
	@Override
   	public String toString() {
   		return "ECOMMERERCE: " + this.subscriptionstatus + ", " + this.liscence ; 
   	}
}
