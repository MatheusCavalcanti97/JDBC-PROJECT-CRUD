package projetoBDJDBC.view;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import projetoBDJDBC.exception.AtributosNaoNulosNaoVaziosException;
import projetoBDJDBC.exception.ClienteJaCadastradoException;
import projetoBDJDBC.exception.ClienteNãoInseridoException;
import projetoBDJDBC.exception.CpfException;
import projetoBDJDBC.exception.ListaVaziaException;
import projetoBDJDBC.model.entidades.Cliente;
import projetoBDJDBC.model.entidades.Endereco;
import projetoBDJDBC.model.util.ValidacaoProjectJDBCIO;
import projetoBDJDBC.service.ClienteService;

public class ClienteView {

	Scanner ler = new Scanner(System.in);
	private static ClienteView cv;
	private static ClienteService cs;

	private static synchronized ClienteService getCS() throws ClassNotFoundException {

		if (cs == null) {
			cs = new ClienteService();
		}
		return cs;
	}

	public static synchronized ClienteView getInstance() {

		if (cv == null) {
			cv = new ClienteView();
		}
		return cv;
	}

	public void inserir()
			throws CpfException, ClassNotFoundException, AtributosNaoNulosNaoVaziosException, ParseException,
			ClienteNãoInseridoException, SQLException, ClienteJaCadastradoException, ListaVaziaException {

		Cliente c = null;
		Endereco end = null;
		Date dataCadastrado = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String nomePessoa = "", sobrenomePessoa = "", cpfPessoa = "", email = "", cidadeEndereco = "",
				estadoEndereco = "", dataC = "";
		int dia = 0, mes = 0, ano = 0;

		Integer opcaoMenu = null;
		Boolean var = true;

		while (var) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  INSERIR CLIENTE		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Deseja Inserir?" + "\n0. Sair." + "-> ");

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
				var = false;
			} else if (opcaoMenu == 1) {

				System.out.print("\n---------------------------\n");
				System.out.print("\nCPF: ");
				cpfPessoa = ler.nextLine();

				if (ValidacaoProjectJDBCIO.validaCpf(cpfPessoa) == true) {
					System.out.print("NOME: ");
					nomePessoa = ler.nextLine();

					System.out.print("SOBRENOME: ");
					sobrenomePessoa = ler.nextLine();

					System.out.print("EMAIL: ");
					email = ler.nextLine();

					System.out.print("\n---------------------------\n");
					System.out.print("INFO. ENDEREÇO");
					System.out.print("\n---------------------------\n");

					System.out.print("CIDADE: ");
					cidadeEndereco = ler.nextLine();

					System.out.print("ESTADO: ");
					estadoEndereco = ler.nextLine();

					if (ValidacaoProjectJDBCIO.verificacaoStringNula(nomePessoa) == false
							&& ValidacaoProjectJDBCIO.verificacaoStringVazia(nomePessoa) == false) {
						if (ValidacaoProjectJDBCIO.verificacaoStringNula(sobrenomePessoa) == false
								&& ValidacaoProjectJDBCIO.verificacaoStringVazia(sobrenomePessoa) == false) {
							if (ValidacaoProjectJDBCIO.verificacaoStringNula(email) == false
									&& ValidacaoProjectJDBCIO.verificacaoStringVazia(email) == false) {
								if (ValidacaoProjectJDBCIO.verificacaoStringNula(cidadeEndereco) == false
										&& ValidacaoProjectJDBCIO.verificacaoStringVazia(cidadeEndereco) == false) {
									if (ValidacaoProjectJDBCIO.verificacaoStringNula(estadoEndereco) == false
											&& ValidacaoProjectJDBCIO.verificacaoStringVazia(estadoEndereco) == false) {

										System.out.print("\n---------------------------\n");
										System.out.print("\n   DATA DE CADASTRO\n");
										System.out.print("\n---------------------------\n");

										System.out.print("DIA DE CADASTRO: ");
										dia = ler.nextInt();

										System.out.print("MES DE CADASTRO: ");
										mes = ler.nextInt();

										System.out.print("ANO DE CADASTRO: ");
										ano = ler.nextInt();

										if (ValidacaoProjectJDBCIO.validarData(dia, mes, ano) == true) {

											dataC = dia + "/" + mes + "/" + ano;
											dataCadastrado = sdf.parse(dataC);

											end = new Endereco(cidadeEndereco, estadoEndereco);
											c = new Cliente(nomePessoa, sobrenomePessoa, cpfPessoa, email, end,
													dataCadastrado);

											ClienteView.getCS().inserir(c);

											System.out.print("\n---------------------------\n");
											System.out.print("CLIENTE INSERIDO!");
										} else {
											throw new ParseException("\nDATA INCORRETA!", 1);
										}
									} else {
										throw new AtributosNaoNulosNaoVaziosException(
												"\nO CAMPO ESTADO DEVE ESTAR PREENCHIDO!\n");
									}
								} else {
									throw new AtributosNaoNulosNaoVaziosException(
											"\nO CAMPO CIDADE DEVE ESTAR PREENCHIDO!\n");
								}
							} else {
								throw new AtributosNaoNulosNaoVaziosException(
										"\nO CAMPO EMAIL DEVE ESTAR PREENCHIDO!\n");
							}
						} else {
							throw new AtributosNaoNulosNaoVaziosException(
									"\nO CAMPO SOBRENOME DEVE ESTAR PREENCHIDO!\n");
						}
					} else {
						throw new AtributosNaoNulosNaoVaziosException("\nO CAMPO NOME DEVE ESTAR PREENCHIDO!\n");
					}
				} else {
					throw new CpfException("\nCPF INVALIDO!\n");
				}

			} else {
				System.out.print("\n---------------------------\n\n");
				System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
				System.out.print("\n---------------------------\n\n");
			}
		}

	}

	public void deletarPorCpf()
			throws ClassNotFoundException, SQLException, ListaVaziaException, ClienteNãoInseridoException {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  DELETAR CLIENTE		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Deseja Deletar um Cliente?" + "\n0. Sair." + "-> ");

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
				Cliente c = null;
				String cpf = null;
				List<Cliente> lCliente = ClienteView.getCS().listarTodos();

				System.out.print("\n---------------------------\n");
				System.out.print("\nLISTA DE CLIENTE\n");
				System.out.print("\n---------------------------\n");
				for (int i = 0; i < lCliente.size(); i++) {
					System.out.println((i + 1) + "º - " + lCliente.get(i).getNomePessoa() + " - CPF: "
							+ lCliente.get(i).getCpfPessoa());
				}

				System.out.print("\n---------------------------\n");
				System.out.print("INFORME O CPF PARA EXCLUIR: ");
				cpf = ler.nextLine();

				for (int j = 0; j < lCliente.size(); j++) {

					if (cpf.equalsIgnoreCase(lCliente.get(j).getCpfPessoa())) {
						c = lCliente.get(j);
						ClienteView.getCS().deletarPorCpf(c);

						System.out.print("\n---------------------------\n");
						System.out.print("\nCLIENTE EXCLUÍDO!\n");
						c = null;
						break;

					} else {
						throw new ClienteNãoInseridoException("\nCPF DE CLIENTE NÃO ENCONTRADO!\n");
					}
				}
			}
		}

	}

	public void atualizar() throws ClassNotFoundException, SQLException, ListaVaziaException, ClienteNãoInseridoException {

		Integer opcaoMenu = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.print("\n---------------------------\n");
				System.out.print("	  ATUALIZAR CLIENTE		");
				System.out.print("\n---------------------------\n");
				System.out.print("\n1. Deseja Atualizar um Cliente?." + "\n0. Sair." + "-> ");

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
				Cliente c = null;
				String cpf = null;
				List<Cliente> lCliente = ClienteView.getCS().listarTodos();

				System.out.print("\n---------------------------\n");
				System.out.print("\nLISTA DE CLIENTE\n");
				System.out.print("\n---------------------------\n");

				for (int i = 0; i < lCliente.size(); i++) {
					System.out.println((i + 1) + "º - " + lCliente.get(i).getNomePessoa() + " - CPF: "
							+ lCliente.get(i).getCpfPessoa());
				}

				Boolean flagMenu1 = true;
				Integer opcaoMenu1 = null;
				while (flagMenu1) {

					try {
						Scanner ler = new Scanner(System.in);
						System.out.printf("\n---------------------------\n");
						System.out.println("\n	  ESCOLHA UMA DAS OPÇÕES		");
						System.out.printf("\n---------------------------\n");
						System.out.printf("\n1. Atualiza Nome.");
						System.out.printf("\n2. Atualizar Endereço.");
						System.out.printf("\n3. Atualizar Email.");
						System.out.printf("\n0. Sair. -> ");

						opcaoMenu1 = ler.nextInt();
						System.out.printf("\n---------------------------\n");
					} catch (InputMismatchException e) {
						System.out.print("\n---------------------------\n");
						System.out.print("CARACTER INSERIDO INCORRETAMENTE.");
						System.out.print("\nTENTE NOVAMENTE.");
						System.out.print("\n---------------------------\n");
						continue;
					}

					if (opcaoMenu1 == 0) {
						System.out.println("PROGRAMA ENCERRADO.");
						flagMenu1 = false;
					} else if (opcaoMenu1 == 1) {
						System.out.print("\n---------------------------\n");
						System.out.print("INFORME O CPF PARA ATUALIZAR INFORMAÇÕES: ");
						cpf = ler.nextLine();
						
						
						for (int j = 0; j < lCliente.size(); j++) {

							if (cpf.equalsIgnoreCase(lCliente.get(j).getCpfPessoa())) {
								
								c = lCliente.get(j);
								ClienteView.getCS().deletarPorCpf(c);

								System.out.print("\n---------------------------\n");
								System.out.print("\nCLIENTE EXCLUÍDO!\n");
								c = null;
								break;

							} else {
								throw new ClienteNãoInseridoException("\nCPF DE CLIENTE NÃO ENCONTRADO!\n");
							}
						}

					} else if (opcaoMenu1 == 2) {

					} else if (opcaoMenu1 == 3) {

					} else if (opcaoMenu1 < 1 || opcaoMenu1 > 3) {
						System.out.print("\n---------------------------\n\n");
						System.out.printf("\nINSIRA UMA OPÇÃO CORRETA!\n");
						System.out.print("\n---------------------------\n\n");
					} else {

					}
				}
			}
		}

	}

	public void listarTodos() throws ClassNotFoundException, SQLException, ListaVaziaException {

		ClienteService cs = ClienteView.getCS();
		List<Cliente> cliente = cs.listarTodos();

		System.out.println(cliente.size());

		System.out.print("\n---------------------------\n");
		System.out.print("LISTA DE CLIENTES CADASTRADOS.");
		System.out.print("\n---------------------------\n");
		for (int i = 0; i < cliente.size(); i++) {

			System.out.print("\n" + (i + 1) + "º - " + cliente.get(i).toString() + "\n");
		}

	}

	public void buscarporID() {

	}

}
