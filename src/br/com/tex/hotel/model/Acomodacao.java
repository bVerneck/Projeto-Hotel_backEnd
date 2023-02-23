package br.com.tex.hotel.model;

import java.util.Objects;

/**
 * 
 * @author renor
 *
 */
public class Acomodacao {
	private Integer id;
	private String nomeAcomodacao;
	private double valorAdulto;
	private double valorCrianca;
	private boolean quartoLivre;
	private double tamanhoQuarto;
	private String descricaoQuarto;
	
	
	private static int contador;
	
	public Acomodacao() {
		this.id = ++contador;
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getNomeAcomodacao() {
		return nomeAcomodacao;
	}
	public void setNomeAcomodacao(String nomeAcomodacao) {
		this.nomeAcomodacao = nomeAcomodacao;
	}
	public double getValorAdulto() {
		return valorAdulto;
	}
	public void setValorAdulto(double valorAdulto) {
		this.valorAdulto = valorAdulto;
	}
	public double getValorCrianca() {
		return valorCrianca;
	}
	public void setValorCrianca(double valorCrianca) {
		this.valorCrianca = valorCrianca;
	}
	public boolean isQuartoLivre() {
		return quartoLivre;
	}
	public void setQuartoLivre(boolean quartoLivre) {
		this.quartoLivre = quartoLivre;
	}
	public double getTamanhoQuarto() {
		return tamanhoQuarto;
	}
	public void setTamanhoQuarto(double tamanhoQuarto) {
		this.tamanhoQuarto = tamanhoQuarto;
	}
	public String getDescricaoQuarto() {
		return descricaoQuarto;
	}
	public void setDescricaoQuarto(String descricaoQuarto) {
		this.descricaoQuarto = descricaoQuarto;
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
		Acomodacao other = (Acomodacao) obj;
		return Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}

	@Override
	public String toString() {
		return "Acomodacao [id=" + id + ", nomeAcomodacao=" + nomeAcomodacao + ", valorAdulto=" + valorAdulto
				+ ", valorCrianca=" + valorCrianca + ", quartoLivre=" + quartoLivre + ", tamanhoQuarto=" + tamanhoQuarto
				+ ", descricaoQuarto=" + descricaoQuarto + "]";
	}
	
	

	


}
