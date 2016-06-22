package com.vdinnosoft.rtet.datacomponent.dao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.vdinnosoft.rtet.datacomponent.entity.PaymentReason;

public class PaymentReasonDAOImpl {

	public Integer type;
	public String name;
	public String description;
	
	public static void main(String args[]) 
	{
		PaymentReason paymentreason= new PaymentReason();		 
		  PaymentReasonDAOImpl payrImpl= new PaymentReasonDAOImpl();
		
		  paymentreason.setType("1");
		  paymentreason.setname("ABC");
		  paymentreason.setdescription("DEF");
		 
		  
		  
			System.out.println(" =======CREATE =======");
			payrImpl.addPaymentReason(paymentreason);
			payrImpl.addPaymentReason(paymentreason);
			payrImpl.addPaymentReason(paymentreason);
			
			System.out.println(" =======READ =======");
			Set<PaymentReason> payr1 =payrImpl.getPaymentReason();
			for(PaymentReason payr: payr1) {
				System.out.println(payr.toString());
			}	
			System.out.println(" =======UPDATE =======");
			  paymentreason.setType("2");
			  paymentreason.setname("ABCd");
			  paymentreason.setdescription("DEF");
			payrImpl.updatePaymentReason(paymentreason);
	
			System.out.println(" =======READ =======");
			Set<PaymentReason> payrs = payrImpl.getPaymentReason();
			for(PaymentReason payr: payrs) {
				System.out.println(payr.toString());
			}
			System.out.println(" =======DELETE ======= ");
			payrImpl.removePaymentReason(paymentreason.getPaymentReasonId());
			
			System.out.println(" =======READ =======");
			Set<PaymentReason> payr3 =payrImpl.getPaymentReason();
			for(PaymentReason payr: payr3) {
				System.out.println(payr.toString());
			}		
	}
	
	//Reading PaymentReason data from Database
	public Set<PaymentReason> getPaymentReason() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM PaymentReason");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<PaymentReason> paymentreason = new HashSet<PaymentReason>(myList);
		session.close();
		System.out.println("Found " + paymentreason.size() + " paymentreason");
		return paymentreason;
		
	}
	
	//Building the Session Factory
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
//Inserting PaymentReason Data to Database
	public Integer addPaymentReason(PaymentReason paymentreason) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(paymentreason);
		session.getTransaction().commit();
		}catch(HibernateException e)
		{
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
		session.close();
		}
		System.out.println("Successfully Inserted " + paymentreason.toString());
		return paymentreason.getPaymentReasonId();

	}
	
//Updating PaymentReason data to the Database
	public void updatePaymentReason(PaymentReason paymentreason) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		PaymentReason pr = (PaymentReason) session.load(PaymentReason.class, paymentreason.getPaymentReasonId());
		
		//pr.settype(paymentreason.gettype());
		pr.setname(paymentreason.getname());
		pr.setdescription(paymentreason.getdescription());
		
		
		session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
		session.close();
		}
		
		System.out.println("Successfully updated " + paymentreason.toString());

	}
//Deleting PaymentReason the data From Database
	public  void removePaymentReason(Integer id) {
		Session session = getSessionFactory().openSession();
		PaymentReason payr = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(payr);
		session.getTransaction().commit();
		}catch(HibernateException e)
		{
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		}
		finally
		{
		session.close();
		}		
		System.out.println("Successfully deleted " + payr.toString());

	}
//PaymentReason finding by NAME
	public static PaymentReason findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		PaymentReason payr = (PaymentReason) session.load(PaymentReasonDAOImpl.class, id);
		session.close();
		return payr;
	}
}
