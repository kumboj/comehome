package com.kum.daos;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kum.model.Device;
import com.kum.model.Function;

public class DeviceFunctionDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";

	public Device create(Device device, Function function) throws SQLException {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		
		em.persist(function);

		device.getFunctions().add(function);
		em.merge(device);

		function.setDevice(device);
		em.persist(function);
		
		em.getTransaction().commit();

		em.close();
		emf.close();

		return device;
	}

}
