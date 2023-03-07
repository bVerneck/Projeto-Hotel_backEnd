package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Reserva;

public class ReservaDAO {

//	public void inserir(Reserva r) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//
//		String sql = "INSERT INTO reserva (dataCheckin, dataCheckout, quantidadeAdulto,"
//				+ " quantidadeCrianca, acomodacao_id_acomodacao)"
//				+ " VALUES(?, ?, ?, ?, ?)";
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		statement.setDate(1, Date.valueOf(r.getDataCheckIn()));
//		statement.setDate(2, Date.valueOf(r.getDataCheckOut()));
//		statement.setInt(3, r.getQuantHospedeAdulto());
//		statement.setInt(4, r.getQuantHospedeAteOitoAnos());
//		statement.setInt(5, r.getQuarto().getId());
//
//		statement.execute();
//
//		statement.close();
//		conexao.close();
//	}
//
//	public void alterar(Reserva r) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "UPDATE reserva SET dataCheckin=?, dataCheckout=?, quantidadeAdulto=?,"
//				+ " quantidadeCrianca=?, acomodacao_id_acomodacao=?"
//				+ " WHERE id_reserva=?";
//
//		PreparedStatement statement = conexao.prepareStatement(sql);
//		
//		statement.setDate(1, Date.valueOf(r.getDataCheckIn()));
//		statement.setDate(2, Date.valueOf(r.getDataCheckOut()));
//		statement.setInt(3, r.getQuantHospedeAdulto());
//		statement.setInt(4, r.getQuantHospedeAteOitoAnos());
//		statement.setInt(5, r.getQuarto().getId());
//		statement.setInt(6, r.getId());
//
//		statement.execute();
//
//		statement.close();
//		conexao.close();
//	}
//
//	public void delete(Reserva r) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "DELETE FROM reserva WHERE id_reserva=?";
//
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		statement.setInt(1, r.getId());
//		statement.execute();
//
//		statement.close();
//		conexao.close();
//	}
//
//	public Reserva getById(Integer id) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "SELECT * from reserva WHERE id_reserva=?";
//		PreparedStatement statement = conexao.prepareStatement(sql);
//		statement.setInt(1, id);
//
//		ResultSet rs = statement.executeQuery();
//
//		Reserva r = null;
//
//		while (rs.next()) {
//			r = new Reserva(rs.getInt("id_reserva"),
//					rs.getDate("dataCheckin").toLocalDate(),
//					rs.getDate("dataCheckout").toLocalDate(),
//					rs.getInt("quantidadeAdulto"),
//					rs.getInt("quantidadeCrianca"),
//					new AcomodacaoDAO().getById(rs.getInt("acomodacao_id_acomodacao")));
//		}
//		
//		if(r != null) {
//			//Adicionar a lista de serviços
//		}
//
//		return r;
//	}
//
//	public List<Reserva> listAllReservas() throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "SELECT * from contato";
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		ResultSet rs = statement.executeQuery();
//
//		List<Contato> contatos = new ArrayList<>();
//
//		while (rs.next()) {
//			Reserva r = new Contato(rs.getString("telefonePrincipal"),
//					rs.getString("telefoneAuxiliar"),
//					rs.getString("email"),
//					rs.getInt("id_contato"));
//
//			contatos.add(contato);
//		}
//
//		return contatos;
//	}
}
