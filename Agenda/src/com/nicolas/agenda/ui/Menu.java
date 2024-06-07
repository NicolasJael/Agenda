package com.nicolas.agenda.ui;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.nicolas.agenda.domain.Contato;
import com.nicolas.agenda.gerenciador.GerenciadorCont;

public class Menu {

	private Scanner scanner = new Scanner(System.in);

	public void exibir() throws IOException {

		for (;;) {
			System.out.println("---------------------");
			System.out.println("1 - Exibir lista antiga");
			System.out.println("2 - Listar");
			System.out.println("3 - Incluir");
			System.out.println("4 - Alterar");
			System.out.println("5 - Apagar");
			System.out.println("6 - Salvar");
			System.out.println("7 - Sair");
			System.out.print("Escolha uma opção: ");

			int opcao = scanner.nextInt();
			scanner.nextLine();
			switch (opcao) {
			case 1:
				GerenciadorCont.lerArq();
				break;
			case 2:
				listarContatos();
				break;
			case 3:
				criaContato();
				break;
			case 4:
				alterarContato();
				break;
			case 5:
				apagaContato();
				break;
			case 6:
				GerenciadorCont.gravar();
				break;
			case 7:
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida");
			}
		}
	}

	public void listarContatos() {

		List<Contato> contatos = GerenciadorCont.getContatos();

		System.out.println("Os contatos adicionados foram:");
		for (Contato contato : contatos) {
			System.out.println(" - Cod:  " + contato.getCodigo() + " - Nome: " + contato.getNome() + " - Telefone: "
					+ contato.getTelefone());
		}
	}

	public void criaContato() {

		System.out.print("Qual o nome do contato? ");
		String nomeCont = scanner.nextLine();
		System.out.print("Qual é o número de telefone do contato? ");
		String numCont = scanner.nextLine();

		Contato contato = new Contato();
		contato.setNome(nomeCont);
		contato.setTelefone(numCont);
		GerenciadorCont.add(contato);
	}

	public void alterarContato() {

		listarContatos();
		System.out.print("Qual é o código do contato a ser alterado: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		Contato contato = GerenciadorCont.getContato(codigo);

		if (contato != null) {
			System.out.print("Digite o novo nome do contato:");
			contato.setNome(scanner.nextLine());
			System.out.print("Digite o novo número de telefone:");
			contato.setTelefone(scanner.nextLine());
			System.out.println("Contato alterado com sucesso!");
		} else {
			System.out.println("codigo nao encontrado");
		}

		GerenciadorCont.alterar(contato);
	}

	public void apagaContato() {

		listarContatos();
		System.out.print("Digite o código a ser apagado: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		Contato contato = GerenciadorCont.getContato(codigo);
		GerenciadorCont.apagar(contato);
	}
}