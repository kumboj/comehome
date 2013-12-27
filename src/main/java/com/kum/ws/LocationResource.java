package com.kum.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.entities.Device;
import com.kum.entities.Location;

@Path("/location")
public class LocationResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Location> get(){
		Location test = new Location();
		test.setId(1l);
		test.setLatitude(1.0);
		test.setLongitude(1.0);
		test.setName("default");
		List<Device> deviceList = test.getDevices();
		
		Device device1 = new Device();
		device1.setId(2l);
		device1.setName("Garage");
		deviceList.add(device1);
		
		Device device2 = new Device();
		device2.setId(5l);
		device2.setName("Radio");
		deviceList.add(device2);
		
		ArrayList<Location> list = new ArrayList<Location>();
		list.add(test);
		return list;
	}
	
}
