package br.com.fiap.checkpoint.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_DENTISTA")
@SequenceGenerator(name = "dentista", sequenceName = "SQ_TB_DENTISTA", allocationSize = 1)
public class Dentista {

	@Id
	@Column(name = "cd_dentista")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentista")
	private Integer codigo;

	@Column(name = "nm_dentista", nullable = false, length = 200)
	private String nome;

	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "vl_salario", nullable = false, precision = 10, scale = 2)
	private BigDecimal salario;

	public Dentista() {
		super();
	}

	public Dentista(String nome, LocalDate dataNascimento, BigDecimal salario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
