package projetoBDJDBC.model.entidades;

import java.util.Date;
import java.util.Objects;

public class Funcionario extends Pessoa {

	private String numeroMatricula;
	private double salario;
	private double comissao;
	private String cargo;
	private Date DataDeContratacao;

	public Funcionario() {
		super();
	}
	
	public Funcionario(String nomePessoa, String sobrenomePessoa, String cpfPessoa, String email,
			Endereco endereco, String numeroMatricula, double salario, double comissao, String cargo,
			Date DataDeContratacao) {
		super(nomePessoa, sobrenomePessoa, cpfPessoa, email, endereco);
		this.numeroMatricula = numeroMatricula;
		this.salario = salario;
		this.salario = salario;
		this.comissao = comissao;
		this.cargo = cargo;
		this.DataDeContratacao = DataDeContratacao;
	}

	public Funcionario(int idPessoa, String nomePessoa, String sobrenomePessoa, String cpfPessoa, String email,
			Endereco endereco, String numeroMatricula, double salario, double comissao, String cargo,
			Date DataDeContratacao) {
		super(idPessoa, nomePessoa, sobrenomePessoa, cpfPessoa, email, endereco);
		this.numeroMatricula = numeroMatricula;
		this.salario = salario;
		this.salario = salario;
		this.comissao = comissao;
		this.cargo = cargo;
		this.DataDeContratacao = DataDeContratacao;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataDeContratacao() {
		return DataDeContratacao;
	}

	public void setDataDeContratacao(Date dataDeContratacao) {
		DataDeContratacao = dataDeContratacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(DataDeContratacao, cargo, comissao, numeroMatricula, salario);
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(DataDeContratacao, other.DataDeContratacao) && Objects.equals(cargo, other.cargo)
				&& Double.doubleToLongBits(comissao) == Double.doubleToLongBits(other.comissao)
				&& Objects.equals(numeroMatricula, other.numeroMatricula)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}

}
