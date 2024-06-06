package com.nicolas.agenda.gerenciador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nicolas.agenda.domain.Contato;

public class GerenciadorCont {

	private static Scanner scanner;
	private static List<Contato> contatos = new ArrayList<>();
	private static int codigo = 1;

	public GerenciadorCont(Scanner scanner) {
		
		GerenciadorCont.scanner = scanner;
		inicializar();
	}

	private void inicializar() {
		
		contatos.add(new Contato("Nicolas", getCod(), "99988445621"));
		contatos.add(new Contato("Felipe", getCod(), "9984457132"));
		contatos.add(new Contato("Dyogo", getCod(), "99995858"));
	}

	private static int getCod() {
		
		return codigo++;
	}

	public void listarContatos() {
		
		System.out.println("Os contatos adicionados foram:");
		for (Contato contato : contatos) {
			System.out.println(" - Cod:  " + contato.getCodigo() + " - Nome: " + contato.getNome() + " - Telefone: "
					+ contato.getTelefone());
		}
	}

	public void criaContato() {
		
		Contato contato = new Contato();
		System.out.print("Qual o nome do contato? ");
		String nomeCont = scanner.nextLine();
		System.out.print("Qual é o número de telefone do contato? ");
		String numCont = scanner.nextLine();

		contato.setNome(nomeCont);
		contato.setTelefone(numCont);
		contato.setCodigo(getCod());
		contatos.add(contato);
	}

	public void alterarContato() {
		
		listarContatos();
		System.out.print("Qual é o código do contato a ser alterado?");
		int alterarCont = Integer.parseInt(scanner.nextLine());

		Contato contato = null;
		for (Contato c : contatos) {
			if (c.getCodigo() == alterarCont) {
				contato = c;
				break;
			}
		}
		if (contato != null) {
			System.out.print("Digite o novo nome do contato:");
			contato.setNome(scanner.nextLine());
			System.out.print("Digite o novo número de telefone:");
			contato.setTelefone(scanner.nextLine());
			System.out.println("Contato alterado com sucesso!");
		} else {
			System.out.println("Contato não encontrado :(");
		}
	}

	public void apagaContato() {

		listarContatos();
		System.out.print("Digite o código a ser apagado:");
		int apagarCont = Integer.parseInt(scanner.nextLine());

		Contato contato = null;
		for (Contato c : contatos) {
			if (c.getCodigo() == apagarCont) {
				contato = c;
				break;
			}
		}
		if (contato != null) {
			contatos.remove(contato);
			System.out.println("Contato apagado com sucesso!");
		} else {
			System.out.println("Contato não encontrado :(");
		}
	}

	public void gravar() throws IOException {

		FileWriter arq = new FileWriter("C:\\Users\\DEV\\Documents\\arq_agenda\\Lista_agenda.csv");
		listarContatos();
		try (PrintWriter gravarArq = new PrintWriter(arq)) {
			gravarArq.printf("codigo;nome;Telefone%n");
			for (Contato contato : contatos) {
				gravarArq.printf("%d;%s;%s%n", contato.getCodigo(), contato.getNome(), contato.getTelefone());
			}
		}
		arq.close();
		System.out.println("Salvo com sucesso!");
	}
}
