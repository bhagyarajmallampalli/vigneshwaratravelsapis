package com.tis.travels.rest.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Invoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8035172887778956745L;
	private int invoiceNo;
	private String bookedBy;
	private int customerID;
	private String guestPhoneNo;
	private Date startTime;
	private Date endTime;
	private String totalHours;
	private int driverBatta;
	private String vehicleNumber;
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getGuestPhoneNo() {
		return guestPhoneNo;
	}
	public void setGuestPhoneNo(String guestPhoneNo) {
		this.guestPhoneNo = guestPhoneNo;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public int getDriverBatta() {
		return driverBatta;
	}
	public void setDriverBatta(int driverBatta) {
		this.driverBatta = driverBatta;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
}
