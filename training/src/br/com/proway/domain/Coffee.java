package br.com.proway.services;

import java.util.ArrayList;

public class Coffee {
	private String name;
	private int capacity;
	private ArrayList<String> firstStage = new ArrayList<String>();
	private ArrayList<String> secondStage = new ArrayList<String>();

	public Coffee(String name, int capacity) {
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
		return firstStage;
	}

	public void setFirstStage(String person) {
		this.firstStage.add(person);
	}

	public ArrayList<String> getSecondStage() {
		return secondStage;
	}

	public void setSecondStage(String person) {
		this.secondStage.add(person);
	}

}
