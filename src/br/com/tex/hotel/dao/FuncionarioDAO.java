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
import br.com.tex.hotel.enums.Estado;
import br.com.tex.hotel.enums.TipoLogradouro;
import br.com.tex.hotel.model.Contato;
import br.com.tex.hotel.model.Endereco;
import br.com.tex.hotel.model.Funcionario;

public class FuncionarioDAO {

	public void inserir(Funcionario f) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO funcionario (matricula, nome, cpf, salario, dataNascimento, hotel_id_hotel,"
				+ " endereco_id_endereco, contato_id_contato) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, f.getMatricula());
		statement.setString(2, f.getNome());
		statement.setString(3, f.getCpf());
		statement.setBigDecimal(4, f.getSalario());
		statement.setDate(5, Date.valueOf(f.getDataNascimento()));
		statement.setInt(6, f.getHotel().getId());
		statement.setInt(7, f.getEndereco().getId());
		statement.setInt(8, f.getContato().getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Funcionario f) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE funcionario SET matricula= ?, nome= ?, cpf= ?, salario= ?, dataNascimento= ?,"
				+ " hotel_id_hotel= ?, endereco_id_endereco= ?, contato_id_contato= ? WHERE id_funcionario= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, f.getMatricula());
		statement.setString(2, f.getNome());
		statement.setString(3, f.getCpf());
		statement.setBigDecimal(4, f.getSalario());
		statement.setDate(5, Date.valueOf(f.getDataNascimento()));
		statement.setInt(6, f.getHotel().getId());
		statement.setInt(7, f.getEndereco().getId());
		statement.setInt(8, f.getContato().getId());
		statement.setInt(9, f.getId());

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Funcionario f) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM funcionario WHERE id_funcionario=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, f.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Funcionario getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from funcionario WHERE id_funcionario=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Funcionario f = null;

		while (rs.next()) {
			f = new Funcionario(rs.getInt("id_funcionario"),
					rs.getString("nome"),
					rs.getString("cpf"), 
					rs.getDate("dataNascimento").toLocalDate(),
					rs.getBigDecimal("salario"),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
		}

		return f;
	}

	public List<Funcionario> listAllFuncionario() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from funcionario";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Funcionario> funcionarios = new ArrayList<>();

		while (rs.next()) {
			Funcionario f = new Funcionario(rs.getInt("id_funcionario"),
					rs.getString("nome"),
					rs.getString("cpf"), 
					rs.getDate("dataNascimento").toLocalDate(),
					rs.getBigDecimal("salario"),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
			
			funcionarios.add(f);
		}

		return funcionarios;
	}
	
	public List<Funcionario> listFuncionariosByHotel(int idHotel) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from funcionario WHERE hotel_id_hotel";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, idHotel);
		ResultSet rs = statement.executeQuery();

		List<Funcionario> funcionarios = new ArrayList<>();

		while (rs.next()) {
			Funcionario f = new Funcionario(rs.getInt("id_funcionario"),
					rs.getString("nome"),
					rs.getString("cpf"), 
					rs.getDate("dataNascimento").toLocalDate(),
					rs.getBigDecimal("salario"),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")),
					new HotelDAO().getById(rs.getInt("hotel_id_hotel")));
			
			funcionarios.add(f);
		}

		return funcionarios;
	}
}
