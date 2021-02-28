package br.com.proway.domain;

import java.util.ArrayList;

public class Room {
	private String name;
	private int capacity;
	private ArrayList<String> firstStage = new ArrayList<String>();
	private ArrayList<String> secondStage = new ArrayList<String>();

	public Room(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public ArrayList<String> getFirstStage() {
		/**
		 * It returns the list of people at a room on the first stage of training.
		 */
		return firstStage;
	}

	public void setFirstStage(String person) {
		/**
		 * It sets a person to attend a room on the first stage of training.
		 */
		this.firstStage.add(person);
	}

	public ArrayList<String> getSecondStage() {
		/**
		 * It returns the list of people at a room on the second stage of training.
		 */
		return secondStage;
	}

	public void setSecondStage(String person) {
		/**
		 * It sets a person to attend a room on the second stage of training.
		 */
		this.secondStage.add(person);
	}

}
