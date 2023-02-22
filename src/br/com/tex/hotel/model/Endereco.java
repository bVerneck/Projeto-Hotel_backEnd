package br.com.tex.hotel.model;

import java.util.Objects;

import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;

public class Endereco {

	private Integer id;
	private TipoLogradouro tipoLogradouro;
	private String logradouro;
	private Integer numeroResidencial;
	private String complemento;
	private String cep;
	private String bairro;
	private String cidade;
	private Estado estado;
	private String pais;

	private static int contador;

	public Endereco() {
		this.id = ++contador;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumeroResidencial() {
		return numeroResidencial;
	}

	public void setNumeroResidencial(Integer numeroResidencial) {
		this.numeroResidencial = numeroResidencial;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Endereco { \nid=" + id + ",\n tipoLogradouro=" + tipoLogradouro.getDescricao() + ", logradouro="
				+ logradouro + ", numeroResidencial=" + numeroResidencial + ", complemento=" + complemento + ",\n cep="
				+ cep + ",\n bairro=" + bairro + ",\n cidade=" + cidade + ",\n estado=" + estado.getNome() + ",\n pais="
				+ pais + "\n}";
	}

}
