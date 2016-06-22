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

import com.vdinnosoft.rtet.datacomponent.entity.Payment;
import com.vdinnosoft.rtet.datacomponent.entity.PaymentReason;

public class PaymentDAOImpl implements TransactionDAO {
	PaymentReason paymentreason;	
	PaymentOption paymentoption;
	Double amount=0.0;
	Date timestamp;
	public static void main(String args[]) 
	{
		  PaymentDAOImpl payImpl = new PaymentDAOImpl();
		  Payment payment= new Payment();
		
		  payment.setamount(123.00);
		  payment.settimestamp("3:00");
		  
			System.out.println(" =======CREATE =======");
			payImpl.addPayment(payment);
			payImpl.addPayment(payment);
			payImpl.addPayment(payment);
			
			System.out.println(" =======READ =======");
			Set<Payment> pay1 =payImpl.getPayment();
			for(Payment pay: pay1) {
				System.out.println(pay.toString());
			}	
			System.out.println(" =======UPDATE =======");
			payment.setamount(100.00);
			  payment.settimestamp("5:00");
			payImpl.updatePayment(payment);
	
			System.out.println(" =======READ =======");
			Set<Payment> pays = payImpl.getPayment();
			for(Payment pay: pays) {
				System.out.println(pay.toString());
			}
			System.out.println(" =======DELETE ======= ");
			payImpl.removePayment(payment.getPaymentId());
			
			System.out.println(" =======READ =======");
			Set<Payment> pay3 =payImpl.getPayment();
			for(Payment pay: pay3) {
				System.out.println(pay.toString());
			}		
	}
	
	//Reading Payment data from Database
	public Set<Payment> getPayment() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Payment");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Payment> payment = new HashSet<Payment>(myList);
		session.close();
		System.out.println("Found " + payment.size() + " payment");
		return payment;
		
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
	
//Inserting Payment Data to Database
	public Integer addPayment(Payment payment) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(payment);
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
		System.out.println("Successfully Inserted " + payment.toString());
		return payment.getPaymentId();

	}
	
//Updating Payment data to the Database
	public void updatePayment(Payment payment) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Payment py = (Payment) session.load(Payment.class, payment.getPaymentId());
		
		py.setamount(payment.getamount());
		py.settimestamp(payment.gettimestamp());
		
		
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
		
		System.out.println("Successfully updated " + payment.toString());

	}
//Deleting Payment the data From Database
	public  void removePayment(Integer id) {
		Session session = getSessionFactory().openSession();
		Payment pay = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(pay);
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
		System.out.println("Successfully deleted " + pay.toString());

	}
//Payment finding by ID
	public static Payment findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Payment pay = (Payment) session.load(Payment.class, id);
		session.close();
		return pay;
	}
}
