package com.kum.daos;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;

import com.kum.model.CalledFunction;

public class CalledFunctionDAO {

	private static final String PERSISTENCE_UNIT_NAME = "JPAEclipseLinkDemoPU";

	public CalledFunction create(CalledFunction obj) throws SQLException {
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

	public CalledFunction findByID(CalledFunction obj) throws SQLException {
		if ((Long) obj.getId() == null) {
			throw new SQLException("No ID!");
		}

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		obj = em.find(CalledFunction.class, obj.getId());

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
	public Collection<CalledFunction> findAllCalledFunctions() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM CalledFunction e");
		Collection<CalledFunction> calledFunctions = (Collection<CalledFunction>) query.getResultList();
		em.close();
		emf.close();
		return calledFunctions;
	}

	public void removeCalledFunction(CalledFunction obj) throws SQLException {
		if ((Long) obj.getId() == null) {
			throw new SQLException("No ID!");
		}
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();

		// fetch entity
		em.getTransaction().begin();
		CalledFunction toDelete = em.find(CalledFunction.class, obj.getId());
		// remove entity
		em.remove(toDelete);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
