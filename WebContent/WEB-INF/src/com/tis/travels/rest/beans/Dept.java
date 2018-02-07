package com.tis.travels.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6917830365146835447L;
	private String deptName;
	private int deptID;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
}
