package com.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eclipselink.entity.Employee;
/**
 * Class Name : UpdateEmployee
 * [Updates employee entry in database.]
 *
 */
public class UpdateEmployee {
	
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
		Employee employee = entityManager.find(Employee.class, 1);
		/**
		 * Before Update
		 */
		System.out.println(employee.getDeg());
		/**
		 * Updating Records
		 */
		employee.setDeg("SE");
		employee.setSalary(30000);
		/**
		 * Commit
		 */
		entityManager.getTransaction().commit();
		/**
		 * After Update
		 */
		System.out.println(employee.getDeg());
		/**
		 * entityManager and entityManagerFactory are closed.
		 */
		entityManager.close();
		entityManagerFactory.close();
	}

}
