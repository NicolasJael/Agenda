package com.nicolas.agenda.ui;

import java.util.Scanner;

public class Menu {

	public static int menu(Scanner scanner) {

		System.out.println("---------------------");
		System.out.println("1 - Listar");
		System.out.println("2 - Incluir");
		System.out.println("3 - Alterar");
		System.out.println("4 - Apagar");
		System.out.println("5 - Salvar");
		System.out.println("6 - Sair");
		System.out.print("Escolha uma opção: ");

		int opcao = scanner.nextInt();
		scanner.nextLine();
		return opcao;
	}

}