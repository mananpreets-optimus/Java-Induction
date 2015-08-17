package com.eclipselink.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class Name : TeachingStaff [Pojo Class consisting of variables qualification,
 * subjectExpertise]
 */
@Entity
@DiscriminatorValue(value = "TS")
public class TeachingStaff extends Staff {

	private String qualification;
	private String subjectExpertise;

	/**
	 * @param sid
	 * @param sname
	 * @param qualification
	 * @param subjectExpertise
	 */
	public TeachingStaff(int sid, String sname, String qualification,
			String subjectExpertise) {
		super(sid, sname);
		this.qualification = qualification;
		this.subjectExpertise = subjectExpertise;
	}

	public TeachingStaff() {
		super();
	}

	/**
	 * @return qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return subjectExpertise
	 */
	public String getSubjectexpertise() {
		return subjectExpertise;
	}

	/**
	 * @param subjectExpertise
	 */
	public void setSubjectexpertise(String subjectExpertise) {
		this.subjectExpertise = subjectExpertise;
	}

}
