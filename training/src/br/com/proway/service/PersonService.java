package br.com.proway.service;

import java.util.ArrayList;
import br.com.proway.domain.Person;

public class PersonService {
	/**
	 * The purpose of this class is to serve the AppUI class from application path
	 * with specific methods using the Person class from domain path. It creates the
	 * ArrayList to keep the people added.
	 */

	private ArrayList<Person> people = new ArrayList<Person>();

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public void addPersonService(String firstName, String lastName) {
		/**
		 * This method is called by the addPerson from AppUI class, and it receives the
		 * first name and last name parameters and creates a Person object at ArrayList.
		 */
		Person person = new Person(firstName, lastName);
		people.add(person);
	}
}
