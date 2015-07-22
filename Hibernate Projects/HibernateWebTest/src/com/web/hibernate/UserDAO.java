/*
 * Package Name: com.web.hibernate
 */
package com.web.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/*
 * Class Name: UserDAO
 * includes methods addUser and listAllUsers 
 */
public class UserDAO {
	/*
	 * Method Name: addUser
	 * parameters userName, password
	 * user is added to database table
	 */
	public Integer addUser(String userName, String password) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		Integer userId=null;
		try{
			trans = session.beginTransaction();
			UserDetails user = new UserDetails(userName,password);
			userId=(Integer) session.save(user);
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
		return userId;
	}
	/*
	 * Mthod Name: listAllUsers
	 * returns- users as a list
	 */
	public List listAllUsers() {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		List users = null;
		try {
			trans = session.beginTransaction();
			users = session.createQuery("FROM UserDetails").list();
			for(Iterator iterator = users.iterator();iterator.hasNext();){
				UserDetails userDetails = (UserDetails) iterator.next();
				System.out.println("USER_NAME: "+userDetails.getUserName());
				System.out.println("USER_ID: "+userDetails.getId());
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
}
