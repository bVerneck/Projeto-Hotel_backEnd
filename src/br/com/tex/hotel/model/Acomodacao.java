package br.com.tex.hotel.model;

/**
 * 
 * @author renor
 *
 */
public class Acomodacao {
	private double id;
	private String nomeAcomodacao;
	private double valorAdulto;
	private double valorCrianca;
	private boolean quartoLivre;
	private double tamanhoQuarto;
	private String descricaoQuarto;
	public double getId() {
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
	
	// métodos
	
	public void Cadastrar() {
		
	}
	

}
