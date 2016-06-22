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


import com.vdinnosoft.rtet.datacomponent.entity.Company;
import com.vdinnosoft.rtet.datacomponent.entity.Individual;

public class IndividualDAOImpl implements CustomerType {
	
    public String name; 
    public String initials; 
    public String surname;    
    public String occupation;     
    public String designation; 
    public String businesscatagory;
    public String organization;
    
    public static void main(String args[]) 
	{
		  IndividualDAOImpl indivImpl = new IndividualDAOImpl();
		  Individual individual= new Individual();
		
		  individual.setname("ABC");
		  individual.setinitials("DEF");
		  individual.setsurname("GHI");
		  individual.setoccupation("JKL");
		  individual.setdesignation("MNO");
		  individual.setbusinesscatagory("PQR");
		  individual.setorganization("XYZ");
		  
			System.out.println(" =======CREATE =======");
			indivImpl.addIndividual(individual);
			indivImpl.addIndividual(individual);
			indivImpl.addIndividual(individual);
			
			System.out.println(" =======READ =======");
			Set<Individual> indiv1 =indivImpl.getIndividual();
			for(Individual indiv: indiv1) {
				System.out.println(indiv.toString());
			}	
			System.out.println(" =======UPDATE =======");
			individual.setname("abc");
			individual.setinitials("def");
			individual.setsurname("ghi");
			individual.setoccupation("jkl");
			individual.setdesignation("mno");
			individual.setbusinesscatagory("pqr");
			individual.setorganization("xyz");
			indivImpl.updateIndividual(individual);
	
			System.out.println(" =======READ =======");
			Set<Individual> indivs = indivImpl.getIndividual();
			for(Individual indiv: indivs) {
				System.out.println(indiv.toString());
			}
			System.out.println(" =======DELETE ======= ");
			indivImpl.removeIndividual(individual.getIndividualId());
			
			System.out.println(" =======READ =======");
			Set<Individual> indiv3 =indivImpl.getIndividual();
			for(Individual indiv: indiv3) {
				System.out.println(indiv.toString());
			}		
	}
	
	//Reading Individual data from Database
	public Set<Individual> getIndividual() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Individual");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Individual> individual = new HashSet<Individual>(myList);
		session.close();
		System.out.println("Found " + individual.size() + " individual");
		return individual;
		
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
	
//Inserting Individual Data to Database
	public Integer addIndividual(Individual individual) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{			
	    tx=session.beginTransaction();
		session.save(individual);
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
		System.out.println("Successfully Inserted " + individual.toString());
		return individual.getIndividualId();

	}
	
//Updating Individual data to the Database
	public void updateIndividual(Individual individual) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Individual in = (Individual) session.load(Individual.class, individual.getIndividualId());
		
		in.setname(individual.getname());
		in.setinitials(individual.getinitials());
		in.setsurname(individual.getsurnames());
		in.setoccupation(individual.getoccupation());
		in.setdesignation(individual.getdesignation());
		in.setbusinesscatagory(individual.getbusinesscatagory());
		in.setorganization(individual.getorganization());
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
		
		System.out.println("Successfully updated " + individual.toString());

	}
//Deleting Individual the data From Database
	public  void removeIndividual(Integer id) {
		Session session = getSessionFactory().openSession();
		Individual indiv = findByID(id);
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		
		session.delete(indiv);
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
		System.out.println("Successfully deleted " + indiv.toString());

	}
//Individual finding by NAME
	public static Individual findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Individual indiv = (Individual) session.load(Individual.class, id);
		session.close();
		return indiv;
	}
	public void removeIndividual(Individual individual) {
		// TODO Auto-generated method stub
		
	}
	public void getIndividual(Integer id) {
		// TODO Auto-generated method stub
		
	}
	public void getIndividual(String name) {
		// TODO Auto-generated method stub
		
	}
	
}
