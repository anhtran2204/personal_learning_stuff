package com.anhTran;

import java.util.HashMap;
import java.util.Map;

public class Location {
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;

	public Location(int locationID, String description) {
		this.locationID = locationID;
		this.description = description;
		this.exits = new HashMap<>();
		this.exits.put("Q", 0);
		this.exits.put("R", -1);
	}

	public int getLocationID() {
		return locationID;
	}

	public String getDescription() {
		return description;
	}

	/* Return a new shallow copy of
	 * the exits map to the user
	 */
	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
	}

	/* Add a new exit of a location
	 * to the exits map
	 */
	public void addExit(String direction, int locationID) {
		exits.put(direction, locationID);
	}
}
