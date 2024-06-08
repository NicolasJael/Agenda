package com.nicolas.agenda.gerenciador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.nicolas.agenda.domain.Contato;

public class GerenciadorCont {

	private static List<Contato> contatos = new ArrayList<>();
	private static int codigo = 1;

	public static void add(Contato contato) {

		contato.setCodigo(codigo++);
		contatos.add(contato);
	}

	public static void lerArq() throws IOException {

		BufferedReader br = new BufferedReader(
				new FileReader("C:\\Users\\DEV\\Documents\\arq_agenda\\Lista_agenda.csv"));
		String linha = br.readLine();
		linha = br.readLine();
		while (linha != null) {
			String[] linhaArr = linha.split(";");

			Contato contato = new Contato();
			contato.setCodigo(Integer.parseInt(linhaArr[0]));
			contato.setNome(linhaArr[1]);
			contato.setTelefone(linhaArr[2]);

			contatos.add(contato);
			linha = br.readLine();
		}

		br.close();
	}

	public static void gravar() throws IOException {

		FileWriter arq = new FileWriter("C:\\Users\\DEV\\Documents\\arq_agenda\\Lista_agenda.csv");
		try (PrintWriter gravarArq = new PrintWriter(arq)) {
			gravarArq.printf("codigo;nome;Telefone%n");
			for (Contato contato : contatos) {
				gravarArq.printf("%d;%s;%s%n", contato.getCodigo(), contato.getNome(), contato.getTelefone());
			}
		}
		arq.close();
		System.out.println("Salvo com sucesso!");
	}

	public static List<Contato> getContatos() {

		return contatos;
	}

	public static Contato getContato(int codigo) {

		for (Contato contato : contatos) {
			if (contato.getCodigo() == codigo) {
				return contato;
			}
		}

		return null;
	}

	public static void apagar(Contato contato) {

		contatos.remove(codigo);
	}

	public static void alterar(Contato contato) {

	}

}
