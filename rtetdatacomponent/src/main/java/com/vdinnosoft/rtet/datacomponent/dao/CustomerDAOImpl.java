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

import com.vdinnosoft.rtet.datacomponent.entity.Contact;
import com.vdinnosoft.rtet.datacomponent.entity.Ecommerce;
import com.vdinnosoft.rtet.datacomponent.entity.Employee;
import com.vdinnosoft.rtet.datacomponent.entity.Customer;;

public class CustomerDAOImpl  {

	public Integer customerid;
	public String username;
	public String password;
	public CustomerType customertype;	
	public Contact contacts;
	public Ecommerce ecommerce;
	public Employee employees;	
	
	public static void main(String args[]) 
	{
		  CustomerDAOImpl custImpl = new CustomerDAOImpl();
		  Customer customer= new Customer();
		
		  customer.setUsername("atiya");
		  customer.setPassword("malashree");
		  
			System.out.println(" =======CREATE =======");
			custImpl.addCustomer(customer);
			custImpl.addCustomer(customer);
			custImpl.addCustomer(customer);
			
			System.out.println(" =======READ =======");
			Set<Customer> custs1 =custImpl.getCustomer();
			for(Customer cust: custs1) {
				System.out.println(cust.toString());
			}	
			System.out.println(" =======UPDATE =======");
			customer.setUsername("janisha");
			customer.setPassword("Princess");
			custImpl.updateCustomer(customer);
	
			System.out.println(" =======READ =======");
			Set<Customer> custs = custImpl.getCustomer();
			for(Customer cust: custs) {
				System.out.println(cust.toString());
			}
			System.out.println(" =======DELETE ======= ");
			custImpl.removeCustomer(customer.getCustomerid());
			
			System.out.println(" =======READ =======");
			Set<Customer> custs3 =custImpl.getCustomer();
			for(Customer cust: custs3) {
				System.out.println(cust.toString());
			}		
	}
	
	//Reading Customer data from Database
	public Set<Customer> getCustomer() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Customer");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Customer> customers = new HashSet<Customer>(myList);
		session.close();
		System.out.println("Found " + customers.size() + " customers");
		return customers;
		
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
	public Integer addCustomer(Customer customer) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(customer);
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
		System.out.println("Successfully Inserted " + customer.toString());
		return customer.getCustomerid();

	}
	
//Updating Customer data to the Database
	public void updateCustomer(Customer customer) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Customer cm = (Customer) session.load(Customer.class, customer.getCustomerid());
		cm.setUsername(customer.getUsername());
		cm.setPassword(customer.getPassword());
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
		
		System.out.println("Successfully updated " + customer.toString());

	}
//Deleting Customer the data From Database
	public  void removeCustomer(Integer id) {
		Session session = getSessionFactory().openSession();
		Customer cust = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(cust);
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
		System.out.println("Successfully deleted " + cust.toString());

	}
//Customer finding by Id
	public static Customer findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Customer cust = (Customer) session.load(Customer.class, id);
		session.close();
		return cust;
	}
	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	public void getCustomer(String name) {
		// TODO Auto-generated method stub
		
	}
	public void getCustomer(Integer id) {
		// TODO Auto-generated method stub
		
	}
}
