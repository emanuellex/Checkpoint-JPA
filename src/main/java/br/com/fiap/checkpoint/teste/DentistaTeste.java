package br.com.fiap.checkpoint.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import br.com.fiap.checkpoint.singleton.EntityManagerFactorySingleton;
import br.com.fiap.checkpoint.dao.DentistaDao;
import br.com.fiap.checkpoint.entity.Dentista;
import br.com.fiap.checkpoint.entity.Sala;
import br.com.fiap.checkpoint.exception.CommitException;
import br.com.fiap.checkpoint.exception.ItensNotFoundException;
import br.com.fiap.checkpoint.impl.DentistaImpl;

public class DentistaTeste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();

		DentistaDao dao = new DentistaImpl(em);

		Dentista dentista = new Dentista("Fernando", LocalDate.of(1989, 9, 14), new BigDecimal("7500.0"));

		try {

			dao.insert(dentista);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());

		}

		try {

			Dentista busca = dao.find(1);
			System.out.println(busca.getNome());
		} catch (ItensNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {

			dentista.setNome("Kleber");
			dao.update(dentista);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {

			dao.remove(1);
			dao.commit();
			System.out.println("Dentista removido");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		em.close();
		fabrica.close();

	}

}
