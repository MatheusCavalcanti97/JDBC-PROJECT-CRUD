package projetoBDJDBC.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.exception.ListaVaziaException;
import projetoBDJDBC.model.entidades.Cliente;
import projetoBDJDBC.model.entidades.Endereco;
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
			e.printStackTrace();
		}

	}

	@Override
	public void deletar(Cliente e) {

	}

	@Override
	public void atualizar(Cliente e) {

	}

	@Override
	public List<Cliente> listarTodos() throws ClassNotFoundException, SQLException, ListaVaziaException {
		Connection conect = null;
		Statement ps = null;
		ResultSet resultSet = null;
		List<Cliente> clientes = new ArrayList<>();

		try {
			conect = conn.getConnectionJDBC();

			String sqlConsult = "select * from cliente";

			ps = conect.createStatement();
			resultSet = ps.executeQuery(sqlConsult);

			clientes = new ArrayList<>();

			while (resultSet.next()) {
				int idCliente = resultSet.getInt(IDPESSOA_COLUMN_NAME);
				String nomePessoa = resultSet.getString(NOMEPESSOA_COLUMN_NAME);
				String sobrenomePessoa = resultSet.getString(SOBRENOMEPESSOA_COLUMN_NAME);
				String cpfPessoa = resultSet.getString(CPFPESSOA_COLUMN_NAME);
				String email = resultSet.getString(EMAIL_COLUMN_NAME);
				String cidadeendereco = resultSet.getString(CIDADEENDERECO_COLUMN_NAME);
				String estadoendereco = resultSet.getString(ESTADOENDERECO_COLUMN_NAME);
				Date dataC = resultSet.getDate(DATACADASTRO_COLUMN_NAME);

				Endereco end = new Endereco(cidadeendereco, estadoendereco);

				clientes.add(new Cliente(idCliente, nomePessoa, sobrenomePessoa, cpfPessoa, email, end,
						new java.util.Date(dataC.getTime())));
			}

			if (clientes.size() < 1) {
				throw new ListaVaziaException("\nNÃO HÁ CLIENTE(S) CADASTRADO(S).\n");
			}

		} catch (ClassNotFoundException e1) {
			throw new ClassNotFoundException("CLASSE NÃO ENCONTRADA");
		} catch (SQLException e1) {
			throw new SQLException("VERIFIQUE AS INFORMAÇÕES DE COMUNICACAO COM O DAO");
		}

		return clientes;
	}

	@Override
	public void buscarPorId(String str) {
		// TODO Auto-generated method stub

	}

	public boolean clienteJaCadastrado() {
		Boolean var = true;

		return var;
	}

}
