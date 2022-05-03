package br.com.fiap.checkpoint.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Integer codigo;

	@Column(name = "nm_cliente", nullable = false, length = 200)
	private String nome;

	@Column(name = "ds_tratamento", nullable = false)
	private Tratamento tratamento;

	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dataNascimento;

	@Column(name = "ds_telefone", nullable = false, length = 11)
	private Integer telefone;

	public Cliente() {
		super();
	}

	public Cliente(Tratamento tratamento, String nome, LocalDate dataNascimento, Integer telefone) {
		super();
		this.tratamento = tratamento;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
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

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Tratamento getTraramento() {
		return tratamento;
	}

	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}

}
