package com.tis.travels.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tis.travels.rest.beans.Customer;

public class CustomerHandler {

	public ArrayList<Customer> getCustomers(Connection connection) throws Exception {
		ArrayList<Customer> custTransList = new ArrayList<Customer>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer_details");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerID(rs.getInt("customer_id"));
				cust.setCustomerName(rs.getString("customer_name"));
				custTransList.add(cust);
			}
			return custTransList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	public boolean saveCustomer(Connection connection, Customer cust) {
		
		try {
			String query = "insert into customer_details(customer_name) values(?)";
			
			PreparedStatement ps = null;
			System.out.println("customer name::"+cust.getCustomerName());
			
			ps = connection.prepareStatement(query);
			
			ps.setString(1, cust.getCustomerName());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			//throw e;
			e.printStackTrace();
			return false;
		}
	}
}