package com.tis.travels.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tis.travels.rest.beans.Vehicle;

public class VehicleHandler {

	public ArrayList<Vehicle> getVehicles(Connection connection) throws Exception {
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicle_table");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vehicle vehicle = new Vehicle();
				vehicle.setVehicleNumber(rs.getString("vehicle_number"));
				vehicle.setVehicleName(rs.getString("vehicle_name"));
				vehicle.setVehicleType(rs.getString("vehicle_type"));
				vehicle.setVehicleMileage(rs.getInt("vehicle_mileage"));
				vehicleList.add(vehicle);
			}
			return vehicleList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Vehicle getVehicleByID(Connection connection, String vehicleNumber) throws Exception {
		Vehicle vehicle = new Vehicle();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicle_table where vehicle_number='"+vehicleNumber+"'");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				vehicle.setVehicleNumber(rs.getString("vehicle_number"));
				vehicle.setVehicleName(rs.getString("vehicle_name"));
				vehicle.setVehicleType(rs.getString("vehicle_type"));
				vehicle.setVehicleMileage(rs.getInt("vehicle_mileage"));	
			}
			return vehicle;
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean saveVehicle(Connection connection, Vehicle vehicle) {
		
		try {
			String query = "insert into vehicle_table(vehicle_number,vehicle_name,vehicle_type,vehicle_mileage) values(?,?,?,?)";
			
			PreparedStatement ps = null;
			System.out.println("dept name::"+vehicle.getVehicleNumber());
			
			ps = connection.prepareStatement(query);
			
			ps.setString(1, vehicle.getVehicleNumber());
			ps.setString(2, vehicle.getVehicleName());
			ps.setString(3, vehicle.getVehicleType());
			ps.setInt(4, vehicle.getVehicleMileage());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			//throw e;
			e.printStackTrace();
			return false;
		}
	}
}