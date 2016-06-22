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


class CompanyDAOImpl implements CustomerType {
		
	public String servicetaxnumber;
	public String vatnumber;
	public String registeredname;
	public String registeredaadress;
	public String registeredlogo;
	public String businesscatagory;
	public String noofemployees;
	public String description;	
	public ContactDAOImpl contacts;
	public Set<ContactDAOImpl> ownercontacts; 
	public Set<ContactDAOImpl> secondarycontacts;
	public Set<CustomerType> CustomerType;
	
	public static void main(String args[]) 
	{
		CompanyDAOImpl compImpl = new CompanyDAOImpl();
		  Company company= new Company();
		
		  company.setservicetaxnumber("sevtax123");
		  company.setvatnumber("vatnum100");
		  company.setregisteredname("regname");
		  company.setregisteredaadress("vatnum100");
		  company.setbusinesscatagory("good");
		  company.setDescription("good is company");
		  company.setnoofemployees("10");
		  company.setregisteredlogo("2");
			 
			System.out.println(" =======CREATE =======");
			compImpl.addCompany(company);
			compImpl.addCompany(company);
			compImpl.addCompany(company);
			
			System.out.println(" =======READ =======");
			Set<Company> Comp1 =compImpl.getCompany();
			for(Company Comp: Comp1) {
				System.out.println(Comp.toString());
			}	
			System.out.println(" =======UPDATE =======");
			 company.setservicetaxnumber("sevtax999");
			  company.setvatnumber("vatnum1000");
			compImpl.updateCompany(company);
	
			System.out.println(" =======READ =======");
			Set<Company> Comps = compImpl.getCompany();
			for(Company Comp: Comps) {
				System.out.println(Comp.toString());
			}
			System.out.println(" =======DELETE ======= ");
			compImpl.removeCompany(company.getCompanyId());
			
			System.out.println(" =======READ =======");
			Set<Company> Comps3 =compImpl.getCompany();
			for(Company Comp: Comps3) {
				System.out.println(Comp.toString());
			}		
	}
	

	//Reading Company data from Database
	public Set<Company> getCompany() {
		Session session = getSessionFactory().openSession();
		Query query	=session.createQuery("FROM Company");
		List myList = query.list();
		@SuppressWarnings("unchecked")
		Set<Company> companys = new HashSet<Company>(myList);
		session.close();
		System.out.println("Found " + companys.size() + " companys");
		return companys;
		
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
		public Integer addCompany(Company company) {
			Session session = getSessionFactory().openSession();
			Transaction tx = null;
			try{			
		    tx=session.beginTransaction();
			session.save(company);
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
			System.out.println("Successfully Inserted " + company.toString());
			return company.getCompanyId();

		}
	
	
//Updating Company data to the Database
	public void updateCompany(Company company) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx=session.beginTransaction();
		Company cm = (Company) session.load(Company.class, company.getCompanyId());
		cm.setbusinesscatagory(company.getbusinesscatagory());
		cm.setvatnumber(company.getvatnumber());
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
		
		System.out.println("Successfully updated " + company.toString());

	}
//Deleting Company the data From Database
	public  void removeCompany(Integer id) {
		Session session = getSessionFactory().openSession();
		Company cust = findByID(id);
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
//Company finding by Id
	public static Company findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Company cust = (Company) session.load(Company.class, id);
		session.close();
		return cust;
	}
	public void removeCompany(Company company) {
		// TODO Auto-generated method stub
		
	}
	public void getCompany(String name) {
		// TODO Auto-generated method stub
		
	}
	public void getCompany(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
