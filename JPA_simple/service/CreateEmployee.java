package com.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eclipselink.entity.Employee;

/**
 * Class Name : CreateEmployee
 * [Creates a new employee entry in database.]
 *
 */
public class CreateEmployee {
	
	/**
	 * Method Name : main
	 * @param args
	 * EntityManagerFactory and EntityManager instances are created and used.
	 */
	public static void main(String args[]){
		/**
		 * EntityManagerFactory and EntityManager instances are created.
		 */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		/**
		 * Transaction begin.
		 */
		entityManager.getTransaction().begin();
		Employee employee = new Employee();
		employee.setDeg("SET");
		employee.setEid(1);
		employee.setEname("Manan");
		employee.setSalary(25000);
		/**
		 * Persist and commit.
		 */
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		/**
		 * entityManager and entityManagerFactory are closed.
		 */
		entityManager.close();
		entityManagerFactory.close();
	}

}
