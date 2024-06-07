package com.nicolas.agenda.gerenciador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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

	public static void lerArq() {
		
		String dados;
		try {
			dados = new String(Files.readAllBytes(new File("C:\\Users\\DEV\\Documents\\arq_agenda\\Lista_agenda.csv").toPath()));
			System.out.println(dados);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
