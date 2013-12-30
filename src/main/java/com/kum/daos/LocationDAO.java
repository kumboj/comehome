package com.kum.daos;

import java.sql.SQLException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

import com.kum.model.Location;

public class LocationDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";


	public Location create(Location obj) throws SQLException {
		
		EntityManagerFactory emf =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = emf.createEntityManager();
    	
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return obj;
	}

	public Location findByID(Location obj) throws SQLException {
		if ((Integer)obj.getId() == null) {
			throw new SQLException("No ID!");
		}
		EntityManagerFactory emf =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = emf.createEntityManager();
		
		obj = em.find(Location.class, obj.getId());
		
		em.close();
		emf.close();
		
		return obj;
	}
	

	public Set<EntityType<?>> findAllNew() {
		EntityManagerFactory emf =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = emf.createEntityManager();
		
    	Set<EntityType<?>> ll = em.getMetamodel().getEntities();
    	
		em.close();
		emf.close();
		
		return ll;
	}

}
