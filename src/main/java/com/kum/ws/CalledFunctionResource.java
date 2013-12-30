package com.kum.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.model.Location;
@Path("/CalledFunction")
public class CalledFunctionResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Location> get(@PathParam("location") Long location){
		Location test = new Location();
		test.setId(1);
		test.setDescription("default");
		System.out.println(location);
		ArrayList<Location> list = new ArrayList<Location>();
		list.add(test);
		return list;
	}
	
}
