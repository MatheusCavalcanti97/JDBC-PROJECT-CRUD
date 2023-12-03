package projetoBDJDBC.teste;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.model.entidades.Cliente;
import projetoBDJDBC.model.entidades.Endereco;
import projetoBDJDBC.service.ClienteService;

public class ClienteView {

	public static void main(String[] args) throws ClassNotFoundException {
		ClienteService cs = new ClienteService();
		Cliente c = null;
		Endereco end = null;
		String nome, sobrenome, cpfPessoa, email, cidade, estado, dataC;
		Date dataCadastrado = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		nome = "Matheus";
		sobrenome = "C";
		cpfPessoa = "12345678900";
		email = "matheus@ifpe";
		dataC = "22/07/1988";
		
		try {
			dataCadastrado = sdf.parse(dataC);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cidade = "Quipapa";
		estado = "PE";
		end = new Endereco(cidade, estado);

		c = new Cliente(nome, sobrenome, cpfPessoa, email, end, dataCadastrado);
		
		try {
			
			cs.inserir(c);
			c = null;
		} catch (ClassNotFoundException ex1) {
			System.out.print("\n--------------------------\n");
			System.out.print(ex1.getMessage());
		} catch (ClienteNãoInseridoException ex2) {
			System.out.print("\n--------------------------\n");
			System.out.print(ex2.getMessage());
		} catch (SQLException ex3) {
			System.out.print("\n--------------------------\n");
			System.out.print(ex3.getMessage());
		}

	}
}
