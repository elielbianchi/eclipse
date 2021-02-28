package br.com.proway.service;

import java.util.ArrayList;
import br.com.proway.domain.Person;

public class PersonService {

	private ArrayList<Person> people = new ArrayList<Person>();

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<Person> people) {
		this.people = people;
	}

	public void addPersonService(String firstName, String lastName) {
		Person person = new Person(firstName, lastName);
		people.add(person);
	}
}
