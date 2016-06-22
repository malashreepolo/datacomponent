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

import com.vdinnosoft.rtet.datacomponent.entity.Cash;
public class CashDAOImpl implements PaymentOption {

	public String vouchernumber;
	public String toname;
	public String signedby;
	public String recievedby;
	public static void main(String args[]) 
	{
		  CashDAOImpl casImpl = new CashDAOImpl();
		  Cash cash= new Cash();
		
		  cash.setvouchernumber("vocher123");
		  cash.settoname("malashree");
		  cash.setsignedby("malashree");
		  cash.setrecievedby("siddu");
		  
		  
			System.out.println(" =======CREATE =======");
			casImpl.addCash(cash);
			casImpl.addCash(cash);
			casImpl.addCash(cash);
			
			System.out.println(" =======READ =======");
			Set<Cash> cas1 =casImpl.getCash();
			for(Cash cas: cas1) {
				System.out.println(cas.toString());
			}	
			System.out.println(" =======UPDATE =======");
			cash.setvouchernumber("voch4567");
			cash.settoname("atiya");
			cash.setsignedby("atiya");
			cash.setrecievedby("malashree");
			casImpl.updateCash(cash);
	
			System.out.println(" =======READ =======");
			Set<Cash> cass = casImpl.getCash();
			for(Cash cas: cass) {
				System.out.println(cas.toString());
			}
			System.out.println(" =======DELETE ======= ");
			casImpl.removeCash(cash.getCushId());
			
			System.out.println(" =======READ =======");
			Set<Cash> cas3 =casImpl.getCash();
			for(Cash cas: cas3) {
				System.out.println(cas.toString());
			}		
	}
	
	//Reading Cash data from Database
	public Set<Cash> getCash() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Cash");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Cash> cash = new HashSet<Cash>(myList);
		session.close();
		System.out.println("Found " + cash.size() + " cash");
		return cash;
		
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
	
//Inserting Cash Data to Database
	public Integer addCash(Cash cash) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(cash);
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
		System.out.println("Successfully Inserted " + cash.toString());
		return cash.getCushId();

	}
	
//Updating Cash data to the Database
	public void updateCash(Cash cash) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Cash ca = (Cash) session.load(Cash.class, cash.getCushId());
		
		ca.setvouchernumber(cash.getvouchernumber());
		ca.setsignedby(cash.getsignedby());
		ca.settoname(cash.getoname());
		ca.setrecievedby(cash.getrecievedby());
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
		
		System.out.println("Successfully updated " + cash.toString());

	}
//Deleting Cash the data From Database
	public  void removeCash(Integer id) {
		Session session = getSessionFactory().openSession();
		Cash cas = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(cas);
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
		System.out.println("Successfully deleted " + cas.toString());

	}
//Cash finding by NAME
	public static Cash findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Cash cas = (Cash) session.load(Cash.class, id);
		session.close();
		return cas;
	}
	public void removeCash(Cash cash) {
		// TODO Auto-generated method stub
		
	}
	public void getCash(Integer id) {
		// TODO Auto-generated method stub
		
	}
	public void getCash(String name) {
		// TODO Auto-generated method stub
		
	}
	
	}
