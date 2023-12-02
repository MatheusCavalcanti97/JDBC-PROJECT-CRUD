package projetoBDJDBC.model.dao;

import java.util.List;

public interface Dao<T> {

	public void inserir(T e);

	public void deletar(T e);

	public void atualizar(T e);

	public List<T> listarTodos(T e);

	public void buscarPorId(Integer id);

}
