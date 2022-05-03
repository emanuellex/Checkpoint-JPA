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
@Table(name = "TB_CONSULTA")
@SequenceGenerator(name = "consulta", sequenceName = "SQ_TB_CONSULTA", allocationSize = 1)
public class Consulta {

	@Id
	@Column(name = "cd_consulta")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consulta")
	private Integer codigo;

	@Column(name = "dt_consulta", nullable = false)
	private LocalDate data;

	@Column(name = "vl_consulta", nullable = false)
	private BigDecimal valor;

	public Consulta() {
		super();
	}

	public Consulta(LocalDate data, BigDecimal valor) {
		super();
		this.data = data;
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate consulta) {
		this.data = consulta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
