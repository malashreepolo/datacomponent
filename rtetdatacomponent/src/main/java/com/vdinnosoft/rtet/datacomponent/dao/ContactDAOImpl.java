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
import com.vdinnosoft.rtet.datacomponent.entity.Employee;

public class ContactDAOImpl {

	public String type;
	public String number;
	public String name;
	public String initials;
	public String surname;
	public Integer address;
	public Integer city;
	public Integer country;
	public Integer pincode;	
	
	 public static void main(String args[]) 
	 {				 
		 ContactDAOImpl conImpl= new ContactDAOImpl();
		 Contact contact=new Contact();
		 
	    	contact.setName("Vinay");
	    	contact.setCity("Belgaum");
	    	contact.setCountry("malashree");
	    	contact.setPincode("565412");
	    	contact.setSurname("kulkarni");
	    	contact.setInitials("8123187790");
	    	contact.setAddress("27/1 'Nesco Building' 3rd floor khanapur Belgaum");
	    	contact.setNumber("1234");
	    	contact.setType("indiv");
	    	
	    	System.out.println(" =======CREATE =======");
	    	conImpl.addContact(contact);
			System.out.println(contact);
			conImpl.addContact(contact);
			conImpl.addContact(contact);
			
			System.out.println(" =======READ =======");
			Set<Contact> Conts1 =conImpl.getContact();
			for(Contact c: Conts1) {
				System.out.println(c.toString());
			}	
			System.out.println(" =======UPDATE =======");
			contact.setName("mala");
			contact.setCity("vd");
			conImpl.updateContact(contact);

			System.out.println(" =======READ =======");
			Set<Contact> Conts2 = conImpl.getContact();
			for(Contact c: Conts2) {
				System.out.println(c.toString());
			}
			System.out.println(" =======DELETE ======= ");
			conImpl.removeContact(contact.getConactID());
			System.out.println(" =======READ =======");
			Set<Contact> Conts3 = conImpl.getContact();
			for(Contact c: Conts3) {
				System.out.println(c.toString());
			}
		
	}
	    
	  //Reading Employee data from Database
	    public Set<Contact> getContact() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Contact");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Contact> contacts = new HashSet<Contact>(myList);
		session.close();
		System.out.println("Found " + contacts.size() + " contacts");
		return contacts;
		
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
	 
	//Inserting Employee Data to Database
	public Integer addContact(Contact contact) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		session.save(contact);
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
		System.out.println("Successfully Inserted " + contact.toString());
		return contact.getConactID();

	}

	//Updating Employee data to the Database
	public void updateContact(Contact contact) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Contact cm = (Contact) session.load(Contact.class, contact.getConactID());
		cm.setName(contact.getName());
		cm.setCity(contact.getCity());
		cm.setCountry(contact.getCountry());
		cm.setPincode(contact.getPincode());   
		cm.setAddress(contact.getAddress());
		cm.setInitials(contact.getInitials());
		cm.setSurname(contact.getSurname());
		cm.setNumber(contact.getNumber());
		cm.setType(contact.getSurname());
		//em.seti
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
		System.out.println("Successfully updated " + contact.toString());

	}

	//Deleting Employee the data From Database
	public void removeContact(Integer id) {
		Session session = getSessionFactory().openSession();
		Contact contact = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		session.delete(contact);
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
		System.out.println("Successfully deleted " + contact.toString());

	}

	//Employee finding by Id
	public static Contact findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Contact contact = (Contact) session.load(Contact.class, id);
		session.close();
		return contact;
	}

	public void getEmployee(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void getEmployee(String name) {
		// TODO Auto-generated method stub
		
	}
	public void removeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
		
}
