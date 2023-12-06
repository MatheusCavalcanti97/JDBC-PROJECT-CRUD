package projetoBDJDBC.model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Cliente extends Pessoa {

	private Date dataDeCadastro;

	public Cliente() {}
	
	public Cliente(int idPessoa, String nomePessoa, String sobrenomePessoa, String cpfPessoa, String email,
			Endereco endereco, Date dataDeCadastro) {
		super(idPessoa, nomePessoa, sobrenomePessoa, cpfPessoa, email, endereco);
		this.dataDeCadastro = dataDeCadastro;
	}

	public Cliente(String nomePessoa, String sobrenomePessoa, String cpfPessoa, String email,
			Endereco endereco, Date dataDeCadastro) {
		super(nomePessoa, sobrenomePessoa, cpfPessoa, email, endereco);
		this.dataDeCadastro = dataDeCadastro;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	@Override
	public String toString() {
		String dataC = " ";
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataC = sdf.format(this.dataDeCadastro);
		return "NOME: " + this.nomePessoa + " -- SOBRENOME: " + this.sobrenomePessoa
				+ " -- CPF: " + this.cpfPessoa + " -- Data de cadastro: " + dataC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataDeCadastro);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dataDeCadastro, other.dataDeCadastro);
	}

}
