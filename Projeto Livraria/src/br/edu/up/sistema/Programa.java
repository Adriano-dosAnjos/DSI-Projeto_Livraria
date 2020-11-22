package br.edu.up.sistema;

import java.util.List;
import java.util.Scanner;

import br.edu.up.dao.ClienteDAO;
import br.edu.up.dao.ItemDAO;
import br.edu.up.model.Cliente;
import br.edu.up.model.Item;

public class Programa {

	public static void main(String[] args) throws Exception {
		Scanner leitor = new Scanner (System.in);
		
		int opcao = 0, repetir = 0 ;
		int id;
		String nome, sobrenome, cpf, data, email;
		
		do {
			System.out.println ("\t\t MENU: \n");
			System.out.println ("\tOpção 1 - Cliente >>");
			System.out.println ("\tOpção 2 - Administrativo >>");
			System.out.println ("");
			System.out.println ("\tOpção 5 - Sair");
			System.out.println ("\tDigite a opção desejada:");
				opcao = leitor.nextInt();
			
			switch (opcao) {
			case 1:
				do {
					System.out.println ("---------- PERFIL CLIENTE ----------\n");
					System.out.println ("\t\t MENU: \n");
					System.out.println ("Opção 1 - Criar uma Conta");
					System.out.println ("Opção 2 - Vizualizar produtos");
					System.out.println ("");
					System.out.println ("Opção 3 - Voltar");
					System.out.println ("Digite a opção desejada:");
						opcao = leitor.nextInt();
					
					switch (opcao) {
					case 1:
						do {
							System.out.println ("Preencha as informações solicitadas:\n");
							
							System.out.println ("Nome: ");
								nome = leitor.next();
							System.out.println ("Sobrenome: ");
								sobrenome = leitor.next();
							System.out.println ("CPF: ");	
								cpf = leitor.next();
							System.out.println ("Data de Nascimento: (dd-mm-aaaa)");
								data = leitor.next();
							System.out.println ("e-mail");
								email = leitor.next();
								
							ItemDAO itemDAO = new ItemDAO();
							Item item = new Item(nome, sobrenome, cpf, data, email);
							itemDAO.incluir(item);
							
							System.out.println ("\nDigite '2' para voltar");
								repetir = leitor.nextInt();
							
						} while (repetir == 1);
						
						System.out.println ("\nDigite 3 para voltar ao MENU principal");
							opcao = leitor.nextInt();
						
						break;
					case 2:
						do {
							
							ItemDAO itemDAO = new ItemDAO();
							List<Item> listaDeItens = itemDAO.listar();
							
							for (Item item : listaDeItens) {
								System.out.println(item);
							}
							
							System.out.println ("\nDigite '2' para voltar");
								repetir = leitor.nextInt();
								
						} while (repetir == 1);
						
						System.out.println ("\nDigite 3 para voltar ao MENU principal");
							opcao = leitor.nextInt();
						
						break;
					default:
						System.out.println ("OPÇÃO INVALIDA! Digite novamente");
						break;
					
					}
						
				} while (opcao == 3);
				
				System.out.println ("\nDigite 3 para voltar ao MENU principal");
					opcao = leitor.nextInt();
				
				break;
			case 2:
				
				do {
					System.out.println ("---------- PERFIL ADMINITRATIVO ----------\n");
					System.out.println ("\tOpção 1 - Incluir");
					System.out.println ("\tOpção 2 - Listar");
					System.out.println ("\tOpção 3 - Atualizar");
					System.out.println ("\tOpção 4 - Excluir");
					System.out.println ("");
					System.out.println ("\tOpção 5 - Voltar");
					System.out.println ("\tDigite a opção desejada:");
						opcao = leitor.nextInt();
						
					switch (opcao) {
					case 1:
						do {
							System.out.println ("Preencha as informações solicitadas para adicionar um cliente ao cadastro:\n");
							
							System.out.println ("Nome: ");
								nome = leitor.next();
							System.out.println ("Sobrenome: ");
								sobrenome = leitor.next();
							System.out.println ("CPF: ");	
								cpf = leitor.next();
							System.out.println ("Data de Nascimento: (dd-mm-aaaa)");
								data = leitor.next();
							System.out.println ("e-mail");
								email = leitor.next();
							
							ClienteDAO clienteDAO = new ClienteDAO();
							Cliente cliente = new Cliente(nome, sobrenome, cpf, data, email);
							clienteDAO.incluir(cliente);
							
							System.out.println ("\nDeseja adicionar outro cliente?");
							System.out.println ("Digite: 1 para Sim ou 2 para Não");
								repetir = leitor.nextInt();
								
						} while (repetir == 1);
						
						System.out.println ("\nDigite 5 para voltar ao MENU principal");
							opcao = leitor.nextInt();
						
						break;
					case 2:
						do {
							
							ClienteDAO clienteDAO = new ClienteDAO();
							List<Cliente> listaDeClientes = clienteDAO.listar();
							
							for (Cliente cliente : listaDeClientes) {
								System.out.println (cliente);
							}
							
							System.out.println ("\nDeseja listar novamente?");
							System.out.println ("Digite: 1 para Sim ou 2 para Não");
								repetir = leitor.nextInt();
						
						} while (repetir == 1);
						
						System.out.println ("\nDigite 5 para voltar ao MENU principal");
							opcao = leitor.nextInt();
						
						break;
					case 3:
						do {
							
							System.out.println ("Atualizar informações cadastradas:\n");
							
							System.out.println ("Informe o id do cliente que deseja alterar: ");
								id = leitor.nextInt();
							
							System.out.println ("Confirme o nome: ");
								nome = leitor.next();
								
							System.out.println ("Confirme o sobrenome: ");
								sobrenome = leitor.next();
							
							System.out.println ("Confirme o CPF: ");
								cpf = leitor.next();
							
							System.out.println ("Confirme a data de nascimento: ");
								data = leitor.next();
								
							System.out.println ("Confirme o e-mail: ");
								email = leitor.next();
							
							ClienteDAO clienteDAO = new ClienteDAO();
							Cliente cliente = new Cliente(id, nome, sobrenome, cpf, data, email);
							clienteDAO.atualizar(cliente);
							
						
							System.out.println ("\nDeseja atualizar outro item?");
							System.out.println ("Digite: 1 para Sim ou 2 para Não");
								repetir = leitor.nextInt();
					
						} while (repetir == 1);
						
						System.out.println ("\nDigite 5 para voltar ao MENU principal");
							opcao = leitor.nextInt();
						
						break;
					case 4:
						do {
							System.out.println ("Excluir clientes do cadastro:\n");
							
							System.out.println ("Informe o codigo do cliente que deseja excluir: ");
								id = leitor.nextInt();
							
							ClienteDAO clienteDAO = new ClienteDAO();
							clienteDAO.excluir(id);
							
							System.out.println ("\nDeseja excluir outro item?");
							System.out.println ("Digite: 1 para Sim ou 2 para Não");
								repetir = leitor.nextInt();
					
						} while (repetir == 1);
						
						System.out.println ("\nDigite 5 para voltar ao MENU principal");
						opcao = leitor.nextInt();
						
						
						break;
					default:
						System.out.println ("OPÇÃO INVALIDA! Digite novamente");
						break;
					}
					
				} while (opcao == 5);
				
				break;
				
			default:
				System.out.println ("OPÇÃO INVALIDA! Digite novamente");
				break;
			}
				
		} while (opcao == 3);
		
	}
	
}
