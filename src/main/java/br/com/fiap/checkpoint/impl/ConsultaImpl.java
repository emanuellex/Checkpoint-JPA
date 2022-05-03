package br.com.fiap.checkpoint.impl;

import javax.persistence.EntityManager;

import br.com.fiap.checkpoint.dao.ConsultaDao;
import br.com.fiap.checkpoint.entity.Consulta;


public class ConsultaImpl extends GenericImp<Consulta, 	Integer> implements ConsultaDao{

	public ConsultaImpl(EntityManager em) {
		super(em);
		
	}

}
