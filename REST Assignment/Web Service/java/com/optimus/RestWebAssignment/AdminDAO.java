package com.optimus.RestWebAssignment;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminDAO {
	public int isAdmin(String userName, String password){
		int check = 0;
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		
		try{
			trans = session.beginTransaction();
			String hql = "FROM Admin WHERE userName=:userName AND password=:password";
			Query query = session.createQuery(hql);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			List <Admin> list;
			list = query.list();
			Iterator <Admin> iterator = list.iterator();
			if(iterator.hasNext()){
				 check=1;
				
			}
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
}
