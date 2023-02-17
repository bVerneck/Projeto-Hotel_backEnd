package br.com.tex.hotel.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hospede extends Pessoa{

	private boolean reservado = false;
    private List<String> adicionais = new ArrayList<>();
    private List<Date> buscarData = new ArrayList<>();
    private List<String> acomodacoes = new ArrayList<>();
    
//reservas
    public void reservar() {
        if (!reservado) {
            reservado = true;
            System.out.println("Reserva realizada com sucesso.");
        } else {
            System.out.println("Este hospede já possui uma reserva.");
        }
    }
// fim
    
    
//adicionais
    public void adicionarAdicional(String adicional) {
        adicionais.add(adicional);
        System.out.println("Adicional " + adicional + " adicionado com sucesso.");
    }
//fim
    
//cancelar reserva
    public void cancelarReserva() {
        if (reservado) {
            reservado = false;
            adicionais.clear();
            buscarData.clear();
            acomodacoes.clear();
            System.out.println("Reserva cancelada com sucesso.");
        } else {
            System.out.println("Este hospede não possui uma reserva.");
        }
    }
//fim
    
//buscar data
    public List<Date> buscarPorData(Date data) {
        List<Date> datasEncontrados = new ArrayList<Date>();
        
        for (Date buscarData : buscarData) {
            if (buscarData.equals(data)) {
                datasEncontrados.add(buscarData);
            }
        }
        
        return datasEncontrados;
    }
//fim
   
    
    public List<String> buscarAcomodacoes() {
        return acomodacoes;
    }
}






