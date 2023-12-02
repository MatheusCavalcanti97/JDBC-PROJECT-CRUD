package projetoBDJDBC.model.entidades;

import java.util.Objects;

public class Endereco {

	private String cidade;
	private String estado;

	public Endereco() {
		super();
	}

	public Endereco(String cidade, String estado) {
		super();
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, estado);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(estado, other.estado);
	}

}
