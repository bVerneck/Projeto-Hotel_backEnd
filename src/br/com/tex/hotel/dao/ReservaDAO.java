package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Acomodacao;
import br.com.tex.hotel.model.Reserva;


public class ReservaDAO {

	public void inserir(Reserva reserva) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO reserva (dataCheckin, dataCheckout, quantidadeAdulto, "
				+ "quantidadeCrianca, acomodacao_id_acomodcao) \n"
				+ "VALUES (?,?,?,?,?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setDate(1, Date.valueOf(reserva.getDataCheckIn()));
		statement.setDate(2, Date.valueOf(reserva.getDataCheckOut()));
		statement.setInt(3, reserva.getQuantHospedeAdulto());
		statement.setInt(4, reserva.getQuantHospedeAteOitoAnos());
		statement.setInt(5, reserva.getQuarto().getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Reserva reserva) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE reserva SET dataCheckin=?, dataCheckout=?, quantidadeAdulto=?, quantidadeCrianca=?,"
				+ " acomodacao_id_acomodacao=? WHERE id_reserva=?";
		
//		(dataCheckin, dataCheckout, quantidadeAdulto, "
//				+ "quantidadeCrianca, acomodacao_id_acomodcao

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setDate(1, Date.valueOf(reserva.getDataCheckIn()));
		statement.setDate(2, Date.valueOf(reserva.getDataCheckOut()));
		statement.setInt(3, reserva.getQuantHospedeAdulto());
		statement.setInt(4, reserva.getQuantHospedeAteOitoAnos());
		statement.setInt(5, reserva.getQuarto().getId());
		statement.setInt(6, reserva.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Reserva reserva) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM reserva WHERE id_reserva=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, reserva.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Reserva getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from reserva WHERE id_reserva=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Reserva reserva = null;

		while (rs.next()) {
			reserva = new Reserva(rs.getInt("id_reserva"),
					rs.getDate("dataCheckin").toLocalDate(),
					rs.getDate("dataCheckout").toLocalDate(),
					rs.getInt("quantidadeAdulto"),
					rs.getInt("quantidadeCrianca"),
					new AcomodacaoDAO().getById(rs.getInt("acomodacao_id_acomodacao")));
												
		}

		return reserva;
	}

	public List<Reserva> listAllreserva() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from reserva";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Reserva> reservas = new ArrayList<>();

		while (rs.next()) {
			Reserva reserva = new Reserva(rs.getInt("id_reserva"),
					rs.getDate("dataCheckin").toLocalDate(),
					rs.getDate("dataCheckout").toLocalDate(),
					rs.getInt("quantidadeAdulto"),
					rs.getInt("quantidadeCrianca"),
					new AcomodacaoDAO().getById(rs.getInt("acomodacao_id_acomodacao")));

			reservas.add(reserva);
		}

		return reservas;
	}
}
