package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Endereco;

public class EnderecoDAO {

	public void inserir(Endereco e) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO endereco (tipoLogradouro, logradouro, numeroResidencial,"
				+ " complemento, bairro, cidade," + " estado, pais, cep) " + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, e.getTipoLogradouro().getDescricao());
		statement.setString(2, e.getLogradouro());
		statement.setInt(3, e.getNumeroResidencial());
		statement.setString(4, e.getComplemento());
		statement.setString(5, e.getBairro());
		statement.setString(6, e.getCidade());
		statement.setString(7, e.getEstado().getNome());
		statement.setString(8, e.getPais());
		statement.setString(9, e.getCep());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Endereco e) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "UPDATE endereco SET tipoLogradouro= ?, logradouro= ?, numeroResidencial= ?,"
				+ " complemento= ?, bairro= ?, cidade= ?," + " estado= ?, pais= ?, cep= ?" + " WHERE id_endereco=?"
				+ "";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, e.getTipoLogradouro().getDescricao());
		statement.setString(2, e.getLogradouro());
		statement.setInt(3, e.getNumeroResidencial());
		statement.setString(4, e.getComplemento());
		statement.setString(5, e.getBairro());
		statement.setString(6, e.getCidade());
		statement.setString(7, e.getEstado().getNome());
		statement.setString(8, e.getPais());
		statement.setString(9, e.getCep());
		statement.setInt(10, e.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Endereco e) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM endereco WHERE id_endereco= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, e.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public Endereco getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from endereco WHERE id_endereco=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Endereco endereco = null;

		while (rs.next()) {
			endereco = new Endereco(id,
					TipoLogradouro.valueOf(TipoLogradouro.class, rs.getString("tipoLogradouro")),
					rs.getString("logradouro"),
					rs.getInt("numeroResidencial"),
					rs.getString("complemento"),
					rs.getString("cep"),
					rs.getString("bairro"),
					rs.getString("cidade"),
					Estado.fromUF("estado"),
					rs.getString("pais"));
		}

		return endereco;
	}

	public List<Endereco> listAllEndereco() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from endereco";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Endereco> enderecos = new ArrayList<>();

		while (rs.next()) {
			Endereco endereco = new Endereco(rs.getInt("id_endereco"),
					TipoLogradouro.valueOf(TipoLogradouro.class, rs.getString("tipoLogradouro")),
					rs.getString("logradouro"),
					rs.getInt("numeroResidencial"),
					rs.getString("complemento"),
					rs.getString("cep"),
					rs.getString("bairro"),
					rs.getString("cidade"),
					Estado.fromUF("estado"),
					rs.getString("pais"));

			enderecos.add(endereco);
		}

		return enderecos;
	}
}
