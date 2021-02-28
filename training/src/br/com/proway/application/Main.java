package br.com.proway.application;

import br.com.proway.service.*;

public class Main {

	public static void main(String[] args) {
		boolean shouldContinue = true;
		CoffeeService coffeeService = new CoffeeService();
		PersonService personService = new PersonService();
		RoomService roomService = new RoomService();
		AppUI appUI = new AppUI(coffeeService, personService, roomService);
		System.out.println("Bem vindo ao programa de treinamentos da ProWay!");
		while (shouldContinue) {
			AppUI.printMenu();
			String option = AppUI.readString();
			shouldContinue = appUI.chooseOption(option);
		}
	}
}
