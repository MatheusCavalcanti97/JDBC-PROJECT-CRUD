package projetoBDJDBC.model.util;

import java.text.Normalizer;
import java.text.ParseException;
import java.util.Calendar;

import projetoBDJDBC.exception.ApenasLetrasException;
import projetoBDJDBC.exception.AtributosNaoNulosNaoVaziosException;

public class ValidacaoProjectJDBCIO {

	public static boolean validaCpf(String cpf) {
		Boolean var = true;
		String verifyCpf = cpf.replaceAll(" ", "");
		verifyCpf = verifyCpf.trim().replaceAll(" ", "");

		if (cpf.length() == 11) {
			for (int i = 0; i < verifyCpf.length(); i++) {
				char c = verifyCpf.charAt(i);
				if (Character.isDigit(c)) {
					var = true;
				} else {
					var = false;
					break;
				}
			}
		} else {
			var = false;
		}

		return var;
	}

	public static Boolean verificacaoStringVazia(String str) throws AtributosNaoNulosNaoVaziosException {
		boolean var = true;
		str = str.replaceAll(" ", "");
		if (str.isEmpty()) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

	public static Boolean verificacaoStringNula(String str) throws AtributosNaoNulosNaoVaziosException {
		boolean var = true;
		if (str == null) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

	public static boolean validarData(int dia, int mes, int ano) throws ParseException {
		boolean var = true;

		Calendar cal = Calendar.getInstance();
		int anoC = cal.get(Calendar.YEAR);

		if (dia >= 1 && dia <= 31) {
			if (mes >= 1 && mes <= 12) {
				if (ano >= 1900 && ano <= anoC) {
					var = true;
				} else {
					var = false;
				}
			} else {
				var = false;
			}
		} else {
			var = false;
		}

		return var;
	}

	public static Boolean validacaoTelefoneException(String num){
		Boolean var = true;
		String verifyTel = num.replaceAll(" ", "");
		verifyTel = verifyTel.trim().replaceAll(" ", "");

		if (verifyTel.length() == 2 || verifyTel.length() == 9) {
			for (int i = 0; i < verifyTel.length(); i++) {
				char c = verifyTel.charAt(i);
				if (Character.isDigit(c)) {
					var = true;
				} else {
					var = false;
					break;
				}
			}
		} else {
			var = false;
		}

		return var;

	}

	public static Boolean ApenasDeLetras(String palavra) throws ApenasLetrasException {
		Boolean var = false;
		String verifyString = palavra.replaceAll(" ", "");
		palavra = palavra.trim().replaceAll(" ", "");

		for (int i = 0; i < palavra.length(); i++) {
			char c = verifyString.charAt(i);
			if (Character.isLetter(c)) {
				var = true;
			} else {
				var = false;
				break;
			}
		}
		return var;
	}

	public static String removeAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

}
