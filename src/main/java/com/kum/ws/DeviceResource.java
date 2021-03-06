package com.kum.ws;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.DeviceDAO;
import com.kum.model.Device;

@Path("/device")
public class DeviceResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<Device> getAllDevices() {
		DeviceDAO daoDevice = new DeviceDAO();
		Collection<Device> devices = daoDevice.findAllDevices();
		return devices;

	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("new/{name}")
	public Device setDevice(@PathParam("name") String name)
			throws SQLException {
		DeviceDAO daoDevice = new DeviceDAO();
		Device newDevice = new Device();
		newDevice.setName(name);
		daoDevice.create(newDevice);
		return newDevice;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("delete/{id}")
	public Device deleteDevice(@PathParam("id") Long id) throws SQLException {
		DeviceDAO daoDevice = new DeviceDAO();
		Device delDevice = new Device();
		delDevice.setId(id);
		daoDevice.removeDevice(delDevice);
		return delDevice;
	}

}
