package com.kum.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;

import com.kum.model.Function;

public class FunctionDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";

	public Function create(Function obj) throws SQLException {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();

		em.close();
		emf.close();

		return obj;
	}

	public Function findByID(Function obj) throws SQLException {
		if ((Long) obj.getId() == null) {
			throw new SQLException("No ID!");
		}

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		obj = em.find(Function.class, obj.getId());

		em.close();
		emf.close();

		return obj;
	}

	public Set<EntityType<?>> findAllNew() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		Set<EntityType<?>> dl = em.getMetamodel().getEntities();

		em.close();
		emf.close();

		return dl;
	}

	@SuppressWarnings("unchecked")
	public Collection<Function> findAllFunctions() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM Function e");
		Collection<Function> functions = (Collection<Function>) query.getResultList();
		em.close();
		emf.close();
		return functions;
	}

	public void removeFunction(Function obj) throws SQLException {
		if ((Long) obj.getId() == null) {
			throw new SQLException("No ID!");
		}
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		// fetch entity
		em.getTransaction().begin();
		Function toDelete = em.find(Function.class, obj.getId());
		// remove entity
		em.remove(toDelete);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
