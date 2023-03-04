package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Acomodacao;

public class AcomodacaoDAO {

	public void inserir(Acomodacao a) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO acomodacao (nome, valorPorAdulto, valorPorCrianca,"
				+ " tamanho, quartoLivre, hotel_id_hotel)"
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, a.getNomeAcomodacao());
		statement.setBigDecimal(2, a.getValorAdulto());
		statement.setBigDecimal(3, a.getValorCrianca());
		statement.setBigDecimal(4, a.getTamanhoQuarto());
		statement.setBoolean(5, a.isQuartoLivre());
		statement.setInt(6, a.getHotel().getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Acomodacao a) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE acomodacao SET nome= ?, valorPorAdulto= ?, valorPorCrianca= ?,"
				+ " tamanho= ?, quartoLivre= ?, hotel_id_hotel= ?"
				+ " WHERE id_acomodacao= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, a.getNomeAcomodacao());
		statement.setBigDecimal(2, a.getValorAdulto());
		statement.setBigDecimal(3, a.getValorCrianca());
		statement.setBigDecimal(4, a.getTamanhoQuarto());
		statement.setBoolean(5, a.isQuartoLivre());
		statement.setInt(6, a.getHotel().getId());
		statement.setInt(7, a.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Acomodacao a) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM acomodacao WHERE id_acomodacao=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, a.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Acomodacao getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from acomodacao WHERE id_acomodacao= ?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Acomodacao a = null;

		while (rs.next()) {
			a = new Acomodacao(rs.getInt("id_acomodacao"),
					rs.getString("nome"),
					rs.getBigDecimal("valorPorAdulto"),
					rs.getBigDecimal("valorPorCrianca"),
					rs.getBoolean("quartoLivre"),
					rs.getBigDecimal("tamanho"),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
		}

		return a;
	}

	public List<Acomodacao> listAllAcomodacao() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from acomodacao";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Acomodacao> quartos = new ArrayList<>();

		while (rs.next()) {
			Acomodacao a = new Acomodacao(rs.getInt("id_acomodacao"),
					rs.getString("nome"),
					rs.getBigDecimal("valorPorAdulto"),
					rs.getBigDecimal("valorPorCrianca"),
					rs.getBoolean("quartoLivre"),
					rs.getBigDecimal("tamanho"),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
			
			quartos.add(a);
		}

		return quartos;
	}
	
	public List<Acomodacao> listAcomodacaoByHotel(int idHotel) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from acomodacao WHERE hotel_id_hotel=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idHotel);

		ResultSet rs = statement.executeQuery();

		List<Acomodacao> quartos = new ArrayList<>();

		while (rs.next()) {
			Acomodacao a = new Acomodacao(rs.getInt("id_acomodacao"),
					rs.getString("nome"),
					rs.getBigDecimal("valorPorAdulto"),
					rs.getBigDecimal("valorPorCrianca"),
					rs.getBoolean("quartoLivre"),
					rs.getBigDecimal("tamanho"),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
			
			quartos.add(a);
		}

		return quartos;
	}
}
