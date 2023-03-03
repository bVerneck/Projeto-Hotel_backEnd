package br.com.tex.hotel.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 
 * @author André
 *
 */
public class Servico {

	private Integer id;
	private String servico;
	private BigDecimal preco;

	public Servico() {
	}

	public Servico(String servico, BigDecimal preco) {
		this.servico = servico;
		this.preco = preco;
	}

	public Servico(Integer id, String servico, BigDecimal preco) {
		this.id = id;
		this.servico = servico;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public String getServico() {
		return servico;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", servico=" + servico + ", preco=" + preco + "]";
	}

}
