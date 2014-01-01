package com.kum.ws;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.DeviceDAO;
import com.kum.daos.DeviceFunctionDAO;
import com.kum.model.Device;
import com.kum.model.Function;

@Path("/location/{location: [0-9]* }/device/{device: [0-9]* }/function/")
public class DeviceFunctionResource {
	@PathParam("device") long device;
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<Function> getAllFunctionsForDevice() throws SQLException {
		DeviceDAO daoDevice = new DeviceDAO();
		Device currentDevice = new Device();
		currentDevice.setId(device);
		Device curDev = daoDevice.findByID(currentDevice);
		Collection<Function> functions = curDev.getFunctions();

		return functions;

	}
	
	@Path("new/{name: .* }")
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Function setFunction(@PathParam("name") String name) throws SQLException{

		DeviceFunctionDAO daoDeviceFunction = new DeviceFunctionDAO();
		Function newFunction = new Function();
		newFunction.setName(name);
		
		DeviceDAO daoDevice = new DeviceDAO();
		Device currentDevice = new Device();
		currentDevice.setId(device);
		Device curDev = daoDevice.findByID(currentDevice);
		curDev.getFunctions().add(newFunction);
		newFunction.setDevice(currentDevice);
		daoDeviceFunction.create(curDev, newFunction);

		
		return newFunction;
	}
}
