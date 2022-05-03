package br.com.fiap.checkpoint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SALA")
@SequenceGenerator(name = "sala", sequenceName = "SQ_TB_SALA", allocationSize = 1)
public class Sala {

	@Id
	@Column(name = "cd_sala")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala")
	private Integer codigo;

	@Column(name = "nr_sala", nullable = false)
	private Integer numero;
	
	@Column(name = "andar_sala", nullable = false)
	private Integer andar;
	
	@Column(name = "cor_sala", nullable = false, length = 200)
	private String cor;

	public Sala() {
		super();
	}

	public Sala(Integer numero, Integer andar, String cor) {
		super();
		this.numero = numero;
		this.andar = andar;
		this.cor = cor;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
