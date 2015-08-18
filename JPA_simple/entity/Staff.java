package com.eclipselink.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Class Name : Staff [Pojo Class consisting of variable sId, sName ]
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Staff implements Serializable {

	@Id
	private int sId;
	private String sName;

	public Staff() {
		super();
	}

	/**
	 * @param sId
	 * @param sName
	 */
	public Staff(int sId, String sName) {
		super();
		this.sId = sId;
		this.sName = sName;
	}

	/**
	 * @return sId
	 */
	public int getSid() {
		return sId;
	}

	/**
	 * @param sId
	 */
	public void setSid(int sId) {
		this.sId = sId;
	}

	/**
	 * @return sName
	 */
	public String getSname() {
		return sName;
	}

	/**
	 * @param sName
	 */
	public void setSname(String sName) {
		this.sName = sName;
	}

}
