package com.tis.travels.rest.resources;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.tis.travels.helpers.CarsTransHandler;
import com.tis.travels.helpers.DbConnection;
import com.tis.travels.rest.beans.CarTrans;
import com.tis.travels.rest.beans.Status;

@Path("carstransactions")
public class TravelsTranscationResource {
	
	private DbConnection database;
    private Connection connection;
    
    public TravelsTranscationResource()
    {
    		database = new DbConnection(); 	
    }
   
 	@GET
    @Path("searchCarTransByDate")
    @Produces(MediaType.APPLICATION_JSON)
    public CarTrans[] searchByID(@PathParam("transDate") String transDate){
 		
 		try {
			connection = database.getConnection();
			CarsTransHandler transHandler= new CarsTransHandler();
	        List<CarTrans> carTrans = transHandler.getCarTransByDate(connection, transDate);
	        return carTrans.toArray(new CarTrans[carTrans.size()]);
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
    @Path("nextInvoiceNumber")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNextInvoiceNo(){
 		int nextNo = -1;
 		try {
			connection = database.getConnection();
			CarsTransHandler transHandler= new CarsTransHandler();
	       nextNo = transHandler.nextInvoiceNumber(connection);
	        return nextNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return nextNo;
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
	    public Status insert(CarTrans carsTrans, @Context final HttpServletResponse response) {
	    	
	    	Status status = new Status();
	    	try {
				connection = database.getConnection();
				
				CarsTransHandler carsTransHandler= new CarsTransHandler();
					if(carsTransHandler.saveCarTrans(connection, carsTrans)) {
						status = new Status("SUCCESS", "Inserted " + carsTrans.getDutySlipNo());
					}
					else {
						status  = new Status("Failure", "Not able to insert " + carsTrans.getDutySlipNo());
					}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				status = new Status("Error", "SQL Exception; please try again after sometime");
			} 
	    		
	    	return status;
	    
	    }
}
