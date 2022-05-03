package br.com.fiap.checkpoint.impl;

import br.com.fiap.checkpoint.entity.Sala;
import javax.persistence.EntityManager;
import br.com.fiap.checkpoint.dao.SalaDao;

public class SalaImpl extends GenericImp<Sala, Integer> implements SalaDao {

	public SalaImpl(EntityManager em) {
		super(em);
		
	}

}
