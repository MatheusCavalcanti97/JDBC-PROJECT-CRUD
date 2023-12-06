package projetoBDJDBC.model.entidades;

import java.util.Objects;

public abstract class Pessoa {
	
	public String cpfPessoa;
	public String nomePessoa;
	public String sobrenomePessoa;
	public String email;
	public Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(String cpfPessoa, String nomePessoa, String sobrenomePessoa, String email, Endereco endereco) {
		super();
		this.cpfPessoa = cpfPessoa;
		this.nomePessoa = nomePessoa;
		this.sobrenomePessoa = sobrenomePessoa;
		this.email = email;
		this.endereco = endereco;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getSobrenomePessoa() {
		return sobrenomePessoa;
	}

	public void setSobrenomePessoa(String sobrenomePessoa) {
		this.sobrenomePessoa = sobrenomePessoa;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfPessoa, email, endereco, nomePessoa, sobrenomePessoa);
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
		return Objects.equals(cpfPessoa, other.cpfPessoa) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(nomePessoa, other.nomePessoa)
				&& Objects.equals(sobrenomePessoa, other.sobrenomePessoa);
	}

}
