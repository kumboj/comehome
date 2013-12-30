package com.kum.daos;

import java.sql.SQLException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

import com.kum.model.Device;


public class DeviceDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";


	public Device create(Device obj) throws SQLException {
		EntityManagerFactory emf =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = emf.createEntityManager();
    	
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return obj;
	}

	public Device findByID(Device obj) throws SQLException {
		if ((Integer)obj.getId() == null) {
			throw new SQLException("No ID!");
		}
		
		EntityManagerFactory emf =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = emf.createEntityManager();
		
		obj = em.find(Device.class, obj.getId());
		
		em.close();
		emf.close();
		
		return obj;
	}
	

	public Set<EntityType<?>> findAllNew() {
		EntityManagerFactory emf =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = emf.createEntityManager();
		
    	Set<EntityType<?>> dl = em.getMetamodel().getEntities();
    	
		em.close();
		emf.close();
		
		return dl;
	}

}
