package br.com.fiap.checkpoint.impl;

import br.com.fiap.checkpoint.entity.Dentista;
import javax.persistence.EntityManager;
import br.com.fiap.checkpoint.dao.DentistaDao;

public class DentistaImpl extends GenericImp<Dentista, 	Integer> implements DentistaDao{

	public DentistaImpl(EntityManager em) {
		super(em);
		
	}

}
