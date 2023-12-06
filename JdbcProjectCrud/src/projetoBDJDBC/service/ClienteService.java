package projetoBDJDBC.service;

import java.sql.SQLException;
import java.util.List;

import projetoBDJDBC.exception.ClienteJaCadastradoException;
import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.exception.ListaVaziaException;
import projetoBDJDBC.model.dao.ClienteDAOImplements;
import projetoBDJDBC.model.entidades.Cliente;

public class ClienteService {

	private ClienteDAOImplements cDAO;

	public ClienteService() throws ClassNotFoundException {
		if (cDAO == null) {
			this.cDAO = new ClienteDAOImplements();
		}
	}

	public void inserir(Cliente c) throws ClassNotFoundException, ClienteNãoInseridoException, SQLException {
		this.cDAO.inserir(c);
	}

	public void atualizar(Cliente c) throws ClassNotFoundException, ClienteNãoInseridoException, SQLException {
		this.cDAO.atualizar(c);
	}

	public void deletarPorCpf(Cliente c) throws ClassNotFoundException, SQLException {
		this.cDAO.deletarPorCpf(c);
	}

	public List<Cliente> listarTodos() throws ClassNotFoundException, SQLException, ListaVaziaException {
		if(cDAO.listarTodos().size() <  1) {
			throw new ListaVaziaException("\nNÃO HÁ CLIENTES CADASTRADOS!\n");
		}
		return cDAO.listarTodos();
	}

	public Cliente buscarPorID(String cpf) throws ClassNotFoundException {
		return this.cDAO.buscarPorId(cpf);
	}
	
	public void removerTodos() throws ListaVaziaException, ClassNotFoundException, SQLException{
		if(cDAO.listarTodos().size() <  1) {
			throw new ListaVaziaException("\nNÃO HÁ CLIENTES CADASTRADOS!\n");
		}
		this.cDAO.removerTodos();
	}

}
