package br.com.fiap.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.fiap.checkpoint.exception.CommitException;
import br.com.fiap.checkpoint.exception.ItensNotFoundException;

import java.lang.reflect.ParameterizedType;

import  br.com.fiap.checkpoint.dao.GenericDao;



public class GenericImp<T, K> {
	

	private EntityManager em;
	
	private Class<T> clazz; 
	
	@SuppressWarnings("all")
	public GenericImp(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) 
				((ParameterizedType) getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
	}
	
	public void insert(T entity) {
		em.persist(entity);
	}

	public T find(K id) throws ItensNotFoundException {
		T entity = em.find(clazz, id);
		if (entity == null)
			throw new ItensNotFoundException();
		return entity;
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void remove(K id) throws ItensNotFoundException {
		em.remove(find(id));
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

	
}
