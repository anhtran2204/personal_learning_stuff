package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Demonstrates I/O in programming and I/O exceptions
 */
public class AdventureGame {
	private static Locations locations = new Locations();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Map<String, String> vocab = new HashMap<>();
		vocab.put("QUIT", "Q");
		vocab.put("NORTH", "N");
		vocab.put("SOUTH", "S");
		vocab.put("WEST", "W");
		vocab.put("EAST", "E");
		
		int loc = 64;
		while (true) {
			System.out.println(locations.get(loc).getDescription());
			if (loc == 0) {
				break;
			}
			
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.print("Available exits are ");
			for (String exit: exits.keySet()) {
				System.out.print(exit + ", ");
			}
			
			System.out.println();
			
			String direction = scanner.nextLine().toUpperCase();
			
			int count = 0;
			int firstOccurence = 0;
			if (direction.length() > 1) {
				String[] words = direction.split(" ");
				for (int i = 0; i < words.length; i++) {
					if (vocab.containsKey(words[i])) {
						count++;
						if (count == 1) {
							firstOccurence = i;
						}
					}
					
					if (count == 1) {
						direction = vocab.get(words[firstOccurence]);
						break;
					}
				}
			}
			
			if (exits.containsKey(direction)) {
				loc = exits.get(direction);
			} else {
				System.out.println("You cannot go in that direction.\n");
			}
		}
	}
}
