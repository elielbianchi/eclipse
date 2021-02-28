package br.com.proway.service;

import java.util.ArrayList;

import br.com.proway.domain.Person;
import br.com.proway.domain.Room;

public class RoomService {

	private ArrayList<Room> rooms = new ArrayList<Room>();

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoomService(String name, int capacity) {
		Room room = new Room(name, capacity);
		rooms.add(room);
	}
	
	public void roomChangeRules(Person person, int round, int nRooms, int inverter) {
		/**
		 * This method is called by the assingPeople method. It receives the counters
		 * and each person object from the previous method. This method is used to
		 * assign the people from odd 'rounds' to different rooms at the Second Stage.
		 * This is useful to respect the rules of the program, where at least 50% of
		 * people need to change the room from the First Stage to the Second Stage.
		 */
		if (round % 2 == 0) {
			getRooms().get(inverter).setSecondStage(Person.fullName(person));
			person.setRoomSecondStage(getRooms().get(inverter).getName());
		} else {
			getRooms().get(nRooms).setSecondStage(Person.fullName(person));
			person.setRoomSecondStage(getRooms().get(nRooms).getName());
		}
	}
}
