package br.com.proway.services;

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
		this.roomFirstStage = "N�o atribu�da";
		this.roomSecondStage = "N�o atribu�da";
		this.coffeeFirstStage = "N�o atribu�do";
		this.coffeeSecondStage = "N�o atribu�do";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRoomFirstStage() {
		return roomFirstStage;
	}

	public void setRoomFirstStage(String roomFirstStage) {
		this.roomFirstStage = roomFirstStage;
	}

	public String getRoomSecondStage() {
		return roomSecondStage;
	}

	public void setRoomSecondStage(String roomSecondStage) {
		this.roomSecondStage = roomSecondStage;
	}

	public String getCoffeeFirstStage() {
		return coffeeFirstStage;
	}

	public void setCoffeeFirstStage(String coffeeFirstStage) {
		this.coffeeFirstStage = coffeeFirstStage;
	}

	public String getCoffeeSecondStage() {
		return coffeeSecondStage;
	}

	public void setCoffeeSecondStage(String coffeeSecondStage) {
		this.coffeeSecondStage = coffeeSecondStage;
	}
}
