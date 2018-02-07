package com.tis.travels.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarTrans implements Serializable {

	
	/**
	 * 
	 */
	public CarTrans() {}
	private static final long serialVersionUID = 4045168309040825772L;
	
	private int transID;
	private int deptID;
	private String vehicleNumber;
	private String guestName;
	private int startKM;
	private int endKM;
	private int dutySlipNo;
	private String transDate;
	private int totalKMs;
	private double fuelCharges;
	private double fixedRent;
	private double tollGateCharge;
	private double driverBatta;
	private double totalAmount;
	private String journey;
	
	private String starttime;
	private String endtime;
	
	private String totalHours;
	
	private String customerName;
	
	private String guestPhoneNo;
	
	
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	
	
	public int getTransID() {
		return transID;
	}
	public void setTransID(int transID) {
		this.transID = transID;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public int getStartKM() {
		return startKM;
	}
	public void setStartKM(int startKM) {
		this.startKM = startKM;
	}
	public int getEndKM() {
		return endKM;
	}
	public void setEndKM(int endKM) {
		this.endKM = endKM;
	}
	public int getDutySlipNo() {
		return dutySlipNo;
	}
	public void setDutySlipNo(int dutySlipNo) {
		this.dutySlipNo = dutySlipNo;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public int getTotalKMs() {
		return totalKMs;
	}
	public void setTotalKMs(int totalKMs) {
		this.totalKMs = totalKMs;
	}
	public double getFuelCharges() {
		return fuelCharges;
	}
	public void setFuelCharges(double fuelCharges) {
		this.fuelCharges = fuelCharges;
	}
	public double getFixedRent() {
		return fixedRent;
	}
	public void setFixedRent(double fixedRent) {
		this.fixedRent = fixedRent;
	}
	public double getTollGateCharge() {
		return tollGateCharge;
	}
	public void setTollGateCharge(double tollGateCharge) {
		this.tollGateCharge = tollGateCharge;
	}
	public double getDriverBatta() {
		return driverBatta;
	}
	public void setDriverBatta(double driverBatta) {
		this.driverBatta = driverBatta;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getJourney() {
		return journey;
	}
	public void setJourney(String journey) {
		this.journey = journey;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGuestPhoneNo() {
		return guestPhoneNo;
	}
	public void setGuestPhoneNo(String guestPhoneNo) {
		this.guestPhoneNo = guestPhoneNo;
	}	
}
