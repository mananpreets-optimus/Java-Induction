package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentStoreData {
	public static void main(String args[]) {
		/*
		 * Configuration object is created 
		 */
		Configuration cfg = new Configuration();
		cfg.configure("student.cfg.xml");
		/*
		 * 
		 */
		SessionFactory factory = cfg.buildSessionFactory();
		/*
		 * 
		 */
		Session session = factory.openSession();
		/*
		 * 
		 */
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setAge(12);
		student.setId(1);
		student.setName("Manan");
		/*
		 * persisting the object
		 */
		session.persist(student);
		/*
		 * transaction is committed
		 */
		transaction.commit();
		session.close();
		System.out.println("HELLO");
		
	}

}
