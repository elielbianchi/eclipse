package br.com.proway.domain;

public class Person {
	private String firstName;
	private String lastName;
	private String roomFirstStage;
	private String roomSecondStage;
	private String coffeeFirstStage;
	private String coffeeSecondStage;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.roomFirstStage = "Não atribuída";
		this.roomSecondStage = "Não atribuída";
		this.coffeeFirstStage = "Não atribuído";
		this.coffeeSecondStage = "Não atribuído";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRoomFirstStage() {
		/**
		 * It returns the room that a person goes attend on the first stage of training.
		 */
		return roomFirstStage;
	}

	public void setRoomFirstStage(String roomFirstStage) {
		/**
		 * It sets the room that a person goes attend on the first stage of training.
		 */
		this.roomFirstStage = roomFirstStage;
	}

	public String getRoomSecondStage() {
		/**
		 * It returns the room that a person goes attend on the second stage of
		 * training.
		 */
		return roomSecondStage;
	}

	public void setRoomSecondStage(String roomSecondStage) {
		/**
		 * It sets the room that a person goes attend on the second stage of training.
		 */
		this.roomSecondStage = roomSecondStage;
	}

	public String getCoffeeFirstStage() {
		/**
		 * It returns the coffee space that a person goes attend on the first stage of
		 * training.
		 */
		return coffeeFirstStage;
	}

	public void setCoffeeFirstStage(String coffeeFirstStage) {
		/**
		 * It sets the coffee space that a person goes attend on the first stage of
		 * training.
		 */
		this.coffeeFirstStage = coffeeFirstStage;
	}

	public String getCoffeeSecondStage() {
		/**
		 * It returns the coffee space that a person goes attend on the second stage of
		 * training.
		 */
		return coffeeSecondStage;
	}

	public void setCoffeeSecondStage(String coffeeSecondStage) {
		/**
		 * It sets the coffee space that a person goes attend on the second stage of
		 * training.
		 */
		this.coffeeSecondStage = coffeeSecondStage;
	}

	public String fullName(Person person) {
		/**
		 * Method to receive the attributes firstName and lastName, using the getters
		 * from Person class, and returning them as a unique String.
		 */
		return person.getFirstName() + " " + person.getLastName();
	}
}
