package com.kum.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.entities.Function;
import com.kum.entities.Location;

@Path("/location/{location: [0-9]* }/device/{device: [0-9]* }/function")
public class FunctionResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Location> get(@PathParam("location") Long location){
		Location test = new Location();
		test.setId(1l);
		test.setName("default");
		System.out.println(location);
		ArrayList<Location> list = new ArrayList<Location>();
		list.add(test);
		return list;
	}
	
	@Path("{function: [0-9]* }")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Function getFunction(@PathParam("function") Long function){
		Location test = new Location();
		test.setId(1l);
		test.setName("default");
		System.out.println(function);
		ArrayList<Location> list = new ArrayList<Location>();
		list.add(test);
		return new Function();
	}
}
