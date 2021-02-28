package br.com.proway.application;

import br.com.proway.service.CoffeeService;

public class Main {

	public static void main(String[] args) {
		boolean shouldContinue = true;
		CoffeeService coffeeService = new CoffeeService();
		AppUI appUI = new AppUI(coffeeService);
		System.out.println("Bem vindo ao programa de treinamentos da ProWay!");
		while (shouldContinue) {
			AppUI.printMenu();
			String option = AppUI.readString();
			shouldContinue = appUI.chooseOption(option);
		}
	}
}
