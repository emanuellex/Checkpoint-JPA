package br.com.fiap.checkpoint.impl;

import javax.persistence.EntityManager;
import br.com.fiap.checkpoint.entity.Consultorio;
import br.com.fiap.checkpoint.dao.ConsultorioDao;

public class ConsultorioImpl extends GenericImp<Consultorio, Integer> implements ConsultorioDao {

	public ConsultorioImpl(EntityManager em) {
		super(em);
		
	}
	
}
