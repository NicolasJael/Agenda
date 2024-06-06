package com.nicolas.agenda;

import java.io.IOException;
import java.util.Scanner;

import com.nicolas.agenda.gerenciador.GerenciadorCont;
import com.nicolas.agenda.ui.Menu;

public class Agenda {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		GerenciadorCont gerenciador = new GerenciadorCont(scanner);

		while (true) {
			int opcao = Menu.menu(scanner);
			switch (opcao) {
			case 1:
				gerenciador.listarContatos();
				break;
			case 2:
				gerenciador.criaContato();
				break;
			case 3:
				gerenciador.alterarContato();
				break;
			case 4:
				gerenciador.apagaContato();
				break;
			case 5:
				gerenciador.gravar();
				break;
			case 6:
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Opção inválida");
			}
		}
	}
}
