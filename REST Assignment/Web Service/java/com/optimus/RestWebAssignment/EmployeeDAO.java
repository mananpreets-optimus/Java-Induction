/*
 * Package Name: com.optimus.RestWebAssignment
 */
package com.optimus.RestWebAssignment;

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


/*
 * Class Name: EmployeeDAO
 * includes methods addEmployee, getEmployeeDetails, updateEmployee
 */
public class EmployeeDAO {
	/*
	 * Method Name: addEmployee
	 * parameters empName, gender, address
	 */
	public void addEmployee(String empName, String gender, String address,
			String city, String state, String telephone){
		/*
		 * Logger and configuration
		 */
		Logger logger = Logger.getLogger("EmployeeDAO");
		PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		logger.info("Session is opened");
		Transaction trans = null;
		Integer empId = null;
		try{
			/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			Employee employee = new Employee(empName, gender, address, city, state, telephone);
			empId = (Integer) session.save(employee);
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
	public List<Employee> getEmployeeDetails(){
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		List employees = null;
		try{/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			employees = session.createQuery("FROM Employee").list();
			for(Iterator iterator = employees.iterator();iterator.hasNext();){
				Employee employee = (Employee) iterator.next();
				System.out.println("EMPLOYEE_NAME: "+employee.getEmpName());
				System.out.println("ID: "+employee.getId());
			}
			
		}catch(HibernateException hibernateException){
			if(trans != null){
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}finally{
			session.close();
		}
		return employees;
	}
	public void updateEmployee(Integer id, String empName, String gender, String address,
			String city, String state, String telephone){
		/*
		 * SessionFactory object is configured 
		 * and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try{/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			System.out.println("Id: " + id + "name: " + empName);
			String hql = "UPDATE Employee set empName = :empName,gender = :gender,address=:address,city=:city,state=:state,telephone=:telephone WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("empName", empName);
			query.setParameter("id", id);
			query.setParameter("gender", gender);
			query.setParameter("address", address);
			query.setParameter("city", city);
			query.setParameter("state", state);
			query.setParameter("telephone", telephone);
			int result= query.executeUpdate();
			System.out.println("Rows affected: " + result);
			/*
			 * Transaction commit.
			 */
			trans.commit();
			sessionFactory.close();
			System.out.println(empName+""+id);
			System.out.println(query.toString());
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
}
