package com.kum.ws;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.LocationDAO;
import com.kum.model.Device;
import com.kum.model.Location;

@Path("/location/{location: [0-9]* }/device/")
public class LocationDeviceResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<Device> getAllDevicesForLocation(
			@PathParam("location") long location) throws SQLException {
		LocationDAO daoLocation = new LocationDAO();
		Location currentLocation = new Location();
		currentLocation.setId(location);
		Location curLoc = daoLocation.findByID(currentLocation);
		Collection<Device> devices = curLoc.getDevices();

		return devices;

	}
}
