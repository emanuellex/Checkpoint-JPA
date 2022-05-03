package br.com.fiap.checkpoint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONSULTORIO")
@SequenceGenerator(name = "consultorio", sequenceName = "SQ_TB_CONSULTORIO", allocationSize = 1)
public class Consultorio {

	@Id
	@Column(name = "cd_consultorio")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consultorio")
	private Integer codigo;

	@Column(name = "nm_consultorio", nullable = false, length = 50)
	private String nome;

	@Column(name = "nr_unidade", nullable = false)
	private Integer unidade;

	public Consultorio() {
		super();
	}

	public Consultorio(String nome, Integer unidade) {
		super();
		this.nome = nome;
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

}
