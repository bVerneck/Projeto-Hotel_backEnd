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

	private static int count;

	public Servico() {
		this.id = ++count;
	}

	public Servico(String servico, BigDecimal preco) {
		this.id = ++count;
		this.servico = servico;
		this.preco = preco;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
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
		final StringBuilder sb = new StringBuilder();
		sb.append("Servico {").append("id=").append(id).append(", servico='").append(servico).append("', preco=")
				.append(preco).append("}");
		return sb.toString();
	}

}
