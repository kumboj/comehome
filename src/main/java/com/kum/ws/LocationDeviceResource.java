package com.kum.ws;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.LocationDAO;
import com.kum.daos.LocationDeviceDAO;
import com.kum.model.Device;
import com.kum.model.Location;

@Path("/location/{location: [0-9]* }/device/")
public class LocationDeviceResource {
	@PathParam("location") long location;
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<Device> getAllDevicesForLocation() throws SQLException {
		LocationDAO daoLocation = new LocationDAO();
		Location currentLocation = new Location();
		currentLocation.setId(location);
		Location curLoc = daoLocation.findByID(currentLocation);
		Collection<Device> devices = curLoc.getDevices();

		return devices;

	}
	
	@Path("new/{name: .* }")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Device setDevice(@PathParam("name") String name) throws SQLException{

		LocationDeviceDAO daoLocationDevice = new LocationDeviceDAO();
		Device newDevice = new Device();
		newDevice.setName(name);
		
		LocationDAO daoLocation = new LocationDAO();
		Location currentLocation = new Location();
		currentLocation.setId(location);
		Location curLoc = daoLocation.findByID(currentLocation);
		curLoc.getDevices().add(newDevice);
		newDevice.setLocation(currentLocation);
		daoLocationDevice.create(curLoc, newDevice);
		
//		DeviceDAO daoDevice = new DeviceDAO();
//		Device newDevice = new Device();
//		newDevice.setName(name);
//		daoDevice.create(newDevice);
//		
//		LocationDAO daoLocation = new LocationDAO();
//		Location currentLocation = new Location();
//		currentLocation.setId(location);
//		Location curLoc = daoLocation.findByID(currentLocation);
//		curLoc.getDevices().add(newDevice);
//
//		newDevice.setLocation(currentLocation);
		
		return newDevice;
	}
}
