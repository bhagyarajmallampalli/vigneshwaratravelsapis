package com.tis.travels.rest.resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tis.travels.helpers.CORSResponseFilter;
import com.tis.travels.helpers.DbConnection;
import com.tis.travels.helpers.DeptHandler;
import com.tis.travels.rest.beans.Dept;
import com.tis.travels.rest.beans.Status;

@Path("depts")
public class DeptResource {
	
	private DbConnection database;
    private Connection connection;
    
    public DeptResource()
    {
    		database = new DbConnection(); 	
    }
   
 	@GET
    @Path("getAllDepts")
    @Produces(MediaType.APPLICATION_JSON)
    public Dept[] getALlDepts(){
 		
 		try {
			connection = database.getConnection();
			DeptHandler deptHandler= new DeptHandler();
	        List<Dept> deptList = deptHandler.getDepts(connection);
	        return deptList.toArray(new Dept[deptList.size()]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
 		finally {
 			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		} 
    }
	    
	    @POST
	    @Path("insert")
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Status[] insert(Dept[] depts) {
	    	
	    	Status []status = new Status[depts.length];
	    	try {
				connection = database.getConnection();
				
				DeptHandler deptHandler= new DeptHandler();
				int i=0;
				for (Dept dept : depts) {
					if(deptHandler.saveDepts(connection, dept)) {
						status[i] = new Status("SUCCESS", "Inserted " + dept.getDeptName());
					}
					else {
						status[i] = new Status("Failure", "Not able to insert " + dept.getDeptName());
					}
					i++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				status[0] = new Status("Error", "SQL Exception; please try again after sometime");
			} 
	    	return status;
	    }

}
