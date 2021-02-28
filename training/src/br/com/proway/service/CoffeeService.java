package br.com.proway.service;

import java.util.ArrayList;
import br.com.proway.domain.Coffee;
import br.com.proway.domain.Person;

public class CoffeeService {
	/**
	 * The purpose of this class is to serve the AppUI class from application path
	 * with specific methods using the Coffee class from domain path. It creates the
	 * ArrayList to keep the coffee spaces added.
	 */

	private ArrayList<Coffee> coffees = new ArrayList<Coffee>();

	public ArrayList<Coffee> getCoffees() {
		return coffees;
	}

	public void setCoffees(ArrayList<Coffee> coffees) {
		this.coffees = coffees;
	}

	public void addCoffeeService(String name, int capacity) {
		/**
		 * This method is called by the addCoffee from AppUI class, and it receives the
		 * name and capacity parameters and creates a Coffee object at ArrayList.
		 */
		Coffee coffee = new Coffee(name, capacity);
		coffees.add(coffee);
	}

	public void assignCoffee(Person person, int counter) {
		/**
		 * This method is called by the assingPeople method from AppUI. It receives the
		 * counter and each person's object from the previous method. This method is
		 * used to assign the people to one of the two Coffee Spaces, placing each time
		 * one person in each space.
		 */
		int nCoffees = counter % 2;
		person.setCoffeeFirstStage(getCoffees().get(nCoffees).getName());
		getCoffees().get(nCoffees).setFirstStage(person.fullName(person));
		person.setCoffeeSecondStage(getCoffees().get(nCoffees).getName());
		getCoffees().get(nCoffees).setSecondStage(person.fullName(person));
	}
}
