package com.eclipselink.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class Name : NonTeachingStaff [Pojo Class consisting of variable
 * areaExpertise]
 */
@Entity
@DiscriminatorValue(value = "NS")
public class NonTeachingStaff extends Staff {

	private String areaExpertise;

	/**
	 * Constructor
	 * 
	 * @param sid
	 * @param sname
	 * @param areaexpertise
	 */
	public NonTeachingStaff(int sid, String sname, String areaexpertise) {
		super(sid, sname);
		this.areaExpertise = areaexpertise;
	}

	/**
	 * Default Constructor
	 */
	public NonTeachingStaff() {
		super();
	}

	/**
	 * @return areaExpertise
	 */
	public String getAreaexpertise() {
		return areaExpertise;
	}

	/**
	 * @param areaExpertise
	 */
	public void setAreaexpertise(String areaExpertise) {
		this.areaExpertise = areaExpertise;
	}
}
