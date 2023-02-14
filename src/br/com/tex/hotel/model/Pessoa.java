package br.com.tex.hotel.model;

import java.time.LocalDate;
import java.util.Objects;

import br.com.tex.hotel.util.exeption.ExeptionUtil;
import br.com.tex.hotel.util.validacoes.ValidaCPF;

/**
 * 
 * @author willian
 *
 */
public class Pessoa {
	private Integer id;
	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private Contato contato;
	private Endereco endereco;

	private static int contador;

	public Pessoa() {
		this.id = contador++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ExeptionUtil, Exception {
		if (!ValidaCPF.cpfValido(cpf)) {
			throw new ExeptionUtil("CPF inválido");
		} else {
			this.cpf = cpf;
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {

		final StringBuilder sb = new StringBuilder("Pessoa{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", cpf='").append(cpf).append('\'');
		sb.append(", dataNascimento='").append(dataNascimento).append('\'');
		sb.append(", contato='").append(contato).append('\'');
		sb.append(", endereco='").append(endereco).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
