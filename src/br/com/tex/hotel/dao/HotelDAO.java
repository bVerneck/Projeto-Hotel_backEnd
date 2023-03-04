package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Hotel;

public class HotelDAO {

	public void inserir(Hotel h) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO hotel (nome, contato_id_contato, endereco_id_endereco) VALUES(?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, h.getNome());
		statement.setInt(2, h.getContato().getId());
		statement.setInt(3, h.getEndereco().getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Hotel h) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE hotel SET nome=?, contato_id_contato=?, endereco_id_endereco=? WHERE id_hotel=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, h.getNome());
		statement.setInt(2, h.getContato().getId());
		statement.setInt(3, h.getEndereco().getId());
		statement.setInt(4, h.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Hotel h) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM hotel WHERE id_hotel=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, h.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Hotel getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from hotel WHERE id_hotel=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Hotel h = null;

		while (rs.next()) {
			h = new Hotel(rs.getString("nome"),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")));
		}

		return h;
	}

	public List<Hotel> listAllHotel() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from hotel";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Hotel> hoteis = new ArrayList<>();

		while (rs.next()) {
			Hotel h = new Hotel(rs.getInt("id_hotel"),
					rs.getString("nome"),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")));
		}
		
		if(hoteis != null && !hoteis.isEmpty()) {
			for (Hotel hotel : hoteis) {
				hotel.setFuncionarios(new FuncionarioDAO().listFuncionariosByHotel(hotel.getId()));
				hotel.setAcomodacoes(new AcomodacaoDAO().listAcomodacaoByHotel(hotel.getId()));
			}
		}

		return hoteis;
	}
}
