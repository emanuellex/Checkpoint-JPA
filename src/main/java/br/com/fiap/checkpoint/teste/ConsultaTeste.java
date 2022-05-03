package br.com.fiap.checkpoint.teste;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.checkpoint.dao.ConsultaDao;
import br.com.fiap.checkpoint.entity.Cliente;
import br.com.fiap.checkpoint.entity.Consulta;
import br.com.fiap.checkpoint.exception.CommitException;
import br.com.fiap.checkpoint.exception.ItensNotFoundException;
import br.com.fiap.checkpoint.impl.ConsultaImpl;
import br.com.fiap.checkpoint.singleton.EntityManagerFactorySingleton;

public class ConsultaTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance("CLIENTE_ORACLE");

		EntityManager em = fabrica.createEntityManager();
		ConsultaDao dao = new ConsultaImpl(em);
		Consulta consulta = new Consulta(LocalDate.of(2022, 5, 25), new BigDecimal(890));

		try {

			dao.insert(consulta);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		try {

			Consulta busca = dao.find(1);
			System.out.println(busca.getData());
		} catch (ItensNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {

			consulta.setData(LocalDate.of(2022, 8, 28));
			dao.update(consulta);
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
