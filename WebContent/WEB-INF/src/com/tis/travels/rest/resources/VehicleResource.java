package com.tis.travels.rest.resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tis.travels.helpers.CORSResponseFilter;
import com.tis.travels.helpers.DbConnection;
import com.tis.travels.helpers.VehicleHandler;
import com.tis.travels.rest.beans.Status;
import com.tis.travels.rest.beans.Vehicle;

@Path("vehicles")
public class VehicleResource {
	
	private DbConnection database;
    private Connection connection;
    
    public VehicleResource()
    {
    		database = new DbConnection(); 	
    }
   
 	@GET
    @Path("getAllVehicles")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle[] getAllVehicles(){
 		
 		try {
			connection = database.getConnection();
			VehicleHandler vehicleHandler= new VehicleHandler();
	        List<Vehicle> vehicleList = vehicleHandler.getVehicles(connection);
	        return vehicleList.toArray(new Vehicle[vehicleList.size()]);
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
	    
 	@GET
    @Path("/searchByVehicleNumber/{vehicleNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Vehicle searchByVehicleNumber(@PathParam("vehicleNumber") String vehicleNumber){
 		
 		try {
			connection = database.getConnection();
			VehicleHandler vehicleHandler= new VehicleHandler();
	        Vehicle vehicle = vehicleHandler.getVehicleByID(connection, vehicleNumber);
	        return vehicle;
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
	    public Status[] insert(Vehicle[] vehicles) {
	    	
	    	Status []status = new Status[vehicles.length];
	    	try {
				connection = database.getConnection();
				
				VehicleHandler vehicleHandler= new VehicleHandler();
				int i=0;
				for (Vehicle vehicle : vehicles) {
					if(vehicleHandler.saveVehicle(connection, vehicle)) {
						status[i] = new Status("SUCCESS", "Inserted " + vehicle.getVehicleNumber());
					}
					else {
						status[i] = new Status("Failure", "Not able to insert " + vehicle.getVehicleNumber());
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
