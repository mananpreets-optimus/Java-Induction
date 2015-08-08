package com.restwebservice.RestWsEHCaching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Statistics;

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
/**
 * @author optimus3
 *
 */
public class EmployeeDAO {
	CacheManager cacheManager = CacheManager.getInstance();
	List<Employee> employees = new ArrayList<Employee>();
	/*
	 * Method Name: addEmployee parameters empName, gender, address
	 */
	/**
	 * @param empName
	 * @param gender
	 * @param address
	 * @param city
	 * @param state
	 * @param telephone
	 */
	public void addEmployee(String empName, String gender, String address,
			String city, String state, int telephone) {
		/*
		 * Logger and configuration
		 */
		Logger logger = Logger.getLogger("EmployeeDAO");
		PropertyConfigurator.configure(this.getClass().getClassLoader()
				.getResource("log4j.properties"));
		/*
		 * SessionFactory object is configured and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		logger.info("Session is opened");
		Transaction trans = null;
		Integer empId = null;
		try {
			/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			Employee employee = new Employee(empName, gender, address, city,
					state, telephone);
			empId = (Integer) session.save(employee);
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

	}

	public List<Employee> getEmployee(Integer id) {

		// SessionFactory object is configured and session is opened.

		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		List<String> list = new ArrayList<String>();
		Transaction trans = null;
		List employees = null;
		try {

			// Transaction begin.

			trans = session.beginTransaction();
			Query query = session.createQuery("FROM Employee Where id = :id");
			query.setParameter("id", id);
			employees = query.list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("EMPLOYEE_NAME: " + employee.getEmpName());
				System.out.println("ID: " + employee.getId());

				// Get Cache
				Cache cache = cacheMethod();
				// Put in cache
				cache.put(new Element(employee.getId(), employee));
			}

		} catch (HibernateException hibernateException) {
			if (trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
		return employees;
	}

	/**
	 * @param id
	 * @return
	 */
	public List<Employee> recieveRequest(Integer id) {
		System.out.println(id);
		Cache cache = cacheManager.getCache("newCache");
		System.out.println("Cache" + cache);
	
		if (cache == null) {
			System.out.println("Inside cache null");
			employees = getEmployee(id);
			return employees;
		} else {

			int check = check(cache, id);

			if (check == 1) {
			
				Employee employee = getCache(cache, id);
				System.out.println("After getcache , inside recieveRequest"+employee);
				employees.add(employee);
			} else {
			
				employees = getEmployee(id);
				Employee employee = getCache(cache, id);
				System.out.println("Employee"+employee);
			}
			return employees;
		}
	}

	/**
	 * @param cache
	 * @param id
	 * @return
	 */
	public int check(Cache cache, Integer id) {
		// int id1=id.intValue();
		String id1 = id.toString();
		System.out.println(id1);
		System.out.println(cache.isKeyInCache(3));
		System.out.println(cache.isKeyInCache("3"));
		if (cache.isKeyInCache(id)) {
			
			return 1;
		} else {
			
			return 0;
		}

	}

	/**
	 * @param cache
	 * @param id
	 * @return
	 */
	public Employee getCache(Cache cache, Integer id) {
		
		return (Employee) cache.get(id).getObjectValue();
	}

	/**
	 * Method cacheMethod creates a cache Manager and creates a cache in cache
	 * manager
	 * 
	 * @return cache
	 */
	public Cache cacheMethod() {
		Map<Object, Element> map = new HashMap<Object, Element>();

		// Create a cache manager

		// Creates a cache called newCache
		cacheManager.addCache("newCache");

		// Get cache called newCache
		Cache cache = cacheManager.getCache("newCache");
		Statistics stats = cache.getStatistics();
		return cache;
	}

	/*
	 * Method Name: getEmployeeDetails
	 */
	/**
	 * @return employees - list of employees
	 */
	public List<Employee> getEmployeeDetails() {
		/*
		 * SessionFactory object is configured and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		List employees = null;
		try {/*
			 * Transaction begin.
			 */
			trans = session.beginTransaction();
			employees = session.createQuery("FROM Employee").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("EMPLOYEE_NAME: " + employee.getEmpName());
				System.out.println("ID: " + employee.getId());
			}

		} catch (HibernateException hibernateException) {
			if (trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
		return employees;
	}

	/*
	 * Method Name: updateEmployee parameters id, empName, gender, address,
	 * city, state, telephone
	 */
	/**
	 * @param id
	 * @param empName
	 * @param gender
	 * @param address
	 * @param city
	 * @param state
	 * @param telephone
	 */
	public void updateEmployee(Integer id, String empName, String gender,
			String address, String city, String state, String telephone) {
		/*
		 * SessionFactory object is configured and session is opened.
		 */
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction trans = null;
		try {/*
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
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			/*
			 * Transaction commit.
			 */
			trans.commit();
			sessionFactory.close();
			System.out.println(empName + "" + id);
			System.out.println(query.toString());
		} catch (HibernateException hibernateException) {
			if (trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
	}

}
