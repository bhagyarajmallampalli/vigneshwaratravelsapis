package com.tis.travels.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InvoiceData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8233179878427422860L;
	
	
	
	private int dutySlipNo;
	private String customerName;
	private String vehicleNumber;
	private String guestName;
	private String vehicleType;
	private String guestNumber;
	private String bookedBy;
	private String Journey;
	private double hireCharges;
	private double startKMs;
	private double dieselCharges;
	private double endKMs;
	private double driverAllowances;
	private double totalKMs;
	private double tollGate;
	private String startingTime;
	private double total;
	private String endingTime;
	private String totalHours;
	private String deptName;
	
	private int vehicleMileage;
	
	
	public int getDutySlipNo() {
		return dutySlipNo;
	}
	public void setDutySlipNo(int dutySlipNo) {
		this.dutySlipNo = dutySlipNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getGuestNumber() {
		return guestNumber;
	}
	public void setGuestNumber(String guestNumber) {
		this.guestNumber = guestNumber;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
	public String getJourney() {
		return Journey;
	}
	public void setJourney(String journey) {
		Journey = journey;
	}
	public double getHireCharges() {
		return hireCharges;
	}
	public void setHireCharges(double hireCharges) {
		this.hireCharges = hireCharges;
	}
	public double getStartKMs() {
		return startKMs;
	}
	public void setStartKMs(double startKMs) {
		this.startKMs = startKMs;
	}
	public double getDieselCharges() {
		return dieselCharges;
	}
	public void setDieselCharges(double dieselCharges) {
		this.dieselCharges = dieselCharges;
	}
	public double getEndKMs() {
		return endKMs;
	}
	public void setEndKMs(double endKMs) {
		this.endKMs = endKMs;
	}
	public double getDriverAllowances() {
		return driverAllowances;
	}
	public void setDriverAllowances(double driverAllowances) {
		this.driverAllowances = driverAllowances;
	}
	public double getTotalKMs() {
		return totalKMs;
	}
	public void setTotalKMs(double totalKMs) {
		this.totalKMs = totalKMs;
	}
	public double getTollGate() {
		return tollGate;
	}
	public void setTollGate(double tollGate) {
		this.tollGate = tollGate;
	}
	public String getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getEndingTime() {
		return endingTime;
	}
	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}
	public String getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getVehicleMileage() {
		return vehicleMileage;
	}
	public void setVehicleMileage(int vehicleMileage) {
		this.vehicleMileage = vehicleMileage;
	}
	
}
