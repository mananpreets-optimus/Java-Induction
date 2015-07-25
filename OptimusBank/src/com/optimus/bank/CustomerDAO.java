package com.optimus.bank;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerDAO {
	public Integer addNewCustomer(String customerName, String gender, String dateOfBirth,
	String address, String city, String state, String pin, String telephoneNo, String fax, String email){
		SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		Integer customerID = null;
		try{
			trans = session.beginTransaction();
			System.out.println(",,,,,,,,,,,");
			Customer customer = new Customer(customerName, gender, dateOfBirth, address, city, state, pin, telephoneNo, fax, email);
			System.out.println(",,,,,,7777");
			customerID= (Integer) session.save(customer);
			System.out.println(customerID);
			trans.commit();
			
		}catch(HibernateException hibernateException){
			if(trans != null){
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
		finally{
			session.close();
		}
		return customerID;
		
	}

}
