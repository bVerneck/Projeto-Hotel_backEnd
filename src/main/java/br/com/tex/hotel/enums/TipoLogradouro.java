package br.com.tex.hotel.enums;

/**
 * 
 * @author willian
 *
 */
public enum TipoLogradouro {
	RUA("Rua"),
	AVENIDA("Avenida"),
	PRACA("Praça");

	private String descricao;

	private TipoLogradouro(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoLogradouro fromDescricao(String descricao) {
		
		for(final TipoLogradouro tipoLogradouro: TipoLogradouro.values()) {
			
			if(tipoLogradouro.getDescricao().equalsIgnoreCase(descricao))
				return tipoLogradouro;
		}
		throw new IllegalArgumentException(descricao);
					
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
