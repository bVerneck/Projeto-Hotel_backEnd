package br.com.tex.hotel.model;

public class Contato {
	private String telefonePrincipal;
	private String telefoneAuxiliar;
	private String email;
	private Integer id;
	
	private static int contador;
	
	public void contato(){ 
		this.id = ++contador;
	}
	
	public Integer getId() {
		return id;
		
	}
	
	public String getTelefonePrincipal(){
		return telefonePrincipal;
			
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal =telefonePrincipal;
	}
	
	
	
	public String getTelefoneAuxiliar() {
		return telefoneAuxiliar;
	}
	
	public void setTelefoneAuxiliar(String telefoneAuxiliar) {
		this.telefoneAuxiliar= telefoneAuxiliar;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}













}

