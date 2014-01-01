package com.kum.ws;

import java.sql.SQLException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kum.daos.CalledFunctionDAO;
import com.kum.daos.FunctionDAO;
import com.kum.model.CalledFunction;
import com.kum.model.Function;

//@Path("/location/{location: [0-9]* }/device")

@Path("/function")
public class FunctionResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Collection<Function> getAllFunctions() {
		FunctionDAO daoFunction = new FunctionDAO();
		Collection<Function> functions = daoFunction.findAllFunctions();
		return functions;

	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("new/{name}")
	public Function setFunction(@PathParam("name") String name)
			throws SQLException {
		FunctionDAO daoFunction = new FunctionDAO();
		Function newFunction = new Function();
		newFunction.setName(name);
		daoFunction.create(newFunction);
		return newFunction;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("delete/{id}")
	public Function deleteFunction(@PathParam("id") Long id) throws SQLException {
		FunctionDAO daoFunction = new FunctionDAO();
		Function delFunction = new Function();
		delFunction.setId(id);
		daoFunction.removeFunction(delFunction);
		return delFunction;
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

//@Path("/location/{location: [0-9]* }/device/{device: [0-9]* }/function")
//public class FunctionResource {
//
//	@GET
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public List<Location> get(@PathParam("location") Long location){
//		Location test = new Location();
//		test.setId(1);
//		test.setDescription("defaultLocation");
//		System.out.println(location);
//		ArrayList<Location> list = new ArrayList<Location>();
//		list.add(test);
//		return list;
//	}
//	
//	@Path("/{function: [0-9]* }")
//	@GET
//	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Function getFunction(@PathParam("function") Long function){
//		Location test = new Location();
//		test.setId(1);
//		test.setDescription("defaultLocation");
//		System.out.println(function);
//		ArrayList<Location> list = new ArrayList<Location>();
//		list.add(test);
//		return new Function();
//	}
//}
