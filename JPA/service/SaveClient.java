package com.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.eclipselink.entity.NonTeachingStaff;
import com.eclipselink.entity.TeachingStaff;

/**
 * Class Name : SaveClient [Saves Client]
 *
 */
public class SaveClient {
	public static void main(String[] args) {
		/**
		 * EntityManagerFactory and EntityManager instances are created.
		 */
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("JPAProject");
		EntityManager entitymanager = emfactory.createEntityManager();
		/**
		 * Transaction begin.
		 */
		entitymanager.getTransaction().begin();

		/**
		 *  Teaching staff entity
		 */
		TeachingStaff ts1 = new TeachingStaff(1, "Gopal", "MSc MEd", "Maths");
		TeachingStaff ts2 = new TeachingStaff(2, "Manisha", "BSc BEd","English");

		/**
		 *  Non-Teaching Staff entity
		 */
		NonTeachingStaff nts1 = new NonTeachingStaff(3, "Satish", "Accounts");
		NonTeachingStaff nts2 = new NonTeachingStaff(4, "Krishna","Office Admin");

		/**
		 *  storing all entities
		 */
		/**
		 * Persist and commit.
		 */
		entitymanager.persist(ts1);
		entitymanager.persist(ts2);
		entitymanager.persist(nts1);
		entitymanager.persist(nts2);

		entitymanager.getTransaction().commit();
		/**
		 * entityManager and entityManagerFactory are closed.
		 */
		entitymanager.close();
		emfactory.close();
	}
}
