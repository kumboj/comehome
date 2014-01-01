package com.kum.ws;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.CalledFunctionDAO;
import com.kum.model.CalledFunction;
@Path("/calledFunction")
public class CalledFunctionResource {

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<CalledFunction> get(){
		CalledFunctionDAO daoCalledFunction = new CalledFunctionDAO();
		Collection<CalledFunction> calledFunctions = daoCalledFunction.findAllCalledFunctions();
		return calledFunctions;

	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{name}")
	public CalledFunction callAFunction(@PathParam("name") String name) throws SQLException {
		CalledFunctionDAO daoCalledFunction = new CalledFunctionDAO();
		CalledFunction newCalledFunction = new CalledFunction();
		newCalledFunction.setName(name);
		daoCalledFunction.create(newCalledFunction);
		return newCalledFunction;
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("finish/{id}")
	public CalledFunction finishFunction(@PathParam("id") Long id) throws SQLException {
		CalledFunctionDAO daoCalledFunction = new CalledFunctionDAO();
		CalledFunction finCalledFunction = new CalledFunction();
		finCalledFunction.setId(id);
		daoCalledFunction.removeCalledFunction(finCalledFunction);
		return finCalledFunction;
	}
	
}
