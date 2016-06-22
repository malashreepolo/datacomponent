package com.vdinnosoft.rtet.datacomponent.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.vdinnosoft.rtet.datacomponent.entity.Employee;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.vdinnosoft.rtet.datacomponent.entity.Location;
import com.vdinnosoft.rtet.datacomponent.entity.Mobile;

public class EmployeeDAOImpl {

	public String employeename;
	public String initials;
	public String surname;
	public String username;
	public String password;
	public String mobileNo;
	public String gender;
	public String address;
	public String pincode;
	public Set<Location> locations; 
	public Set<Mobile> moblies;
	public Location location;
	public Mobile mobile;	
	
	public static void main(String args[]) 
	{
    	EmployeeDAOImpl empImpl= new EmployeeDAOImpl();
    	Employee employee=new Employee();
    	
    	employee.setEmployeename("Vinay");
    	employee.setInitials("l");
    	employee.setSurname("kulkarni");
    	employee.setPincode("565412");    	
    	employee.setPassword("malashree");
    	employee.setUsername("malashree@vdinnosoft.com");
    	employee.setAddress("27/1 'Nesco Building' 3rd floor khanapur Belgaum");
    	employee.setMobileNo("8123187790");
    	employee.setGender("Male");
		
		System.out.println(" =======CREATE =======");
		empImpl.addEmployee(employee);
		System.out.println(employee);
		empImpl.addEmployee(employee);
		empImpl.addEmployee(employee);
		
		System.out.println(" =======READ =======");
		Set<Employee> ems1 =empImpl.getEmployee();
		for(Employee e: ems1) {
			System.out.println(e.toString());
		}	
		System.out.println(" =======UPDATE =======");
		employee.setEmployeename("mala");
		employee.setUsername("vd");
		empImpl.updateEmployee(employee);

		System.out.println(" =======READ =======");
		Set<Employee> ems2 = empImpl.getEmployee();
		for(Employee e: ems2) {
			System.out.println(e.toString());
		}
		System.out.println(" =======DELETE ======= ");
		empImpl.removeEmployee(employee.getEmployeeID());
		System.out.println(" =======READ =======");
		Set<Employee> ems3 = empImpl.getEmployee();
		for(Employee e: ems3) {
			System.out.println(e.toString());
		}
	
}
    
  //Reading Employee data from Database
    public Set<Employee> getEmployee() {
	Session session = getSessionFactory().openSession();
	Query query	=session.createQuery("FROM Employee");
	List myList = query.list();
	@SuppressWarnings("unchecked")
	Set<Employee> employees = new HashSet<Employee>(myList);
	session.close();
	System.out.println("Found " + employees.size() + " employees");
	return employees;
	
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
public Integer addEmployee(Employee employee) {
	Session session = getSessionFactory().openSession();
	Transaction tx = null;
	try{
	tx=session.beginTransaction();
	session.save(employee);
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
	System.out.println("Successfully Inserted " + employee.toString());
	return employee.getEmployeeID();

}

//Updating Employee data to the Database
public void updateEmployee(Employee employee) {
	Session session = getSessionFactory().openSession();
	Transaction tx = null;
	try{
	tx=session.beginTransaction();
	Employee em = (Employee) session.load(Employee.class, employee.getEmployeeID());
	em.setEmployeename(employee.getEmployeename());
	em.setUsername(employee.getUsername());
	em.setMobileNo(employee.getMobileNo());
	em.setPincode(employee.getPincode());    	
	em.setPassword(employee.getPassword());
	em.setAddress(employee.getAddress());
	em.setInitials(employee.getInitials());
	em.setGender(employee.getGender());
	em.setSurname(employee.getSurname());
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
	System.out.println("Successfully updated " + employee.toString());

}

//Deleting Employee the data From Database
public void removeEmployee(Integer id) {
	Session session = getSessionFactory().openSession();
	Employee employee = findByID(id);
	Transaction tx = null;
	try{
	tx=session.beginTransaction();
	session.delete(employee);
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
	System.out.println("Successfully deleted " + employee.toString());

}

//Employee finding by Id
public static Employee findByID(Integer id) {
	Session session = getSessionFactory().openSession();
	Employee employee = (Employee) session.load(Employee.class, id);
	session.close();
	return employee;
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