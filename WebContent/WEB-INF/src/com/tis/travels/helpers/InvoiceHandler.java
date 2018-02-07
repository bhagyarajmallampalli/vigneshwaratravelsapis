package com.tis.travels.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tis.travels.rest.beans.InvoiceData;


public class InvoiceHandler {

	public InvoiceData getCarTransByDate(Connection connection, String transDate, String vehicleNumber) throws Exception {
		InvoiceData invoiceData = new InvoiceData();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT ct.duty_slip_no dutySlipNo, ct.customer_name customerName, ct.vehicle_number vehicleNumber, ct.guest_name guestName, \n" + 
					"v.vehicle_type vehicleType, ct.guest_number guestNumber, ct.guest_name bookedBy, ct.journey Journey,\n" + 
					"ct.fixed_rent hireCharges, ct.start_km startKMs,  ct.fuel_charges dieselCharges,\n" + 
					"ct.end_km endKMs, ct.driver_batta driverAllowances, ct.total_km totalKMs, ct.toll_gate_charge tollGate,\n" + 
					"ct.starttime startingTime, ct.total_amount total,  d.dept_name deptName, v.vehicle_mileage vehicleMileage,ct.endtime endingTime, ct.totalhours totalHours \n" + 
					"FROM travels_info_system.Car_trans ct, travels_info_system.vehicle_table v , dept_table d where ct.dept_id=d.dept_id and ct.vehicle_number=v.vehicle_number and \n" + 
					"ct.car_trans_date like '"+transDate+"%' and ct.vehicle_number = '"+vehicleNumber+"'");
			
			//DATE_FORMAT(car_trans_date, "%d/%m/%Y")
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				invoiceData.setDutySlipNo(rs.getInt("dutySlipNo"));
				invoiceData.setCustomerName(rs.getString("customerName"));
				invoiceData.setVehicleNumber(rs.getString("vehicleNumber"));
				invoiceData.setGuestName(rs.getString("guestName"));
				invoiceData.setVehicleType(rs.getString("vehicleType"));
				invoiceData.setGuestNumber(rs.getString("guestNumber"));
				invoiceData.setBookedBy(rs.getString("bookedBy"));
				invoiceData.setJourney(rs.getString("Journey"));
				invoiceData.setEndKMs(rs.getDouble("endKMs"));
				invoiceData.setStartKMs(rs.getDouble("startKMs"));
				invoiceData.setDriverAllowances(rs.getDouble("driverAllowances"));
				invoiceData.setTotalKMs(rs.getDouble("totalKMs"));
				invoiceData.setTollGate(rs.getDouble("tollGate"));
				invoiceData.setDieselCharges(rs.getDouble("dieselCharges"));
				invoiceData.setStartingTime(rs.getString("startingTime"));
				invoiceData.setTotal(rs.getDouble("total"));
				invoiceData.setEndingTime(rs.getString("endingTime"));
				invoiceData.setTotalHours(rs.getString("totalHours"));
				invoiceData.setDeptName(rs.getString("deptName"));
			}
			return invoiceData;
		} catch (Exception e) {
			throw e;
		}
	}

}