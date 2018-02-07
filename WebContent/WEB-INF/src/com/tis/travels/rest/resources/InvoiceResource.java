package com.tis.travels.rest.resources;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tis.travels.helpers.DbConnection;
import com.tis.travels.helpers.InvoiceHandler;
import com.tis.travels.rest.beans.InvoiceData;

@Path("invoices")
public class InvoiceResource {
	
	private DbConnection database;
    private Connection connection;
    
	public InvoiceResource()
	{
	    		database = new DbConnection(); 	
	}
	@GET
    @Path("/getInvoiceByDate/{transDate}/{vehicleNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public InvoiceData getInvoiceByDate(@PathParam("transDate") String transDate, @PathParam("vehicleNumber") String vehicleNumber){
 		InvoiceData invoiceData = null;
 		try {
 			
			connection = database.getConnection();
			InvoiceHandler invoiceHandler = new InvoiceHandler();
			
			invoiceData = invoiceHandler.getCarTransByDate(connection, transDate, vehicleNumber);
	        return invoiceData;
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
}
