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

import com.vdinnosoft.rtet.datacomponent.entity.Location;

public class LocationDAOImpl {
	public Integer emlpoyeeid;
	public Double lattitude;
	public Double longitude;
	public String timestamp;
	public Integer imei;
	public String mobilenumber;
	public static void main(String args[]) 
	{
	
	  LocationDAOImpl LocatImpl=new LocationDAOImpl();
	  Location location=new Location();
	 
	  location.seMobileNumber("9916335728");
	  location.setLattitude(34455.45);
	  location.setLongitude(5777.56);
	  location.setImei("4567");
	  location.setTimeStamp("5:30");
	
		System.out.println(" =======CREATE =======");
		LocatImpl.addLocation(location);
		System.out.println(location);
		LocatImpl.addLocation(location);
		LocatImpl.addLocation(location);
		
		System.out.println(" =======READ =======");
		
		Set<Location> lcs1 =LocatImpl.getLocation();
		for(Location e: lcs1) {
			System.out.println(e.toString());
		}	
		System.out.println(" =======UPDATE =======");
		location.setLattitude(7888.67);
		location.setLongitude(4566.67);
		LocatImpl.updateLocation(location);

		System.out.println(" =======READ =======");
		Set<Location> lcs2 = LocatImpl.getLocation();
		for(Location e: lcs2) {
			System.out.println(e.toString());
		}
		System.out.println(" =======DELETE ======= ");
		LocatImpl.removeLocation(location.getLocationId());
		System.out.println(" =======READ =======");
		Set<Location> lcs3 = LocatImpl.getLocation();
		for(Location e: lcs3) {
			System.out.println(e.toString());
		}
	}		

//Reading Location data from Database
public  Set<Location> getLocation() {
	Session session = getSessionFactory().openSession();	
	Query query	=session.createQuery("FROM Location");
	List myList = query.list();
	@SuppressWarnings("unchecked")
	Set<Location> locations = new HashSet<Location>(myList);
	session.close();
	System.out.println("Found " + locations.size() + " locations");
	return locations;
	
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

//Inserting Location Data to Database
public Integer addLocation(Location location) {
	Session session = getSessionFactory().openSession();
	Transaction tx = null;
	try{
	tx=session.beginTransaction();
	session.save(location);
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
	System.out.println("Successfully created " + location.toString());
	return location.getLocationId();
}

//Updating Location data to the Database
public void updateLocation(Location location) {
	Session session = getSessionFactory().openSession();
	Transaction tx = null;
	try{
	tx=session.beginTransaction();
	Location lm = (Location) session.load(Location.class, location.getLocationId());
	lm.seMobileNumber(location.getMobileNumber());
	lm.setLongitude(location.getLongitude());
	lm.setLattitude(location.getLattitude());
	lm.setImei(location.getImei());
	lm.setTimeStamp(location.getTimeStamp());
	
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
	
	System.out.println("Successfully updated " + location.toString());

}

//Deleting Location the data From Database
public void removeLocation(Integer id) {
	Session session = getSessionFactory().openSession();
	Location location = findByID(id);
	Transaction tx = null;
	try{
	tx=session.beginTransaction();
	
	session.delete(location);
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
	System.out.println("Successfully deleted " + location.toString());

}

//Employee finding by Id
public static Location findByID(Integer id) {
	Session session = getSessionFactory().openSession();
	Location location = (Location) session.load(Location.class, id);
	session.close();
	return location;
}


public void getLocation(Integer id) {
	// TODO Auto-generated method stub
	
}
public void getLocation(String name) {
		// TODO Auto-generated method stub
		
}
public void removeLocation(Location location) {
		// TODO Auto-generated method stub
		
}
}
	
