package com.kum.daos;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kum.model.Device;
import com.kum.model.Location;

public class LocationDeviceDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";

	public Device create(Location location, Device device) throws SQLException {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(device);

		location.getDevices().add(device);
		em.merge(location);

		device.setLocation(location);
		em.persist(device);
		
		em.getTransaction().commit();

		em.close();
		emf.close();

		
		
//		Device musikAnlage = new Device();
//		musikAnlage.setName("Musikanlage");
//		objEntityManager.persist(musikAnlage);
//
//		Location wohnort = new Location();
//		wohnort.setDescription("Neuburg an der Donau");
//		wohnort.getDevices().add(musikAnlage);
//		objEntityManager.persist(wohnort);
//
//		musikAnlage.setLocation(wohnort);
//		objEntityManager.persist(musikAnlage);
//
//		// Commit the transaction, which will cause the entity to be stored in
//		// the database
//		objEntityManager.getTransaction().commit();
//
//		objEntityManager.close();
//		objEntityManagerFactory.close();
		
		
		
		return device;
	}

}
