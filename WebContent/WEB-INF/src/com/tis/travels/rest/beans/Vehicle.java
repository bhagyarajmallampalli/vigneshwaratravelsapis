package com.tis.travels.rest.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6789226221188214679L;
	private String vehicleNumber;
	private String vehicleName;
	private String vehicleType;
	private int vehicleMileage;
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getVehicleMileage() {
		return vehicleMileage;
	}
	public void setVehicleMileage(int vehicleMileage) {
		this.vehicleMileage = vehicleMileage;
	}
	
	
	
}
