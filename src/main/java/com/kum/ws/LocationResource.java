package com.kum.ws;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.DeviceDAO;
import com.kum.daos.LocationDAO;
import com.kum.model.Device;
import com.kum.model.Location;

@Path("/location")
public class LocationResource {
//
//	@GET
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Path("{id}")
//	public Location getLocation(@PathParam("id") Long id) {
//		Data.calledFunction.add(null);
//		return Data.locationMap.get(id);
//	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Location> get() throws SQLException{
		
		LocationDAO daoLocation = new LocationDAO();
		DeviceDAO daoDevice = new DeviceDAO();
//        ArrayList<Location> locations = new ArrayList<Location>();
//        
//        Location test = new Location();
//		test.setLatitude(1.0);
//		test.setLongitude(1.0);
//		test.setName("default");
//		daoLocation.create(test);
//
//		
//		Device device1 = new Device();
//		device1.setName("Garage");
//		daoDevice.create(device1);
//		
//		Device device2 = new Device();
//		device2.setName("Radio");
//		daoDevice.create(device2);
//		
////		test.getDevices().add(device1);
////		test.getDevices().add(device2);
//
////		daoDevice.create(device2);
//		
//		
//		return locations;
		
		
		
		Location test = new Location();
		test.setId(1);
//		test.setLatitude(1.0);
//		test.setLongitude(1.0);
		test.setDescription("default");
		List<Device> deviceList = test.getDevices();
		
		Device device1 = new Device();
		device1.setId(2);
		device1.setName("Garage");
		deviceList.add(device1);
		
		Device device2 = new Device();
		device2.setId(5);
		device2.setName("Radio");
		deviceList.add(device2);
		
		ArrayList<Location> list = new ArrayList<Location>();
		list.add(test);
		return list;
	}
	
}
