package com.tis.travels.helpers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.tis.travels.rest.beans.Dept;

public class DeptHandler {

	public ArrayList<Dept> getDepts(Connection connection) throws Exception {
		ArrayList<Dept> deptList = new ArrayList<Dept>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM dept_table");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptID(rs.getInt("dept_id"));
				dept.setDeptName(rs.getString("dept_name"));
				deptList.add(dept);
			}
			return deptList;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	public boolean saveDepts(Connection connection, Dept dept) {
		
		try {
			String query = "insert into dept_table(dept_name) values(?)";
			
			PreparedStatement ps = null;
			System.out.println("dept name::"+dept.getDeptName());
			
			ps = connection.prepareStatement(query);
			
			ps.setString(1, dept.getDeptName());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			//throw e;
			e.printStackTrace();
			return false;
		}
	}
}