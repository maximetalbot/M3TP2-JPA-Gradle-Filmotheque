package fr.eni.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class DAOImpl<T> implements IDAO<T> {

	@Override
	public void add(T t) throws Exception {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(t);
			et.commit();
		}catch (Exception e) {
			et.rollback();
			throw e;
		}
	}

	@Override
	public void delete(T t) throws Exception {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(t);
			et.commit();
		}catch (Exception e) {
			et.rollback();
			throw e;
		}
	}

	@Override
	public void update(T t) throws Exception {
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(t);
			et.commit();
		}catch (Exception e) {
			et.rollback();
			throw e;
		}
	}

}
