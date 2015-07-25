package com.optimus.bank;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BankTransactionsDAO {
	
/*	private int customerID;
	private int accountNo;
	private int */
	public void Deposit(Integer accountNo,float depositMoney){
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction trans = null;
	try{
		trans = session.beginTransaction();
		Query query=session.createQuery("UPDATE Account set balance+=:balance where accountNo=:accountNo");  
		query.setParameter("balance",depositMoney);  
		query.setParameter("accountNo",accountNo);  
	}catch(HibernateException hibernateException){
		if(trans != null){
			trans.rollback();
		}
		hibernateException.printStackTrace();
	}
	}
	
	public void withdraw(){
		
	}
}
