package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Contato;

public class ContatoDAO {

	public void inserir(Contato contato) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO contato (telefonePrincipal, telefoneAuxiliar, email) VALUES(?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, contato.getTelefonePrincipal());
		statement.setString(2, contato.getTelefoneAuxiliar());
		statement.setString(3, contato.getEmail());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Contato contato) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE contato SET telefonePrincipal=?, telefoneAuxiliar=?, email=? WHERE id_contato=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, contato.getTelefonePrincipal());
		statement.setString(2, contato.getTelefoneAuxiliar());
		statement.setString(3, contato.getEmail());
		statement.setInt(4, contato.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Contato contato) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM contato WHERE id_contato=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, contato.getTelefonePrincipal());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Contato getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from contato WHERE id_contato=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Contato contato = null;

		while (rs.next()) {
			contato = new Contato(rs.getString("telefonePrincipal"), rs.getString("telefoneAuxiliar"),
					rs.getString("email"), rs.getInt("id_contato"));
		}

		return contato;
	}
}
