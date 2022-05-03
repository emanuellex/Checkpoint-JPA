package br.com.fiap.checkpoint.teste;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.checkpoint.dao.ClienteDao;
import br.com.fiap.checkpoint.entity.Cliente;
import br.com.fiap.checkpoint.entity.Tratamento;
import br.com.fiap.checkpoint.exception.CommitException;
import br.com.fiap.checkpoint.exception.ItensNotFoundException;
import br.com.fiap.checkpoint.impl.ClienteImpl;
import br.com.fiap.checkpoint.singleton.EntityManagerFactorySingleton;

public class ClienteTeste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();

		ClienteDao dao = new ClienteImpl(em);

		Cliente cliente = new Cliente(Tratamento.BRUXISMO, "Emanuelle", LocalDate.of(1999, 3, 07), 1198148899);

		try {

			dao.insert(cliente);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {

			Cliente busca = dao.find(1);
			System.out.println(busca.getNome());
		} catch (ItensNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {

			cliente.setNome("Giovanna");
			dao.update(cliente);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {

			dao.remove(1);
			dao.commit();
			System.out.println("Cliente removido");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		em.close();
		fabrica.close();
	}
}
