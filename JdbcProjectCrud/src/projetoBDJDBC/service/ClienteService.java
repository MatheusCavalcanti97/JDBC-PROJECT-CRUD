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

	public void inserir(Cliente c) throws ClassNotFoundException, ClienteNãoInseridoException, SQLException, ClienteJaCadastradoException, ListaVaziaException {
		this.cDAO.inserir(c);
	}

	public void atualizar(Cliente c) {

	}

	public void deletarPorCpf(Cliente c) throws ClassNotFoundException, SQLException {
		this.cDAO.deletarPorCpf(c);
	}

	public List<Cliente> listarTodos() throws ClassNotFoundException, SQLException, ListaVaziaException {
		return cDAO.listarTodos();
	}

	public void buscarPorID(Integer id) {
	}

}
