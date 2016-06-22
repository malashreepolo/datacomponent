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

import com.vdinnosoft.rtet.datacomponent.entity.Ecommerce;
import com.vdinnosoft.rtet.datacomponent.entity.Mobile;

public  class EcommerceDAOImpl {

	public Transaction transcation;
	public PaymentOption paymentoption;
	public String subscriptionstatus;
	public String liscence;

	public static void main(String args[]) 
	{
		EcommerceDAOImpl EcoImpl = new EcommerceDAOImpl();
		Ecommerce ecommerce= new Ecommerce();
		
		ecommerce.setLiscence("malashree");
		ecommerce.setSubscriptionstatus("yes");
		  
			System.out.println(" =======CREATE =======");
			EcoImpl.addEcommerce(ecommerce);
			EcoImpl.addEcommerce(ecommerce);
			EcoImpl.addEcommerce(ecommerce);
			
			System.out.println(" =======READ =======");
			Set<Ecommerce> custs1 =EcoImpl.getEcommerce();
			for(Ecommerce cust: custs1) {
				System.out.println(cust.toString());
			}	
			System.out.println(" =======UPDATE =======");
			ecommerce.setLiscence("atiya");
			ecommerce.setSubscriptionstatus("no");
			EcoImpl.updateEcommerce(ecommerce);
	
			System.out.println(" =======READ =======");
			Set<Ecommerce> custs = EcoImpl.getEcommerce();
			for(Ecommerce cust: custs) {
				System.out.println(cust.toString());
			}
			System.out.println(" =======DELETE ======= ");
			EcoImpl.removeEcommerce(ecommerce.getEcommerceId());
			
			System.out.println(" =======READ =======");
			Set<Ecommerce> custs3 =EcoImpl.getEcommerce();
			for(Ecommerce cust: custs3) {
				System.out.println(cust.toString());
			}		
	}
	
	//Reading Customer data from Database
	public Set<Ecommerce> getEcommerce() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Mobile");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Ecommerce> ecommerces = new HashSet<Ecommerce>(myList);
		session.close();
		System.out.println("Found " + ecommerces.size() + " ecommerces");
		return ecommerces;
		
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
	
//Inserting Customer Data to Database
	public Integer addEcommerce(Ecommerce ecommerce) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(ecommerce);
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
		System.out.println("Successfully Inserted " + ecommerce.toString());
		return ecommerce.getEcommerceId();

	}
	
//Updating Customer data to the Database
	public void updateEcommerce(Ecommerce ecommerce) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Ecommerce Ec = (Ecommerce) session.load(Mobile.class, ecommerce.getEcommerceId());
		Ec.setLiscence(ecommerce.getLiscenceliscence());
		Ec.setSubscriptionstatus(ecommerce.getSubscriptionstatus());
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
		
		System.out.println("Successfully updated " + ecommerce.toString());

	}
//Deleting Customer the data From Database
	public  void removeEcommerce(Integer id) {
		Session session = getSessionFactory().openSession();
		Ecommerce Ecom = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(Ecom);
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
		System.out.println("Successfully deleted " + Ecom.toString());

	}
//Customer finding by Id
	public static Ecommerce findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Ecommerce Ecom = (Ecommerce) session.load(Ecommerce.class, id);
		session.close();
		return Ecom;
	}
	public void removeEcommerce(Mobile mobile) {
		// TODO Auto-generated method stub
		
	}
	public void getEcommerce(String name) {
		// TODO Auto-generated method stub
		
	}
	public void getEcommerce(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
