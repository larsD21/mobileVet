package de.vet.dao;

import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
//Based on results in OOP3 & VS
public abstract class GenericDAO<T> {
	
	private final String UNIT_NAME = "MobileVetAppointment";
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
	EntityManager em = emf.createEntityManager();
	EntityTransaction tr = em.getTransaction();
	
	private Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public void save(T entity) {
		tr.begin();
		this.em.persist(entity);
		tr.commit();
	}
	
	public void update(T entity) {
		tr.begin();
		this.em.merge(entity);
		tr.commit();
	}

	protected boolean delete(long id, Class<T> classe) {
		T entityToBeRemoved = em.getReference(classe, id);
		try {
			tr.begin();
			em.remove(entityToBeRemoved);
			tr.commit();
			return true;
		} catch(Exception e) {
			System.out.println("ERROR: Deleting : "+ id );
			return false;
		}
	}

	protected T find(long id) {
		return em.find(entityClass, id);
	}

	protected List<T> findAll(){
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}
	
	protected Collection<T> findListResult(
		String namedQuery,
		Map<String, Object> parameters){
		List<T> result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query,parameters);
			}
			result = (List<T>) query.getResultList();
		} catch(Exception e) {
			System.out.println("ERROR: Query Error: " + e.getMessage());
		}
		return result;
	}
	
	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for ( Entry<String, Object> entry: parameters.entrySet()) {
			query.setParameter(entry.getKey(),entry.getValue());
		}
	}

}
