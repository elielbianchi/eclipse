package br.com.proway.service;

import java.util.ArrayList;
import br.com.proway.domain.Coffee;
import br.com.proway.domain.Person;

public class CoffeeService {

	private ArrayList<Coffee> coffees = new ArrayList<Coffee>();

	public ArrayList<Coffee> getCoffees() {
		return coffees;
	}

	public void setCoffees(ArrayList<Coffee> coffees) {
		this.coffees = coffees;
	}

	public void addCoffeeService(String name, int capacity) {
		Coffee coffee = new Coffee(name, capacity);
		coffees.add(coffee);
	}

	public void assignCoffee(Person person, int counter) {
		/**
		 * This method is called the assingPeople method. It receives the counter and
		 * each person's object from the previous method. This method is used to assign
		 * the people to one of the two Coffee Spaces, placing each time one person in
		 * each space.
		 */
		int nCoffees = counter % 2;
		person.setCoffeeFirstStage(getCoffees().get(nCoffees).getName());
		getCoffees().get(nCoffees).setFirstStage(person.fullName(person));
		person.setCoffeeSecondStage(getCoffees().get(nCoffees).getName());
		getCoffees().get(nCoffees).setSecondStage(person.fullName(person));
	}
}
