package com.hibernate;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
/*
 * Class Name: StudentStoreData
 */
public class StudentStoreData {
	public static void main(String args[]) {
		
		Student student = new Student();
		student.setId(1);
		student.setName("Manan");
		SessionFactory sessionFactory= new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = 	sessionFactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		System.out.println("HELLO");
		
	}

}
