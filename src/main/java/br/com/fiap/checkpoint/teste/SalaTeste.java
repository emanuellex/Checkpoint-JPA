package br.com.fiap.checkpoint.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.checkpoint.dao.SalaDao;
import br.com.fiap.checkpoint.entity.Cliente;
import br.com.fiap.checkpoint.entity.Sala;
import br.com.fiap.checkpoint.exception.CommitException;
import br.com.fiap.checkpoint.exception.ItensNotFoundException;
import br.com.fiap.checkpoint.impl.SalaImpl;
import br.com.fiap.checkpoint.singleton.EntityManagerFactorySingleton;

public class SalaTeste {
	public static void main(String[] args) {
		
	EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");
	
	EntityManager em = fabrica.createEntityManager();
	
	SalaDao dao = new SalaImpl(em);
	
	Sala sala = new Sala(22, 2, "Preta");
	
	try {
		
		dao.insert(sala);
		dao.commit();
	} catch (CommitException e) {
		System.out.println(e.getMessage());
	
	}
	try {
		
		Sala busca  = dao.find(1);
		System.out.println(busca.getNumero());
	}catch (ItensNotFoundException e) {
		System.out.println(e.getMessage());
	}
	try {
		
		sala.setNumero(23);
		dao.update(sala);
		dao.commit();
	} catch (CommitException e) {
		System.out.println(e.getMessage());
	}
	
	try {
		
		dao.remove(1);
		dao.commit();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	em.close();
	fabrica.close();
}
}
