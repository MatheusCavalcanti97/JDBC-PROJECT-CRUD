package projetoBDJDBC.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainSystem {

	public void run() {
		Boolean flagMenu = true;
		Integer opcaoMenu = null;
		while (flagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.printf("\n---------------------------\n");
				System.out.println("\n	  MENU		");
				System.out.printf("\n---------------------------\n");
				System.out.printf("\n1. Opções de Cliente.");
				System.out.printf("\n0. Sair. -> ");

				opcaoMenu = ler.nextInt();
				System.out.printf("\n---------------------------\n");
			} catch (InputMismatchException e) {
				System.out.print("\n---------------------------\n");
				System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
				System.out.print("\nTENTE NOVAMENTE.");
				System.out.print("\n---------------------------\n");
				continue;
			}

			if (opcaoMenu == 0) {
				System.out.println("PROGRAMA ENCERRADO.");
				flagMenu = false;
			} else if (opcaoMenu == 1) {
				MenuClienteJDBC.menuCliente();
			} else if (opcaoMenu < 1 || opcaoMenu > 1) {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			} else {

			}
		}
	}

}
