package br.com.fiap.checkpoint.impl;

import javax.persistence.EntityManager;
import br.com.fiap.checkpoint.entity.Cliente;

import br.com.fiap.checkpoint.dao.ClienteDao;

public class ClienteImpl extends GenericImp<Cliente, Integer> implements ClienteDao {
	
	public ClienteImpl(EntityManager em) {
		super(em);
	}

}
