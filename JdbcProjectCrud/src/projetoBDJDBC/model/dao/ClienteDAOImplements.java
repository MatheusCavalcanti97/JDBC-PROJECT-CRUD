package projetoBDJDBC.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.model.entidades.Cliente;
import projetoBDJDBC.model.util.ConectionBD;

public class ClienteDAOImplements implements DAO<Cliente> {

//	IDPESSOA SERIAL, - ok
//	NOMEPESSOA VARCHAR(20) NOT NULL, - ok
//	SOBRENOMEPESSOA VARCHAR(40)NOT NULL, - ok
//	CPFPESSOA VARCHAR(11), - ok
//	EMAIL VARCHAR(30)NOT NULL, - ok
//	CIDADEENDERECO VARCHAR(30) NOT NULL, - ok
//	ESTADOENDERECO VARCHAR(30) NOT NULL, - ok
//	DATACADASTRO DATE NOT NULL,  - ok

	public static final int IDPESSOA_COLUMN_ORDER = 1;
	public static final int NOMEPESSOA_COLUMN_ORDER = 2;
	public static final int SOBRENOMEPESSOA_COLUMN_ORDER = 3;
	public static final int CPFPESSOA_COLUMN_ORDER = 4;
	public static final int EMAIL_COLUMN_ORDER = 5;
	public static final int CIDADEENDERECO_COLUMN_ORDER = 6;
	public static final int ESTADOENDERECO_COLUMN_ORDER = 7;
	public static final int DATACADASTRO_COLUMN_ORDER = 8;

	public static final String IDPESSOA_COLUMN_NAME = "idpessoa";
	public static final String NOMEPESSOA_COLUMN_NAME = "nomepessoa";
	public static final String SOBRENOMEPESSOA_COLUMN_NAME = "sobrenomepessoa";
	public static final String CPFPESSOA_COLUMN_NAME = "cpfpessoa";
	public static final String EMAIL_COLUMN_NAME = "email";
	public static final String CIDADEENDERECO_COLUMN_NAME = "cidadeendereco";
	public static final String ESTADOENDERECO_COLUMN_NAME = "estadoendereco";
	public static final String DATACADASTRO_COLUMN_NAME = "datacadastro";

	private ConectionBD conn;

	public ClienteDAOImplements() throws ClassNotFoundException {
		this.conn = ConectionBD.getInstance();
	}

	@Override
	public void inserir(Cliente c) throws ClienteNãoInseridoException, ClassNotFoundException, SQLException {
		int verificacaoTamTupla = 0;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = conn.getConnectionJDBC();
			String sql = "insert into cliente(NOMEPESSOA,SOBRENOMEPESSOA, CPFPESSOA, EMAIL, CIDADEENDERECO, ESTADOENDERECO, DATACADASTRO) values (?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);

			ps.setString(1, c.getNomePessoa());
			ps.setString(2, c.getSobrenomePessoa());
			ps.setString(3, c.getCpfPessoa());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getEndereco().getCidade());
			ps.setString(6, c.getEndereco().getEstado());
			ps.setDate(7, new Date(c.getDataDeCadastro().getTime()));

			verificacaoTamTupla = ps.executeUpdate();

			if (verificacaoTamTupla < 1) {
				throw new ClienteNãoInseridoException("\nO CLIENTE NÃO FOI INSERIDO NO DATABASE!\n");
			}

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("CLASSE NÃO ENCONTRADA");
		} catch (SQLException e) {
			throw new SQLException("VERIFIQUE AS INFORMAÇÕES DE COMUNICACAO COM O DAO");
		} finally {
			ps.close();
			con.close();
		}

	}

	@Override
	public void deletar(Cliente e) {

	}

	@Override
	public void atualizar(Cliente e) {

	}

	@Override
	public List<Cliente> listarTodos(Cliente e) {

		return null;
	}

	@Override
	public void buscarPorId(Integer id) {
		// TODO Auto-generated method stub

	}

}
