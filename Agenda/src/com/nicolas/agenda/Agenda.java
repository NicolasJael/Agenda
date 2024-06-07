package com.nicolas.agenda;

import java.io.IOException;

import com.nicolas.agenda.gerenciador.GerenciadorCont;
import com.nicolas.agenda.ui.Menu;

public class Agenda {

	public static void main(String[] args) throws IOException {

		GerenciadorCont.lerArq();
		Menu menu = new Menu();
		menu.exibir();
	}
}
