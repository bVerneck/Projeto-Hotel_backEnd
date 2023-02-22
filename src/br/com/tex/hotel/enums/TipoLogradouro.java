package br.com.tex.hotel.enums;

public enum TipoLogradouro {
	RUA("Rua"),
	AVENIDA("Avenida"),
	PRACA("Praça");

	private String descricao;

	private TipoLogradouro(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TipoLogradouro{");
		sb.append("descricao='").append(descricao).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
