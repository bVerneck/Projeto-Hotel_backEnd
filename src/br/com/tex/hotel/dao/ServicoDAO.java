package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Servico;

public class ServicoDAO {

//	public void inserir(Servico servico) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//
//		String sql = "INSERT INTO servico (descricao, preco, hotel_id_hotel, reserva_id_reserva)"
//				+ " VALUES(?, ?, ?, ?)";
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		statement.setString(1, contato.getTelefonePrincipal());
//		statement.setString(2, contato.getTelefoneAuxiliar());
//		statement.setString(3, contato.getEmail());
//
//		statement.execute();
//
//		statement.close();
//		conexao.close();
//	}
//
//	public void alterar(Servico servico) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "UPDATE contato SET telefonePrincipal=?, telefoneAuxiliar=?, email=? WHERE id_contato=?";
//
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		statement.setString(1, contato.getTelefonePrincipal());
//		statement.setString(2, contato.getTelefoneAuxiliar());
//		statement.setString(3, contato.getEmail());
//		statement.setInt(4, contato.getId());
//
//		statement.execute();
//
//		statement.close();
//		conexao.close();
//	}
//
//	public void delete(Servico servico) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "DELETE FROM contato WHERE id_contato=?";
//
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		statement.setInt(1, contato.getId());
//		statement.execute();
//
//		statement.close();
//		conexao.close();
//	}
//
//	public Contato getById(Integer id) throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "SELECT * from contato WHERE id_contato=?";
//		PreparedStatement statement = conexao.prepareStatement(sql);
//		statement.setInt(1, id);
//
//		ResultSet rs = statement.executeQuery();
//
//		Servico servico = null;
//
//		while (rs.next()) {
//			contato = new Contato(rs.getString("telefonePrincipal"),
//					rs.getString("telefoneAuxiliar"),
//					rs.getString("email"),
//					rs.getInt("id_contato"));
//		}
//
//		return contato;
//	}
//
//	public List<Servico> listAllContato() throws SQLException {
//		Connection conexao = FactoryConnetion.getConnection();
//		String sql = "SELECT * from contato";
//		PreparedStatement statement = conexao.prepareStatement(sql);
//
//		ResultSet rs = statement.executeQuery();
//
//		List<Servico> contatos = new ArrayList<>();
//
//		while (rs.next()) {
//			Servico servico = new Contato(rs.getString("telefonePrincipal"),
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
