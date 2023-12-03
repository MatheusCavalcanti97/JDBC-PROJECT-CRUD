package projetoBDJDBC.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionBD {

	private static final String URL = "jdbc:postgresql://localhost:5432/JDBCPROJECTCRUD";
	private static final String USER = "postgres";
	private static final String PASSWORD = "12345";
	private static final String JDBCDRIVER = "org.postgresql.Driver";
	private static ConectionBD instance;
	public static Connection conn;

	public static synchronized ConectionBD getInstance() {

		if (instance == null) {
			instance = new ConectionBD();
		}
		return instance;
	}

	public Connection getConnectionJDBC() throws ClassNotFoundException, SQLException {

		if (conn != null)
			return conn;
		else {
			try {
				Class.forName(JDBCDRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException("ERRO DE MAPEAMENTO!");
			} catch (SQLException e) {
				throw new SQLException("ERRO AO REQUISITAR UMA CONEXÃO!");
			}
			return conn;
		}

	}

}
