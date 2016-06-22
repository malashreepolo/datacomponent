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

import com.vdinnosoft.rtet.datacomponent.entity.Card;

public class CardDAOImpl implements PaymentOption {

	public String cardno;
	public String nameoncard;
	public String expirydate;    
	public String cvvno;    
	public String bankname;
	public String type;
	public String vendor;
	
	public static void main(String args[]) 
	{
	 CardDAOImpl carImpl = new CardDAOImpl();
		  Card card = new Card();
		
		  card.setcardno("123456");
		  card.setnameoncard("siddu");
		  card.setexpirydate("210517");
		  card.setcvvno("sddu1234");
		  card.setbankname("canara");
		  card.settype("indiv");
		  card.setvendor("material");
		  
			System.out.println(" =======CREATE =======");
			carImpl.addCard(card);
			carImpl.addCard(card);
			carImpl.addCard(card);
			
			System.out.println(" =======READ =======");
			Set<Card> car1 =carImpl.getCard();
			for(Card car: car1) {
				System.out.println(car.toString());
			}	
			System.out.println(" =======UPDATE =======");
			  card.setcardno("567");
			  card.setnameoncard("debit");
			  card.setexpirydate("220618");
			  card.setcvvno("cvv1");
			  card.setbankname("sbi");
			  card.settype("company");
			  card.setvendor("goods");
			carImpl.updateCard(card);
	
			System.out.println(" =======READ =======");
			Set<Card> cars = carImpl.getCard();
			for(Card car: cars) {
				System.out.println(car.toString());
			}
			System.out.println(" =======DELETE ======= ");
			carImpl.removeCard(card.getCardId());
			
			System.out.println(" =======READ =======");
			Set<Card> car3 =carImpl.getCard();
			for(Card car: car3) {
				System.out.println(car.toString());
			}		
	}
	
	//Reading Card data from Database
	public Set<Card> getCard() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Card");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Card> Card = new HashSet<Card>(myList);
		session.close();
		System.out.println("Found " + Card.size() + " Card");
		return Card;
		
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
	
//Inserting Card Data to Database
	public Integer addCard(Card card) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(card);
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
		System.out.println("Successfully Inserted " + card.toString());
		return card.getCardId();

	}
	
//Updating Card data to the Database
	public void updateCard(Card Card) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Card cr = (Card) session.load(Card.class, Card.getCardId());
		
		cr.setcardno(Card.getcardno());
		cr.setnameoncard(Card.getnameoncard());
		cr.setexpirydate(Card.getexpirydate());
		cr.setcvvno(Card.getcvvno());
		cr.setbankname(Card.getbankname());
		cr.settype(Card.gettype());
		cr.setvendor(Card.getvendor());
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
		
		System.out.println("Successfully updated " + Card.toString());

	}
//Deleting Card the data From Database
	public  void removeCard(Integer id) {
		Session session = getSessionFactory().openSession();
		Card car = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(car);
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
		System.out.println("Successfully deleted " + car.toString());

	}
//Card finding by NAME
	public static Card findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Card car = (Card) session.load(Card.class, id);
		session.close();
		return car;
	}
	public void removeCard(Card Card) {
		// TODO Auto-generated method stub
		
	}
	public void getCard(Integer id) {
		// TODO Auto-generated method stub
		
	}
	public void getCard(String name) {
		// TODO Auto-generated method stub
		
	}
}
