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
import com.tis.travels.helpers.CustomerHandler;
import com.tis.travels.helpers.DbConnection;
import com.tis.travels.rest.beans.Customer;
import com.tis.travels.rest.beans.Status;

@Path("customers")
public class CustomerResource {
	
	private DbConnection database;
    private Connection connection;
    
    public CustomerResource()
    {
    		database = new DbConnection(); 	
    }
   
 	@GET
    @Path("getAllCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer[] getALlCustomers(){
 		
 		try {
			connection = database.getConnection();
			CustomerHandler custHandler= new CustomerHandler();
	        List<Customer> custList = custHandler.getCustomers(connection);
	        return custList.toArray(new Customer[custList.size()]);
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
	    public Status[] insert(Customer[] customers) {
	    	
	    	Status []status = new Status[customers.length];
	    	try {
				connection = database.getConnection();
				
				CustomerHandler custHandler= new CustomerHandler();
				int i=0;
				for (Customer cust : customers) {
					if(custHandler.saveCustomer(connection, cust)) {
						status[i] = new Status("SUCCESS", "Inserted " + cust.getCustomerName());
					}
					else {
						status[i] = new Status("Failure", "Not able to insert " + cust.getCustomerName());
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
