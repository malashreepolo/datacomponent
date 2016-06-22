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

import com.vdinnosoft.rtet.datacomponent.entity.Cheque;

public class ChequeDAOImpl implements PaymentOption {

	public Date date;
	public String bankbranch;
	public String ifsccode;
	public String toname;
	public String bank;
	public String chequeno;
	public static void main(String args[]) 
	{
		  ChequeDAOImpl chqImpl = new ChequeDAOImpl();
		  Cheque cheque= new Cheque();
		
		  cheque.setdate("210616");
		  cheque.setbankbranch("camp");
		  cheque.setifsccode("sccode1234");
		  cheque.settoname("malashree");
		  cheque.setbank("sbi");
		  cheque.setchequeno("che1234");
		  
		  
			System.out.println(" =======CREATE =======");
			System.out.println(" =======CREATE TABLE =======");
			chqImpl.addCheque(cheque);
			chqImpl.addCheque(cheque);
			chqImpl.addCheque(cheque);
			System.out.println(" =======HELLO MALASHREE =======");
			
			System.out.println(" =======READ =======");
			Set<Cheque> chq1 =chqImpl.getCheque();
			for(Cheque chq: chq1) {
				System.out.println(chq.toString());
			}	
			System.out.println(" =======UPDATE =======");
			  cheque.setdate("180616");
			  cheque.setbankbranch("yellur");
			  cheque.setifsccode("sccode4567");
			  cheque.settoname("atiya");
			  cheque.setbank("canara");
			  cheque.setchequeno("cheque678");
			chqImpl.updateCheque(cheque);
	
			System.out.println(" =======READ =======");
			Set<Cheque> chqs = chqImpl.getCheque();
			for(Cheque chq: chqs) {
				System.out.println(chq.toString());
			}
			System.out.println(" =======DELETE ======= ");
			chqImpl.removeCheque(cheque.getChequeId());
			
			System.out.println(" =======READ =======");
			Set<Cheque> chq3 =chqImpl.getCheque();
			for(Cheque chq: chq3) {
				System.out.println(chq.toString());
			}		
	}
	
	//Reading Cheque data from Database
	public Set<Cheque> getCheque() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Cheque");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Cheque> cheque = new HashSet<Cheque>(myList);
		session.close();
		System.out.println("Found " + cheque.size() + " cheque");
		return cheque;
		
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
	
//Inserting Cheque Data to Database
	public Integer addCheque(Cheque cheque) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(cheque);
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
		System.out.println("Successfully Inserted " + cheque.toString());
		return cheque.getChequeId();

	}
	
//Updating Cheque data to the Database
	public void updateCheque(Cheque cheque) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Cheque cq = (Cheque) session.load(Cheque.class, cheque.getChequeId());
		
		cq.setdate(cheque.getdate());
		cq.setbankbranch(cheque.getbankbranch());
		cq.setifsccode(cheque.getifsccode());
		cq.setbank(cheque.getbank());
		cq.settoname(cheque.gettoname());
		cq.setchequeno(cheque.getchequeno());
		
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
		
		System.out.println("Successfully updated " + cheque.toString());

	}
//Deleting Cheque the data From Database
	public  void removeCheque(Integer id) {
		Session session = getSessionFactory().openSession();
		Cheque chq = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(chq);
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
		System.out.println("Successfully deleted " + chq.toString());

	}
//Cheque finding by NAME
	public static Cheque findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Cheque chq = (Cheque) session.load(Cheque.class, id);
		session.close();
		return chq;
	}
	public void removeCheque(Cheque cheque) {
		// TODO Auto-generated method stub
		
	}
	public void getCheque(Integer id) {
		// TODO Auto-generated method stub
		
	}
	public void getCheque(String name) {
		// TODO Auto-generated method stub
		
	}
}
