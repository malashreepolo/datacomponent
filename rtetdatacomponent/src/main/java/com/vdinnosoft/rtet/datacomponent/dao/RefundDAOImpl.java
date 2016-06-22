package com.vdinnosoft.rtet.datacomponent.dao;

import java.util.Date;
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
import com.vdinnosoft.rtet.datacomponent.entity.Refund;

public class RefundDAOImpl implements TransactionDAO{

	PaymentReason paymentreason;
	PaymentOption paymentoption;
	Double amount = 0.0;
	Date timestamp;
	public static void main(String args[]) 
	{
		  RefundDAOImpl refImpl = new RefundDAOImpl();
		  Refund refund= new Refund();
		
		  refund.setamount(123.00);
		  refund.settimestamp("3:00");
		  
			System.out.println(" =======CREATE =======");
			refImpl.addRefund(refund);
			refImpl.addRefund(refund);
			refImpl.addRefund(refund);
			
			System.out.println(" =======READ =======");
			Set<Refund> ref1 =refImpl.getRefund();
			for(Refund ref: ref1) {
				System.out.println(ref.toString());
			}	
			System.out.println(" =======UPDATE =======");
			refund.setamount(100.00);
			  refund.settimestamp("5:00");
			refImpl.updateRefund(refund);
	
			System.out.println(" =======READ =======");
			Set<Refund> refs = refImpl.getRefund();
			for(Refund ref: refs) {
				System.out.println(ref.toString());
			}
			System.out.println(" =======DELETE ======= ");
			refImpl.removeRefund(refund.getRefundId());
			
			System.out.println(" =======READ =======");
			Set<Refund> ref3 =refImpl.getRefund();
			for(Refund ref: ref3) {
				System.out.println(ref.toString());
			}		
	}
	
	//Reading Refund data from Database
	public Set<Refund> getRefund() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Refund");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Refund> refund = new HashSet<Refund>(myList);
		session.close();
		System.out.println("Found " + refund.size() + " refund");
		return refund;
		
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
	
//Inserting Refund Data to Database
	public Integer addRefund(Refund refund) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(refund);
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
		System.out.println("Successfully Inserted " + refund.toString());
		return refund.getRefundId();

	}
	
//Updating Refund data to the Database
	public void updateRefund(Refund refund) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Refund rf = (Refund) session.load(Refund.class, refund.getRefundId());
		
		rf.setamount(refund.getamount());
		rf.settimestamp(refund.gettimestamp());
		
		
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
		
		System.out.println("Successfully updated " + refund.toString());

	}
//Deleting Refund the data From Database
	public  void removeRefund(Integer id) {
		Session session = getSessionFactory().openSession();
		Refund ref = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(ref);
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
		System.out.println("Successfully deleted " + ref.toString());

	}
//Refund finding by NAME
	public static Refund findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Refund ref = (Refund) session.load(Refund.class, id);
		session.close();
		return ref;
	}
}
