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

import com.vdinnosoft.rtet.datacomponent.entity.Mobile;

public class MobileDAOImpl {

	public String imei;	
    public String firstrecordlocation;
	public LocationDAOImpl location;
	
	public static void main(String args[]) 
	{
		MobileDAOImpl mobImpl = new MobileDAOImpl();
		  Mobile mobile= new Mobile();
		
		  mobile.setFirstrecordlocation("Gaovaes");
		  mobile.setImei("1234");
		  
			System.out.println(" =======CREATE =======");
			mobImpl.addMobile(mobile);
			mobImpl.addMobile(mobile);
			mobImpl.addMobile(mobile);
			
			System.out.println(" =======READ =======");
			Set<Mobile> custs1 =mobImpl.getMobile();
			for(Mobile cust: custs1) {
				System.out.println(cust.toString());
			}	
			System.out.println(" =======UPDATE =======");
			mobile.setFirstrecordlocation("yellur road");
			mobile.setImei("9999");
			mobImpl.updateMobile(mobile);
	
			System.out.println(" =======READ =======");
			Set<Mobile> custs = mobImpl.getMobile();
			for(Mobile cust: custs) {
				System.out.println(cust.toString());
			}
			System.out.println(" =======DELETE ======= ");
			mobImpl.removeMobile(mobile.getMobileId());
			
			System.out.println(" =======READ =======");
			Set<Mobile> custs3 =mobImpl.getMobile();
			for(Mobile cust: custs3) {
				System.out.println(cust.toString());
			}		
	}
	
	//Reading Customer data from Database
	public Set<Mobile> getMobile() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Mobile");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Mobile> mobiles = new HashSet<Mobile>(myList);
		session.close();
		System.out.println("Found " + mobiles.size() + " mobiles");
		return mobiles;
		
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
	public Integer addMobile(Mobile mobile) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(mobile);
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
		System.out.println("Successfully Inserted " + mobile.toString());
		return mobile.getMobileId();

	}
	
//Updating Customer data to the Database
	public void updateMobile(Mobile mobile) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Mobile mb = (Mobile) session.load(Mobile.class, mobile.getMobileId());
		mb.setFirstrecordlocation(mobile.getFirstrecordlocation());
		mb.setImei(mobile.getImei());
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
		
		System.out.println("Successfully updated " + mobile.toString());

	}
//Deleting Customer the data From Database
	public  void removeMobile(Integer id) {
		Session session = getSessionFactory().openSession();
		Mobile mobile = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(mobile);
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
		System.out.println("Successfully deleted " + mobile.toString());

	}
//Customer finding by Id
	public static Mobile findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Mobile mobile = (Mobile) session.load(Mobile.class, id);
		session.close();
		return mobile;
	}
	public void removeMobile(Mobile mobile) {
		// TODO Auto-generated method stub
		
	}
	public void getMobile(String name) {
		// TODO Auto-generated method stub
		
	}
	public void getMobile(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
