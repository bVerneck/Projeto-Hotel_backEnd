package br.com.tex.hotel.model;

public class Contato {
	private int telefonePrincipal;
	private int telefoneAuxiliar;
	private String email;
	static int id=1;
	
	public void gerarId(){ 
		id++;
	}
	
	
	
	
	public int getTelefonePrincipal(){
		return telefonePrincipal;
			
	}

	public void setTelefonePrincipal(int telefonePrincipal) {
		this.telefonePrincipal =telefonePrincipal;
	}
	
	
	
	public int getTelefoneAuxiliar() {
		return telefoneAuxiliar;
	}
	
	public void setTelefoneAuxiliar(int telefoneAuxiliar) {
		this.telefoneAuxiliar= telefoneAuxiliar;
	}
	
	
	
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}













}

