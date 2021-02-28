package br.com.proway.application;

import java.util.Scanner;

import br.com.proway.domain.*;
import br.com.proway.service.*;

public class AppUI {
	/**
	 * This class has every support method needed to execute and manipulate the
	 * objects from classes at service and domain paths, in order to perform the
	 * training application. For that, it initializes objects of the classes from
	 * the service path. In this way, the Main class can construct the AppUI object
	 * that is used to work with all methods from this project. Also, it creates the
	 * Scanner variable used in the methods to get input from the user. In order to
	 * be used in Brazil, by everyone, the messages printed to the user were written
	 * in Portuguese.
	 * 
	 * @author Eliel Bianchi
	 * @version 1.0
	 */
	private RoomService roomService;
	private CoffeeService coffeeService;
	private PersonService personService;
	static Scanner sc = new Scanner(System.in);

	public AppUI(CoffeeService coffeeService, PersonService personService, RoomService roomService) {
		this.coffeeService = coffeeService;
		this.personService = personService;
		this.roomService = roomService;
	}

	public static void printMenu() {
		/**
		 * This method prints the initial menu to the user. The user has to press the
		 * button relative to the option number and press the 'Enter' button.
		 */
		System.out.println("");
		System.out.println("Escolha a opção listada abaixo que deseja realizar e pressione o número correspondente.");
		System.out.println("Pressione '1' para adicionar uma nova pessoa.");
		System.out.println("Pressione '2' para adicionar uma nova sala de treinamento.");
		System.out.println("Pressione '3' para adicionar um novo espaço de café.");
		System.out.println(
				"Pressione '4' para realizar a distribuição ou redistribuição de salas e espaços para pessoas já cadastradas.");
		System.out.println("Pressione '5' para consultar uma pessoa já cadastrada.");
		System.out.println("Pressione '6' para consultar uma sala de treinamento já cadastrada.");
		System.out.println("Pressione '7' para consultar um espaço de café já cadastrado.");
		System.out.println("Pressione '8' para visualizar as listas de pessoas, salas e espaços cadastrados.");
		System.out.println("Pressione '9' para deletar uma pessoa, sala ou espaço já cadastrados.");
		System.out.println("Pressione '0' para encerrar o programa.");
		System.out.print("Opção escolhida: ");
	}

	public static String readString() {
		/**
		 * Method to receive the input from the user and return the typed String.
		 */
		String read = sc.nextLine();
		return read;
	}

	public static int readInt() {
		/**
		 * Method to receive the input from the user and return the typed Integer.
		 */
		int read = sc.nextInt();
		sc.nextLine();
		return read;
	}

	public boolean chooseOption(String option) {
		/**
		 * A boolean method used to check if the user wants to close the program or
		 * continue performing actions. The actions match with the numbers from the
		 * printMenu method. Each case, based on the choice, calls different methods to
		 * perform the desired actions.
		 */
		switch (option) {
		case "1":
			System.out.println("");
			addPerson();
			return true;
		case "2":
			System.out.println("");
			addRoom();
			return true;
		case "3":
			System.out.println("");
			addCoffee();
			return true;
		case "4":
			System.out.println("");
			checkCapacity();
			return true;
		case "5":
			System.out.println("");
			personQuery();
			return true;
		case "6":
			System.out.println("");
			roomQuery();
			return true;
		case "7":
			System.out.println("");
			coffeeQuery();
			return true;
		case "8":
			System.out.println("");
			printAllObjects();
			return true;
		case "9":
			System.out.println("");
			deleteMenu();
			return true;
		case "0":
			System.out.println("");
			System.out.println("Conforme selecionado, encerrando aplicação.");
			System.out.println("Pressione a tecla 'Enter' para finalizar.");
			readString();
			return false;
		default:
			System.out.println("");
			System.out.println("Opção inválida, favor inserir apenas o número, válido, da opção de acordo com o menu.");
			return true;
		}
	}

	public void addPerson() {
		/**
		 * This method is called by the chooseOption method. It asks the user for the
		 * inputs to the constructor of the class Person. Lastly, it calls the method
		 * addPersonService from PersonService class.
		 */
		System.out.println("Insira o primeiro nome da pessoa a ser adicionada.");
		System.out.print("Nome: ");
		String firstName = readString();
		System.out.println("Insira o sobrenome da pessoa a ser adicionada: ");
		System.out.print("Sobrenome: ");
		String lastName = readString();
		personService.addPersonService(firstName, lastName);
	}

	public void addRoom() {
		/**
		 * This method is called by the chooseOption method. It asks the user for the
		 * inputs to the constructor of the class Room. Lastly, it calls the method
		 * addRoomService from RoomService class.
		 */
		System.out.println("Insira o nome da sala de treinamento a ser adicionada.");
		System.out.print("Nome: ");
		String name = readString();
		System.out.println("Insira a capacidade da sala de treinamento a ser adicionada.");
		System.out.print("Capacidade: ");
		int capacity = readInt();
		roomService.addRoomService(name, capacity);
	}

	public void addCoffee() {
		/**
		 * This method is called by the chooseOption method. It asks the user for the
		 * inputs to the constructor of the class Coffee. Lastly, it calls the method
		 * addCoffeeService from CoffeeService class.
		 */
		if (coffeeService.getCoffees().size() < 2) {
			System.out.println("Lembre-se que você deve inserir dois espaços no total.");
			System.out.println("Insira o nome do espaço de café a ser adicionado.");
			System.out.print("Nome: ");
			String name = readString();
			System.out.println("Insira a capacidade do espaço de café a ser adicionado.");
			System.out.print("Capacidade: ");
			int capacity = readInt();
			coffeeService.addCoffeeService(name, capacity);
		} else {
			System.out.println("São necessários dois espaços de café e você já inseriu os dois.");
			System.out.println("Pressione a tecla 'Enter' para retornar ao Menu.");
			readString();
		}
	}

	public void checkCapacity() {
		/**
		 * This method is called by the chooseOption method. It executes some logical
		 * blocks based on the current data received. These verifications are useful to
		 * prevent executing the assignPeople with no people or no enough capacity at
		 * the rooms or spaces. If the data are right, this method executes the
		 * assignPeople method.
		 */
		int nPeople = personService.getPeople().size();
		int roomsCapacity = 0;
		int coffeesCapacity = 0;
		for (Room room : roomService.getRooms()) {
			roomsCapacity = roomsCapacity + room.getCapacity();
		}
		for (Coffee coffee : coffeeService.getCoffees()) {
			coffeesCapacity = coffeesCapacity + coffee.getCapacity();
		}
		if (nPeople == 0) {
			System.out.println("Você ainda não cadastrou nenhuma pessoa.");
			System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
			readString();
		} else if (coffeesCapacity >= nPeople && roomsCapacity >= nPeople) {
			assignPeople();
		} else {
			System.out.println("");
			System.out.println(
					"Você deve ter cadastrados salas de treinamento e espaços de intervalo suficientes para comportar "
							+ "as pessoas atualmente cadastradas.");
			System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
			readString();
		}
	}

	public void assignPeople() {
		/**
		 * This method is called by the checkCapacity method. Using some counter
		 * variables, it takes each Person object at the people ArrayList and places
		 * each 'round' one person in each room for the First Stage. After that, the
		 * method calls the roomChangeRules and the assignCoffee methods.
		 */
		int roomsSize = roomService.getRooms().size();
		int counter = 0;
		int nRooms = 0;
		int round = 0;
		int inverter = 0;
		for (Person person : personService.getPeople()) {
			nRooms = counter % roomsSize;
			round = counter / roomsSize;
			inverter = roomsSize - nRooms - 1;
			roomService.getRooms().get(nRooms).setFirstStage(person.fullName(person));
			person.setRoomFirstStage(roomService.getRooms().get(nRooms).getName());
			roomService.roomChangeRules(person, round, nRooms, inverter);
			coffeeService.assignCoffee(person, counter);
			counter++;
		}
		System.out.println("");
		System.out.println("Você atribuiu as pessoas às salas e espaços com sucesso.");
		System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
		readString();
	}

	public void personQuery() {
		/**
		 * This method is called by the chooseOption method. This method is used to
		 * receive the arguments from user input and calls a method to perform the
		 * search of person full name.
		 */
		System.out.println("Informe o primeiro nome da pessoa a ser consultada.");
		System.out.print("Nome: ");
		String firstName = readString();
		System.out.println("Informe o sobrenome da pessoa a ser consultada.");
		System.out.print("Sobrenome: ");
		String lastName = readString();
		personSearch(firstName, lastName);
	}

	public void personSearch(String firstName, String lastName) {
		/**
		 * This method is called by personQuery method, and search object by object at
		 * ArrayList people from PersonService class. If the search matches with the
		 * people data, so the person information is printed. In case that the search
		 * does not match, the method returns the message that no person was found.
		 */
		boolean find = false;
		for (Person person : personService.getPeople()) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				find = true;
				System.out.println("");
				System.out.println("Nome: " + person.getFirstName() + ".");
				System.out.println("Sobrenome: " + person.getLastName() + ".");
				System.out.println("Sala da primeira etapa do evento: " + person.getRoomFirstStage() + ".");
				System.out.println("Sala da segunda etapa do evento: " + person.getRoomSecondStage() + ".");
				System.out.println("Espaço do primeiro intervalo: " + person.getCoffeeFirstStage() + ".");
				System.out.println("Espaço do segundo intervalo: " + person.getCoffeeSecondStage() + ".");
				System.out.println("");
				System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
				readString();
				break;
			}
		}
		if (!find) {
			System.out.println("");
			System.out.println("Não encontrei o nome informado no cadastro de pessoas.");
			System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
			readString();
		}
	}

	public void roomQuery() {
		/**
		 * This method is called by the chooseOption method. This method is used to
		 * receive the arguments from user input and calls a method to perform the
		 * search of room name.
		 */
		System.out.println("Informe o nome da sala a ser consultada.");
		System.out.print("Nome: ");
		String name = readString();
		roomSearch(name);
	}

	public void roomSearch(String name) {
		/**
		 * This method is called by roomQuery method, and search object by object at
		 * ArrayList rooms from RoomService class. If the search matches with the rooms
		 * data, so the room information is printed. In case that the search does not
		 * match, the method returns the message that no room was found.
		 */
		boolean find = false;
		for (Room room : roomService.getRooms()) {
			if (room.getName().equals(name)) {
				find = true;
				System.out.println("");
				System.out.println("Nome da sala: " + room.getName() + ".");
				System.out.println("Capacidade da sala: " + room.getCapacity() + ".");
				System.out.println("Lista de pessoas da primeira etapa:");
				for (int i = 0; i < room.getFirstStage().size(); i++) {
					System.out.println((i + 1) + ") " + room.getFirstStage().get(i) + ".");
				}
				System.out.println("Lista de pessoas da segunda etapa:");
				for (int i = 0; i < room.getSecondStage().size(); i++) {
					System.out.println((i + 1) + ") " + room.getSecondStage().get(i) + ".");
				}
				System.out.println("");
				System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
				readString();
				break;
			} else {
				continue;
			}
		}
		if (!find) {
			System.out.println("");
			System.out.println("Não encontrei o nome informado no cadastro de salas de treinamento.");
			System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
			readString();
		}
	}

	public void coffeeQuery() {
		/**
		 * This method is called by the chooseOption method. This method is used to
		 * receive the arguments from user input and calls a method to perform the
		 * search of coffee space name.
		 */
		System.out.println("Informe o nome do espaço de intervalo a ser consultado.");
		System.out.print("Nome: ");
		String name = readString();
		coffeeSearch(name);
	}

	public void coffeeSearch(String name) {
		/**
		 * This method is called by coffeeQuery method, and search object by object at
		 * ArrayList coffees from CoffeeService class. If the search matches with the
		 * coffee spaces data, so the coffee space information is printed. In case that
		 * the search does not match, the method returns the message that no coffee
		 * space was found.
		 */
		boolean find = false;
		for (Coffee coffee : coffeeService.getCoffees()) {
			if (coffee.getName().equals(name)) {
				find = true;
				System.out.println("");
				System.out.println("Nome do espaço: " + coffee.getName() + ".");
				System.out.println("Capacidade do espaço: " + coffee.getCapacity() + ".");
				System.out.println("Lista de pessoas do primeiro intervalo:");
				for (int i = 0; i < coffee.getFirstStage().size(); i++) {
					System.out.println((i + 1) + ") " + coffee.getFirstStage().get(i) + ".");
				}
				System.out.println("Lista de pessoas do segundo intervalo:");
				for (int i = 0; i < coffee.getSecondStage().size(); i++) {
					System.out.println((i + 1) + ") " + coffee.getSecondStage().get(i) + ".");
				}
				System.out.println("");
				System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
				readString();
				break;
			} else {
				continue;
			}
		}
		if (!find) {
			System.out.println("");
			System.out.println("Não encontrei o nome informado no cadastro de espaços de intervalo.");
			System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
			readString();
		}
	}

	public void printAllObjects() {
		/**
		 * This method is called by the chooseOption method. It prints out all the
		 * people, rooms, and coffee spaces already added. It goes object by object at
		 * each ArrayList and shows in a formatted way the names. For rooms and coffee
		 * spaces, it also shows the capacity.
		 */
		int pos = 1;
		System.out.println("Lista de pessoas cadastradas:");
		for (Person person : personService.getPeople()) {
			System.out.println(pos + "- " + person.fullName(person) + ".");
			pos++;
		}
		pos = 1;
		System.out.println("Lista de salas de treinamento cadastradas:");
		for (Room room : roomService.getRooms()) {
			System.out.println(pos + "- " + room.getName() + ". Capacidade: " + room.getCapacity() + ".");
			pos++;
		}

		pos = 1;
		System.out.println("Lista de espaços de intervalo cadastrados:");
		for (Coffee coffee : coffeeService.getCoffees()) {
			System.out.println(pos + "- " + coffee.getName() + ". Capacidade: " + coffee.getCapacity() + ".");
			pos++;
		}
		System.out.println("");
		System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
		readString();
	}

	public void deleteMenu() {
		/**
		 * This method is called by the chooseOption method. It shows the option to
		 * delete the objects from the lists of people, rooms, and coffee spaces. After
		 * the read input from the user, the method calls another method to uses the
		 * read choice.
		 */
		System.out.println("Para deletar uma pessoa cadastrada, pressione '1'.");
		System.out.println("Para deletar uma sala de treinamento cadastrada, pressione '2'.");
		System.out.println("Para deletar uma sala de café cadastrada, pressione '3'.");
		System.out.print("Opção escolhida: ");
		String choice = readString();
		deleteChoice(choice);

	}

	public void deleteChoice(String choice) {
		/**
		 * This method is called by the deleteMenu method, using the choice read. The
		 * method compares the option typed by the user, and performs the desired
		 * method. If the entry is not valid, the user is informed and the program goes
		 * back to the main printMenu.
		 */
		switch (choice) {
		case "1":
			System.out.println("");
			deletePerson();
			break;
		case "2":
			System.out.println("");
			deleteRoom();
			break;
		case "3":
			System.out.println("");
			deleteCoffee();
			break;
		default:
			System.out.println("");
			System.out.println(
					"Opção inválida, favor inserir apenas o número, válido, da opção de acordo com o menu anterior.");
			System.out.println("Retornando ao menu principal.");
			break;
		}
	}

	public void deletePerson() {
		/**
		 * This method is called by the deleteChoice menu. It deletes the person desired
		 * if the person is on the database. For that, the method receives the input
		 * from the user, and search object by object at people ArrayList from
		 * PersonService. When the person is found, the method erases the person from
		 * the list. In case that the name is not found, a message is informed to the
		 * user and the program goes back to the main printMenu.
		 */
		System.out.println("Informe o primeiro nome da pessoa a ser deletada.");
		System.out.print("Nome: ");
		String firstName = readString();
		System.out.println("Informe o sobrenome da pessoa a ser deletada.");
		System.out.print("Sobrenome: ");
		String lastName = readString();
		for (Person person : personService.getPeople()) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				System.out.println("");
				System.out.println("Deletando o cadastro de " + person.fullName(person));
				personService.getPeople().remove(person);
				System.out.println("");
				System.out.println(
						"Por ter deletado uma pessoa, caso já tenha feito a distruição de salas, deverá repetir a ação.");
				System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
				readString();
				break;
			} else {
				continue;
			}
		}
	}

	public void deleteRoom() {
		/**
		 * This method is called by the deleteChoice menu. It deletes the room desired
		 * if the room is on the database. For that, the method receives the input from
		 * the user, and search object by object at rooms ArrayList from RoomService.
		 * When the room is found, the method erases the rooms from the list. In case
		 * that the name is not found, a message is informed to the user and the program
		 * goes back to the main printMenu.
		 */
		System.out.println("Informe o nome da sala de treinamento a ser deletada.");
		System.out.print("Nome: ");
		String name = readString();
		for (Room room : roomService.getRooms()) {
			if (room.getName().equals(name)) {
				System.out.println("");
				System.out.println("Deletando o cadastro da sala " + room.getName());
				roomService.getRooms().remove(room);
				System.out.println("");
				System.out.println(
						"Por ter deletado uma sala, caso já tenha feito a distruição de salas, deverá repetir a ação.");
				System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
				readString();
				break;
			} else {
				continue;
			}
		}
	}

	public void deleteCoffee() {
		/**
		 * This method is called by the deleteChoice menu. It deletes the coffee space
		 * desired if the space is on the database. For that, the method receives the
		 * input from the user, and search object by object at coffees ArrayList from
		 * CoffeeService. When the coffee space is found, the method erases the spaces
		 * from the list. In case that the name is not found, a message is informed to
		 * the user and the program goes back to the main printMenu.
		 */
		System.out.println("Informe o nome do espaço de intervalo a ser deletado.");
		System.out.print("Nome: ");
		String name = readString();
		for (Coffee coffee : coffeeService.getCoffees()) {
			if (coffee.getName().equals(name)) {
				System.out.println("");
				System.out.println("Deletando o cadastro do espaço " + coffee.getName());
				coffeeService.getCoffees().remove(coffee);
				System.out.println("");
				System.out.println(
						"Por ter deletado um espaço de intervalo, caso já tenha feito a distruição de salas, deverá repetir a ação.");
				System.out.println("Pressione a tecla 'Enter' para voltar ao menu.");
				readString();
				break;
			} else {
				continue;
			}
		}
	}
}
