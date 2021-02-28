package br.com.proway.application;

public class Main {

	public static void main(String[] args) {
		boolean shouldContinue = true;
		System.out.println("Bem vindo ao programa de treinamentos da ProWay!");
		while (shouldContinue) {
			AppSupport.printMenu();
			String option = AppSupport.readString();
			shouldContinue = AppSupport.chooseOption(option);
		}
	}
}
