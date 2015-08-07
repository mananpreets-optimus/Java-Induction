package com.addressbook;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO {
	public int isAdmin(String adminName, String password){
		int check = 0;
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			System.out.println("AAAAAAAAAAA");
			String hql = "FROM Admin WHERE adminName=:adminName AND password=:password";
			//logger.info("Transaction begin");
			
			System.out.println("BBBBB");
			Query query = session.createQuery(hql);
			query.setParameter("adminName", adminName);
			query.setParameter("password", password);
			System.out.println("CCC");
			List <User> list;
			list = query.list();
			System.out.println("aaa");
			//logger.info("Query is listed");
			Iterator <User> iterator = list.iterator();
			if(iterator.hasNext()){
				 check=1;
				
			}
			/*
			 * Transaction commit.
			 */
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
		return check;
	}
	
	public int isUser(String email, String password){
		int check = 0;
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			System.out.println("AAAAAAAAAAA");
			String hql = "FROM User WHERE email=:email AND password=:password";
			//logger.info("Transaction begin");
			System.out.println("BBBBB");
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			System.out.println("CCC");
			List <User> list;
			list = query.list();
			System.out.println("aaa");
			//logger.info("Query is listed");
			Iterator <User> iterator = list.iterator();
			if(iterator.hasNext()){
				 check=1;
				
			}
			/*
			 * Transaction commit.
			 */
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
		return check;
	}
	public List lisAllUsers(){
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		/*
		 * Transaction begin.
		 */
		Transaction trans = null;
		List users = null;
		try {
			trans = session.beginTransaction();
			users = session.createQuery("FROM User").list();
			for(Iterator iterator = users.iterator();iterator.hasNext();){
				User userDetails = (User) iterator.next();
				System.out.println("FIRST_NAME: "+userDetails.getFirstName());
				System.out.println("LAST_NAME: "+userDetails.getLastName());
				System.out.println(userDetails.getEmail());
			}
		}catch(HibernateException hibernateException){
			if(trans != null){
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
		
		finally{
			session.close();
		}
		return users;
	
		
	}
	public List searchAllUsers(String lastName){
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		List users = null;
		try {
			/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			Query query  = session.createQuery("FROM User  WHERE lastName like :lastName");
			query.setParameter("lastName", "%"+lastName+"%");
			users = query.list();
			for(Iterator iterator = users.iterator();iterator.hasNext();){
				User userDetails = (User) iterator.next();
				System.out.println("FIRST_NAME: "+userDetails.getFirstName());
				System.out.println("LAST_NAME: "+userDetails.getLastName());
				System.out.println(userDetails.getEmail());
			}
		}catch(HibernateException hibernateException){
			if(trans != null){
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
		
		finally{
			session.close();
		}
		return users;
	}
	
	public void addUser(String firstName, String lastName, String address,
			String email, String password){
		/*
		 * Logger and configuration
		 */
		/*Logger logger = Logger.getLogger("EmployeeDAO");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));*/
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		//logger.info("Session is opened");
		Transaction trans = null;
		Integer userId = null;
		try{
			/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			User user = new User(firstName, lastName, address, email, password);
			userId = (Integer) session.save(user);
			/*
			 * Transaction commit.
			 */
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
		
	}
	public void deleteUser(Integer userId) {
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try{
			/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			User user = (User) session.get(User.class, userId);
			session.delete(user);
			/*
			 * Transaction commit.
			 */
			trans.commit();
		} catch(HibernateException hibernateException) {
			if(trans != null){
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	
	
	
}
