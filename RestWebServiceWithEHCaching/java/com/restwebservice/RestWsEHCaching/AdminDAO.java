package com.restwebservice.RestWsEHCaching;

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

public class AdminDAO {
	public int isAdmin(String userName, String password) {
		int check = 0;
		/*
		 * Logger and configuration
		 */
		Logger logger = Logger.getLogger("AdminDAO");
		PropertyConfigurator.configure(this.getClass().getClassLoader()
				.getResource("log4j.properties"));
		logger.info("Inside Web Service");
		/*
		 * SessionFactory object is configured and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		logger.info("Session is opened");
		Transaction trans = null;

		try {
			/*
			 * Transaction begin
			 */
			trans = session.beginTransaction();
			String hql = "FROM Admin WHERE userName=:userName AND password=:password";
			logger.info("Transaction begin");
			Query query = session.createQuery(hql);
			query.setParameter("userName", userName);
			query.setParameter("password", password);
			List<Admin> list;
			list = query.list();
			logger.info("Query is listed");
			Iterator<Admin> iterator = list.iterator();
			if (iterator.hasNext()) {
				check = 1;

			}
			/*
			 * Transaction commit.
			 */
			trans.commit();
		} catch (HibernateException hibernateException) {
			if (trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
		return check;

	}

}
