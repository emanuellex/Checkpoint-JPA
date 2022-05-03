package br.com.fiap.checkpoint.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.checkpoint.dao.ConsultorioDao;
import br.com.fiap.checkpoint.entity.Consultorio;
import br.com.fiap.checkpoint.entity.Sala;
import br.com.fiap.checkpoint.exception.CommitException;
import br.com.fiap.checkpoint.exception.ItensNotFoundException;
import br.com.fiap.checkpoint.impl.ConsultorioImpl;
import br.com.fiap.checkpoint.singleton.EntityManagerFactorySingleton;

public class ConsultorioTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();

		ConsultorioDao dao = new ConsultorioImpl(em);

		Consultorio consultorio = new Consultorio("Consultorio XYZ", 3);

		try {

			dao.insert(consultorio);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());

		}

		try {

			Consultorio busca = dao.find(1);
			System.out.println(busca.getNome());
		} catch (ItensNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {

			consultorio.setNome("Consultorio Novo Nome");
			dao.update(consultorio);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {

			dao.remove(1);
			dao.commit();
			System.out.println("Removido");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		em.close();
		fabrica.close();
	}

}
