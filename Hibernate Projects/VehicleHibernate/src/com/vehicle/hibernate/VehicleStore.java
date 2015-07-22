package com.vehicle.hibernate;

import java.util.Iterator;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class VehicleStore {
	private static SessionFactory sessionfactory;
	
	public Integer addVehicle(String manufacturerName, String vehicleName) {
		Session session = sessionfactory.openSession();
		Transaction trans = null;
		Integer vehicleId = null;
		
		try{
			
			trans = session.beginTransaction();
			Vehicle vehicle = new Vehicle(manufacturerName,vehicleName);
			vehicleId = (Integer) session.save(vehicle);
			trans.commit();
			
		}catch(HibernateException hibernateException) {
			
			if(trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
			
		}
		finally {
			
			session.close();
		}
		return vehicleId;
	}
	
	/*
	 * Method to read all Vehicles
	 */
	public void listVehicle() {
		Session session = sessionfactory.openSession();
		Transaction trans = null;
		try{
			trans = session.beginTransaction();
			List vehicles = session.createQuery("FROM Vehicle").list();
			for(Iterator iterator = vehicles.iterator(); iterator.hasNext();) {
				
				Vehicle vehicle = (Vehicle) iterator.next();
				System.out.println("Vehicle Manufacturer Name = "+ vehicle.getManufacturerName());
				System.out.println("Vehicle Name = "+vehicle.getVehicleName());
				System.out.println("Vehicle Id"+vehicle.getId());
				
			}
			trans.commit();
			
		} catch(HibernateException hibernateException) {
			
			if(trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
	}
	/*
	 * Method to delete a vehicle
	 */
	public void deleteVehicle(Integer vehicleId) {
		Session session = sessionfactory.openSession();
		Transaction trans = null;
		try{
			System.out.println("Inside Delete Vehicle");
			trans = session.beginTransaction();
			Vehicle vehicle = (Vehicle) session.get(Vehicle.class, vehicleId);
			session.delete(vehicle);
			trans.commit();
		} catch(HibernateException hibernateException) {
			if(trans != null){
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	/*
	 * Method to update a vehicle
	 */
	public void updateVehicle(Integer vehicleId,String manufacturerName){
		Session session = sessionfactory.openSession();
		Transaction trans = null;
		try{
			System.out.println("Inside Update Vehicle");
			trans = session.beginTransaction();
			Vehicle vehicle = (Vehicle) session.get(Vehicle.class, vehicleId);
			vehicle.setManufacturerName(manufacturerName);
			session.update(vehicle);
			trans.commit();
			
		} catch(HibernateException hibernateException) {
			if(trans != null) {
				trans.rollback();
			}
			hibernateException.printStackTrace();
		}
		finally{
			session.close();
		}
	}
	
	
	
	public static void main(String args[]) {
		VehicleStore vehicleStore = new VehicleStore();
		try{
			sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*
		 * add vehicles
		 */
		Integer vehicleId101 = vehicleStore.addVehicle("Maruti", "Swift");
		Integer vehicleId102 = vehicleStore.addVehicle("Royal Enfield", "ThunderBird");
		Integer vehicleId103 = vehicleStore.addVehicle("Honda", "Amaze");
		/*
		 * list all vehicles
		 */
		vehicleStore.listVehicle();
		/*
		 * delete a vehicle
		 */
		System.out.println(vehicleId101);
		vehicleStore.deleteVehicle(vehicleId101);
		/*
		 * update a vehicle
		 */
		vehicleStore.updateVehicle(vehicleId103,"Mercerdes");
		
		vehicleStore.listVehicle();
		
	}

}
