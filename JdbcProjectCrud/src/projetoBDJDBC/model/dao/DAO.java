package projetoBDJDBC.model.dao;

import java.sql.SQLException;
import java.util.List;

import projetoBDJDBC.exception.ClienteJaCadastradoException;
import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.exception.ListaVaziaException;
import projetoBDJDBC.model.entidades.Cliente;

public interface DAO<T> {

	public void inserir(T e) throws ClienteNãoInseridoException, ClassNotFoundException, SQLException, ClienteJaCadastradoException, ListaVaziaException;

	public void deletarPorCpf(T e) throws SQLException, ClassNotFoundException;

	public void atualizar(T e) throws ClassNotFoundException, ClienteNãoInseridoException, SQLException;

	public List<T> listarTodos() throws ClassNotFoundException, SQLException, ListaVaziaException;

	public Cliente buscarPorId(String str) throws ClassNotFoundException;

}
