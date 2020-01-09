package com.aca.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.aca.rest.model.EmailMessage;
import com.aca.rest.model.Message;
import com.aca.rest.model.Station;
import com.aca.rest.model.TextSns;
import com.aca.rest.services.Where2FuelService;

@Path("/v1/station")
public class Where2FuelController {

	private Where2FuelService service = new Where2FuelService();
	
	
	@GET
	@Path("/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getStationByValue(@PathParam("value") String value) {
		return service.getStationByValue(value);
	}
	
	@POST	
	@Path("/email")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sendEmail(EmailMessage email) {		
		Where2FuelService service = new Where2FuelService();
		String result = service.sendEmail(email);
		
		Message message = new Message();
		message.setMessage(result);
		
		return Response.status(200).entity(message).build();				
	}
	
	@POST	
	@Path("/text")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response sendCustomerText(TextSns textSns) {
		
		Where2FuelService service = new Where2FuelService();
		String result = service.sendText(textSns);	
		
		Message message = new Message();
		message.setMessage(result);
			
		return Response.status(200).entity(message).build();				
	}
	
	@GET
	@Path("/subscribe/{email}/{address}")
	@Produces({MediaType.APPLICATION_JSON})
	public void getEmailForSubscription(@PathParam("email") String email, @PathParam("address") String address) {
		service.emailSubscribe(email, address);
	}
	
	@GET
	@Path("/text/{phone}")
	@Produces({MediaType.APPLICATION_JSON})
	public void getphoneForSubscription(@PathParam("phone") String phone) {
		service.textSubscribe(phone);
	}
	
	@GET
	@Path("/address/{address}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Station> getStationByAddress(@PathParam("address") String address) {
		return service.getStationByAddress(address);
	}
	

}
