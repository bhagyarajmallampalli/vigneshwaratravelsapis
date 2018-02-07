package com.tis.travels.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.tis.travels.rest.beans.CarTrans;

public class CarsTransHandler {
	
	
	
	public int nextInvoiceNumber(Connection connection) throws Exception {
		int nextNo=0;
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT max(trans_id) invoiceNumber FROM car_trans");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nextNo = rs.getInt("invoiceNumber");
			}
			return nextNo;
		} catch (Exception e) {
			throw e;
		}
	}

	
	
	
	public ArrayList<CarTrans> getCarTransByDate(Connection connection, String transDate) throws Exception {
		ArrayList<CarTrans> carTransList = new ArrayList<CarTrans>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM car_trans where car_trans_date = '"+transDate+"'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CarTrans carTrans = new CarTrans();
				carTrans.setTransID(rs.getInt("trans_id"));
				carTrans.setDeptID(rs.getInt("dept_id"));
				carTrans.setVehicleNumber(rs.getString("vehicle_number"));
				carTrans.setGuestName(rs.getString("Guest_name"));
				carTrans.setStartKM(rs.getInt("start_km"));
				carTrans.setEndKM(rs.getInt("end_km"));
				carTrans.setDutySlipNo(rs.getInt("duty_slip_no"));
				carTrans.setTotalKMs(rs.getInt("total_km"));
				carTrans.setFuelCharges(rs.getDouble("fuel_charges"));
				carTrans.setFixedRent(rs.getDouble("fixed_rent"));
				carTrans.setTollGateCharge(rs.getDouble("toll_gate_charge"));
				carTrans.setDriverBatta(rs.getDouble("driver_batta"));
				carTrans.setTotalAmount(rs.getDouble("Total_amount"));
				carTrans.setCustomerName(rs.getString("customer_name"));
				carTrans.setEndtime(rs.getString("endtime"));
				carTrans.setStarttime(rs.getString("starttime"));
				carTrans.setJourney(rs.getString("journey"));
				carTrans.setTotalHours(rs.getString("totalhours"));
				carTrans.setGuestPhoneNo(rs.getString("guest_number"));
				carTransList.add(carTrans);
			}
			return carTransList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	public boolean saveCarTrans(Connection connection, CarTrans carTrans) {
		
		try {
			String query = "insert into car_trans(dept_id,vehicle_number,Guest_name,"+
					"start_km,end_km, duty_slip_no,Car_trans_date,total_km,fuel_charges,fixed_rent,"
					+ "toll_gate_charge,driver_batta,Total_amount, starttime, endtime, totalhours, journey,customer_name, guest_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = null;
			System.out.println("dutySlipNo id::"+carTrans.getDutySlipNo());
			
			ps = connection.prepareStatement(query);
			
			ps.setInt(1, carTrans.getDeptID());
			ps.setString(2, carTrans.getVehicleNumber());
			ps.setString(3, carTrans.getGuestName());
			ps.setInt(4, carTrans.getStartKM());
			ps.setInt(5, carTrans.getEndKM());
			ps.setInt(6, carTrans.getDutySlipNo());
			System.out.println("car Trans::"+carTrans.getTransDate());
//			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date(carTrans.getTransDate()).getTime());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
            java.util.Date YourResult=dateFormat.parse(carTrans.getTransDate());
            java.sql.Date todayssqldate=new java.sql.Date(YourResult.getTime());
            
			ps.setTimestamp(7, new Timestamp(todayssqldate.getTime()));
			ps.setInt(8, carTrans.getTotalKMs());
			ps.setDouble(9, carTrans.getFuelCharges());
			ps.setDouble(10, carTrans.getFixedRent());
			ps.setDouble(11, carTrans.getTollGateCharge());
			ps.setDouble(12, carTrans.getDriverBatta());
			ps.setDouble(13, carTrans.getTotalAmount());
			ps.setString(14, carTrans.getStarttime());
			ps.setString(15, carTrans.getEndtime());
			ps.setString(16, carTrans.getTotalHours());
			ps.setString(17, carTrans.getJourney());
			ps.setString(18, carTrans.getCustomerName());
			ps.setString(19, carTrans.getGuestPhoneNo());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			//throw e;
			e.printStackTrace();
			return false;
		}
	}
}