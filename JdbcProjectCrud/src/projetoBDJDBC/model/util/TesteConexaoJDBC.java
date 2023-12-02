package projetoBDJDBC.model.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexaoJDBC {

	public static void main(String[] args) {
		try {

			Connection c = ConectionBD.getInstance().getConnectionJDBC();
			Connection c1 = ConectionBD.getInstance().getConnectionJDBC();
			System.out.print("\n------------------------------------\n");
			System.out.print("\nCONEXÃO BEM SUCEDIDA!\n");
			System.out.print("\n------------------------------------\n");
			
			System.out.println("\nSINGLETON - VERIFICACAO DE REFERENCIA\n DE MESMO OBJETO 01:\n");
			System.out.println(c);
			
			System.out.print("\n------------------------------------\n");
			
			System.out.println("\nSINGLETON - VERIFICACAO DE REFERENCIA\n DE MESMO OBJETO 02:\n");
			System.out.println(c1);

		} catch (ClassNotFoundException ex1) {
			System.out.print("\n------------------------------------\n");
			System.out.print(ex1.getMessage());
		} catch (SQLException ex2) {
			System.out.print("\n------------------------------------\n");
			System.out.print(ex2.getMessage());
		}
	}
}
