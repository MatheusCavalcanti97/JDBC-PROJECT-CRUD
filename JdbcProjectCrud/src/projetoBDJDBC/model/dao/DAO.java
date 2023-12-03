package projetoBDJDBC.model.dao;

import java.sql.SQLException;
import java.util.List;

import projetoBDJDBC.exception.ClienteNãoInseridoException;

public interface DAO<T> {

	public void inserir(T e) throws ClienteNãoInseridoException, ClassNotFoundException, SQLException;

	public void deletar(T e);

	public void atualizar(T e);

	public List<T> listarTodos(T e);

	public void buscarPorId(Integer id);

}
