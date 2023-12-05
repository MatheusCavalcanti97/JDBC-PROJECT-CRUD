package projetoBDJDBC.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projetoBDJDBC.exception.AtributosNaoNulosNaoVaziosException;
import projetoBDJDBC.exception.ClienteJaCadastradoException;
import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.exception.CpfException;
import projetoBDJDBC.exception.ListaVaziaException;

public class MenuClienteJDBC {

	public static void menuCliente() {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  CLIENTE		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Inserir." + "\n2. Atualizar." + "\n3. Deletar Cliente Por Cpf."
						+ "\n4. Listar Todos os Cliente." +  "\n5. Buscar Cliente por CPF."+ "\n6. Deletar todos os Clientes." + "\n0. Sair." + "-> ");

				opcaoMenu = ler.nextInt();
				System.out.print("\n---------------------------\n");
			} catch (InputMismatchException e) {
				System.out.print("\n---------------------------\n");
				System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
				System.out.print("\nTENTE NOVAMENTE.");
				System.out.print("\n---------------------------\n");
				continue;
			}

			if (opcaoMenu == 0) {
				System.out.print("\n---------------------------\n");
				System.out.print("RETORNANDO PRO MENU ANTERIOR.");
				System.out.print("\n---------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu == 1) {

				try {

					ClienteView.getInstance().inserir();

				} catch (ClassNotFoundException ex1) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex1.getMessage());
				} catch (AtributosNaoNulosNaoVaziosException ex2) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex2.getMessage());
				} catch (ParseException ex3) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex3.getMessage());
				} catch (SQLException ex4) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex4.getMessage());
				} catch (ClienteNãoInseridoException ex5) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex5.getMessage());
				} catch (CpfException ex6) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex6.getMessage());
				} catch (ClienteJaCadastradoException ex7) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex7.getMessage());
				} catch (ListaVaziaException ex8) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex8.getMessage());
				}

			} else if (opcaoMenu == 2) {
				
				try {
					ClienteView.getInstance().atualizar();
				} catch (ClassNotFoundException ex1) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex1.getMessage());
				} catch (SQLException ex2) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex2.getMessage());
				} catch (ListaVaziaException ex3) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex3.getMessage());
				} catch(ClienteNãoInseridoException ex4) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex4.getMessage());
				}

			} else if (opcaoMenu == 3) {
				try {
					ClienteView.getInstance().deletarPorCpf();
				} catch(ClassNotFoundException ex1) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex1.getMessage());
				} catch(SQLException ex2) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex2.getMessage());
				} catch(ListaVaziaException ex3) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex3.getMessage());
				} catch(ClienteNãoInseridoException ex4) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex4.getMessage());
				}

			} else if (opcaoMenu == 4) {

				try {
					ClienteView.getInstance().listarTodos();
				} catch (ClassNotFoundException ex1) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex1.getMessage());
				} catch (SQLException ex2) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex2.getMessage());
				} catch (ListaVaziaException ex3) {
					System.out.print("\n---------------------------\n");
					System.out.print(ex3.getMessage());
				}

			} else if (opcaoMenu == 5) {

			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}
	}

}
