package br.com.tex.hotel.util.validacoes;

import java.util.InputMismatchException;

/**
 * 
 * @author willian
 *
 */
public class ValidaCPF {

	/**
	 * 
	 * @param cpf Cpf da pessoa
	 * @return Se cpf é válido retorna true, caso contrário, retorna false
	 */
	public static boolean cpfValido(String cpf) {

		if (cpf.trim().isEmpty())
			return false;

		cpf = (((cpf.replace("-", "")).replace(".", "")).replace("/", ""));

		if (cpf.trim().length() < 11)
			return false;

		if (isCpfTemLetraOuTodosDigitosIguais(cpf))
			return false;

		return isDigitosValidos(cpf);

	}

	/**
	 * 
	 * @param cpf da pessoa
	 * @return	Retorna true caso o cpf informado contenha letras ou todos os digitos repetidos
	 */
	private static boolean isCpfTemLetraOuTodosDigitosIguais(String cpf) {
		for (int i = 0; i < cpf.length(); i++) {

			char firstLetter = cpf.charAt(0);
			char c = cpf.charAt(i);

			if (Character.isLetter(c))
				return true;

			if (firstLetter != c)
				return false;

			return true;
		}
		return true;
	}

	/**
	 * 
	 * @param cpf
	 * @return	Retorna true caso os dígitos verificadores sejam válidos
	 */
	private static boolean isDigitosValidos(String cpf) {
		int dig10, dig11;
		int soma, resto, num, peso;

		try {
			soma = 0;
			peso = 10;
			for (int i = 0; i < 9; i++) {
				num = Character.getNumericValue(cpf.charAt(i));
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);
			if ((resto == 10) || (resto == 11))
				dig10 = 0;
			else
				dig10 = resto;

			soma = 0;
			peso = 11;
			for (int i = 0; i < 10; i++) {
				num = Character.getNumericValue(cpf.charAt(i));
				soma = soma + (num * peso);
				peso = peso - 1;
			}

			resto = 11 - (soma % 11);
			if ((resto == 10) || (resto == 11))
				dig11 = 0;
			else
				dig11 = resto;

			if ((dig10 == Character.getNumericValue(cpf.charAt(9)))
					&& (dig11 == Character.getNumericValue(cpf.charAt(10))))
				return true;
			else
				return (false);
		} catch (InputMismatchException erro) {
			return false;
		}
	}
}
