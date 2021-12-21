package com.anhTran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.anhTran.Inventory.ItemType;

public class AdventureGame {
	private static Map<Integer, Location> locations = new HashMap<>();
	private static Map<String, String> vocab = new HashMap<>();
	private static ArrayList<String> yesAnswers = new ArrayList<>();
	private static ArrayList<String> noAnswers = new ArrayList<>();
	private static Inventory meleeInventory = new Inventory();
	private static Inventory gunInventory = new Inventory();
	private static Inventory grenadeInventory = new Inventory();
	private static Inventory firstAidInventory = new Inventory();
	private static Map<ItemType, Inventory> inventory = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);
	private static Random random = new Random();
	private static boolean restartGame = false;
	private static int playerHP = 200, xpBar = 0, xpLimit = 100, level = 1, score = 0, zombieHP, zombieAttack;
	private static String equippedItem;

	public static void main(String[] args) {
		run();
	}


	/* This method delays the time
	 * between each method
	 */
	public static void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.err.format("IOException: %s%n", e);
		}
	}


	/* This method is called to run the game */
	public static void run() {
		setupDirections();
		setupRooms();
		setUpExits();
		context();
		gameplay();
	}


	/* Context of the game */
	public static void context() {
		System.out.println("\nWarning!");
		pause(2000);
		System.out.println("You should based the directions on how you normally walk, not based on the game.");
		pause(2000);
		System.out.println("You wake up and find yourself in a school.");
		pause(2000);
		System.out.println("The classroom is empty but there are crashing sounds in the hall.");
		pause(2000);
		System.out.println("What do you do?");
		pause(2000);
	}


	/* This method have a WHILE loop is for
	 * the user input and decide the location
	 * the user goes to by getting the value
	 * of the exits (the locationID), which in
	 * turn is the key for the location.
	 */
	public static void gameplay() {
		String[] itemOption = {"knife", "katana", "machete", "baseball bat", "mace", "hammer", "bow and arrow",
				"handgun", "assault rifle", "SMG", "sniper rifle", "shotgun", "machine gun", "smoke bombs",
				"grenade", "flashbang", "first aid kit", "shield"};

		int loc = 1;
		restartGame = false;
		while (true) {
			// Get description
			System.out.println("\n" + locations.get(loc).getDescription() + "\n");
			if (loc == 0) { break; } // Break out of loop

			// Randomly enter a room that has zombies
			int zombieRoom = random.nextInt(78);
			if (loc == zombieRoom && (zombieRoom % 2 == 0 || zombieRoom % 5 == 0)) {
				combat();
			}

			// Randomly go into a room that
			// has an item that can be pick up
			zombieRoom = random.nextInt(78);
			if (loc == zombieRoom && (zombieRoom % 2 == 0 || zombieRoom % 3 == 0)) {
				pickUpItems(itemOption[random.nextInt(itemOption.length)]);
			}

			// Print out available exit options
			Map<String, Integer> exits = locations.get(loc).getExits();
			System.out.print("Available exits are: ");
			for (String exit: exits.keySet()) {
				System.out.print(exit + ", ");
			}

			// Input from the user
			System.out.print("\nEnter the direction: ");
			String direction = scanner.nextLine().toUpperCase();

			/* Split the input into an array
			 * of words and compare each word
			 * with the keys in the exits Map
			 */
			String[] words = direction.split(" ");
			int count = 0;
			String word = null;
			if (direction.length() > 1) {
				for (int i = 0; i < words.length; i++) {
					if (vocab.containsKey(words[i]) && words[i] != "RESTART") {
						if (vocab.containsKey(words[i + 1]) && words[i + 1] != "RESTART") {
							count++;
							word = vocab.get(words[i]) + " " + vocab.get(words[i + 1]);
						}
					} else {
						direction = vocab.get(words[i]);
						word = vocab.get(words[i]);
						break;
					}
				}

				if (count == 1) {
					direction = vocab.get(word);
				} else {
					System.out.println("I don't quite understand where you're trying to go.\n");
				}
			}

			if (exits.containsKey(direction) && direction != "R") {
				loc = exits.get(direction);
			} else if (exits.containsKey(direction) && direction == "R") {
				while (true) {
					System.out.println("Do you want to restart the game? Yes or No?");
					String restart = scanner.nextLine();
					if (yesAnswers.contains(restart)) {
						System.out.println("\n~~~~~~~~~~~~ YOU LOSE ~~~~~~~~~~~~~\n");
						restartGame = true;
						restart();
					} else if (noAnswers.contains(restart)) {
						System.out.println("\nContinuing....\n");
						pause(2000);
					} else {
						System.out.println("I don't understand.\n");
						pause(2000);
					}
				}
			} else {
				System.out.println("You cannot go in that direction");
			}
		}
	}


	/* Adding a new location with its locationID
	 * and description of the place.
	 */
	public static void setupRooms() {
		locations.put(0, new Location(0, "You're in the upper part of the first hallway."));
		locations.put(1, new Location(1, "You're in the algebra classroom #1 on the ground floor."));
		locations.put(2, new Location(2, "You're in the lower part of first hallway."));
		locations.put(3, new Location(3, "You're in the algebra classroom #2 on the groundfloor."));
		locations.put(4, new Location(4, "You're in the algebra classroom #3 on the groundfloor."));
		locations.put(5, new Location(5, "You're in the second hallway."));
		locations.put(6, new Location(6, "You're in the pre-cal classroom #1."));
		locations.put(7, new Location(7, "You're in the pre-cal classroom #2."));
		locations.put(8, new Location(8, "You're in the geometry classroom."));
		locations.put(9, new Location(9, "You're in the school garden."));
		locations.put(10, new Location(10, "You're in the third hallway."));
		locations.put(11, new Location(11, "You're in the calculus classroom #1."));
		locations.put(12, new Location(12, "You're in the calculus classroom #2."));
		locations.put(13, new Location(13, "You're in the statistics classroom."));
		locations.put(14, new Location(14, "You're in the fourth hallway."));
		locations.put(15, new Location(15, "You're in the fourth hallway WC."));
		locations.put(16, new Location(16, "You're in the science classroom #1."));
		locations.put(17, new Location(17, "You're in the science classroom #2."));
		locations.put(18, new Location(18, "You're in the science classroom #3."));
		locations.put(19, new Location(19, "You're in the science classroom #4."));
		locations.put(20, new Location(20, "You're in the school canteen."));
		locations.put(21, new Location(21, "You're in the school canteen WC"));
		locations.put(22, new Location(22, "You're in the main hallway."));
		locations.put(23, new Location(23, "You're in the nurses office."));
		locations.put(24, new Location(24, "You're in the attendance office."));
		locations.put(25, new Location(25, "You're in the upper part of fifth hallway."));
		locations.put(26, new Location(26, "You're in the lower part of fifth hallway."));
		locations.put(27, new Location(27, "You're in the fifth hallway WC"));
		locations.put(28, new Location(28, "You're in the sixth hallway."));
		locations.put(29, new Location(29, "You're in the counselor office."));
		locations.put(30, new Location(30, "You're in the vice-principal office."));
		locations.put(31, new Location(31, "You're in the principal office."));
		locations.put(32, new Location(32, "You're in the seventh hallway."));
		locations.put(33, new Location(33, "You're in the seventh hallway WC."));
		locations.put(33, new Location(34, "You're in the school gym."));
		locations.put(34, new Location(35, "You're in the eighth hallway."));
		locations.put(35, new Location(36, "You're in the eighth hallway WC."));
		locations.put(36, new Location(37, "You're in the english classroom #1."));
		locations.put(37, new Location(38, "You're in the english classroom #2."));
		locations.put(38, new Location(39, "You're in the english classroom #3."));
		locations.put(39, new Location(40, "You're in the english classroom #4."));
		locations.put(40, new Location(41, "You're in the social studies classroom #1."));
		locations.put(41, new Location(42, "You're in the social studies classroom #2."));
		locations.put(42, new Location(43, "You're in the social studies classroom #3."));
		locations.put(43, new Location(44, "You're in the school auditorium."));
		locations.put(44, new Location(45, "You're in the ninth hallway on the first floor."));
		locations.put(45, new Location(46, "You're in the fine arts classroom #1."));
		locations.put(46, new Location(47, "You're in the fine arts classroom #2."));
		locations.put(47, new Location(48, "You're in the fine arts classroom #3."));
		locations.put(48, new Location(49, "You're in the eleventh hallway."));
		locations.put(49, new Location(50, "You're in the foreign languages classroom #1."));
		locations.put(50, new Location(51, "You're in the foreign languages classroom #2."));
		locations.put(51, new Location(52, "You're in the foreign languages classroom #3."));
		locations.put(52, new Location(53, "You're in the tenth hallway."));
		locations.put(53, new Location(54, "You're in the STEM lab #1."));
		locations.put(54, new Location(55, "You're in the STEM lab #2."));
		locations.put(54, new Location(56, "You're in the tenth hallway WC."));
		locations.put(55, new Location(57, "You're in the twelfth hallway."));
		locations.put(56, new Location(58, "You're in the twelfth hallway WC."));
		locations.put(57, new Location(59, "You're in the computer lab #1."));
		locations.put(58, new Location(60, "You're in the computer lab #2."));
		locations.put(59, new Location(61, "You're in the school library."));
		locations.put(60, new Location(62, "You're at main door."));
		locations.put(61, new Location(63, "You're at front door #1."));
		locations.put(62, new Location(64, "You're at front door #2."));
		locations.put(63, new Location(65, "You're at front door #3."));
		locations.put(64, new Location(66, "You're at the baseball field."));
		locations.put(65, new Location(67, "You're at the tennis court."));
		locations.put(66, new Location(68, "You're at football field."));
	}


	/* A new map to store the words from the
	 * input that has been split()
	 */
	public static void setupDirections( ) {
		vocab.put("NORTH", "N");
		vocab.put("SOUTH", "S");
		vocab.put("WEST", "W");
		vocab.put("EAST", "E");
		vocab.put("SOUTH EAST", "SE");
		vocab.put("SOUTH WEST", "SW");
		vocab.put("NORTH EAST", "NE");
		vocab.put("NORTH WEST", "NW");
		vocab.put("QUIT", "Q");
		vocab.put("RESTART", "R");
	}


	/* Adding exits to the corresponding
	 * location with directions as the key
	 * and the locationID as the value
	 */
	public static void setUpExits( ) {
		// Location #0: Upper part of 1st
		locations.get(0).addExit("N", 20);
		locations.get(0).addExit("S", 2);
		locations.get(0).addExit("W", 9);
		locations.get(0).addExit("E", 1);

		// Location #1: 1st Algebra classroom
		locations.get(1).addExit("W", 0);

		// Location #2: Lower part of 1st hallway
		locations.get(2).addExit("N", 0);
		locations.get(2).addExit("S", 4);
		locations.get(2).addExit("W", 9);
		locations.get(2).addExit("E", 3);

		// Location #3: 2nd Algebra classroom
		locations.get(3).addExit("W", 2);

		// Location #4: 3rd Algebra classroom
		locations.get(4).addExit("N", 2);

		// Location #5: Second hallway
		locations.get(5).addExit("N", 10);
		locations.get(5).addExit("S", 2);
		locations.get(5).addExit("NW", 8);
		locations.get(5).addExit("SW", 6);
		locations.get(5).addExit("W", 7);
		locations.get(5).addExit("E", 9);

		// Location #6: 1st Pre-cal classroom
		locations.get(6).addExit("E", 5);

		// Location #7: 2nd Pre-cal classroom
		locations.get(7).addExit("E", 5);

		// Location #8: Geometry classroom
		locations.get(8).addExit("E", 5);

		// Location #9: School garden
		locations.get(9).addExit("N", 10);
		locations.get(9).addExit("S", 1);
		locations.get(9).addExit("W", 5);
		locations.get(9).addExit("E", 14);

		// Location #10: Third hallway
		locations.get(10).addExit("N", 14);
		locations.get(10).addExit("S", 48);
		locations.get(10).addExit("NW", 13);
		locations.get(10).addExit("SW", 11);
		locations.get(10).addExit("W", 12);
		locations.get(10).addExit("E", 9);

		// Location #11: 1st Calculus classroom
		locations.get(11).addExit("E", 10);

		// Location #12: 2nd Calculus classroom
		locations.get(12).addExit("E", 10);

		// Location #13: Statistics classroom
		locations.get(13).addExit("E", 10);

		// Location #14: Fourth hallway
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #15: Fourth hallway WC
		locations.get(15).addExit("E", 14);

		// Location #16: 1st Science classroom
		locations.get(16).addExit("W", 14);

		// Location #17: 2nd Science classroom
		locations.get(17).addExit("E", 14);

		// Location #18: 3rd Science classroom
		locations.get(18).addExit("W", 14);

		// Location #19: 4th Science classroom
		locations.get(19).addExit("E", 14);

		// Location #20: School canteen
		locations.get(20).addExit("N", 20);
		locations.get(20).addExit("S", 52);
		locations.get(20).addExit("NW", 19);
		locations.get(20).addExit("SW", 15);
		locations.get(20).addExit("W", 17);
		locations.get(20).addExit("SE", 16);
		locations.get(20).addExit("NE", 18);
		locations.get(20).addExit("E", 9);

		// Location #21: School canteen WC
		locations.get(21).addExit("N", 20);
		locations.get(21).addExit("S", 52);
		locations.get(21).addExit("NW", 19);
		locations.get(21).addExit("SW", 15);
		locations.get(21).addExit("W", 17);
		locations.get(21).addExit("SE", 16);
		locations.get(21).addExit("NE", 18);
		locations.get(21).addExit("E", 9);

		// Location #22: Main hallway
		locations.get(22).addExit("N", 20);
		locations.get(22).addExit("S", 52);
		locations.get(22).addExit("NW", 19);
		locations.get(22).addExit("SW", 15);
		locations.get(22).addExit("W", 17);
		locations.get(22).addExit("SE", 16);
		locations.get(22).addExit("NE", 18);
		locations.get(22).addExit("E", 9);

		// Location #23: Nurses Office
		locations.get(23).addExit("N", 20);
		locations.get(23).addExit("S", 52);
		locations.get(23).addExit("NW", 19);
		locations.get(23).addExit("SW", 15);
		locations.get(23).addExit("W", 17);
		locations.get(23).addExit("SE", 16);
		locations.get(23).addExit("NE", 18);
		locations.get(23).addExit("E", 9);

		// Location #24: Attendance Office
		locations.get(24).addExit("N", 20);
		locations.get(24).addExit("S", 52);
		locations.get(24).addExit("NW", 19);
		locations.get(24).addExit("SW", 15);
		locations.get(24).addExit("W", 17);
		locations.get(24).addExit("SE", 16);
		locations.get(24).addExit("NE", 18);
		locations.get(24).addExit("E", 9);

		// Location #25: Upper part of the fifth hallway
		locations.get(25).addExit("N", 20);
		locations.get(25).addExit("S", 52);
		locations.get(25).addExit("NW", 19);
		locations.get(25).addExit("SW", 15);
		locations.get(25).addExit("W", 17);
		locations.get(25).addExit("SE", 16);
		locations.get(25).addExit("NE", 18);
		locations.get(25).addExit("E", 9);

		// Location #26: Lower part of the fifth hallway
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #27: Fourth hallway
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #27: Fifth hallway WC
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #28: Sixth hallway
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #29: Counselor Office
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #30: Vice-Principal Office
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #31: Principal Office
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #32: Seventh hallway
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #33: Seventh hallway WC
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #34: School gym
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #35: Eighth hallway
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #36: Eighth hallway WC
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #37: 1st English classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #38: 2nd English classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #39: 3rd English classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #40: 4th English classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #41: 1st Social Studies classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #42: 2nd Social Studies classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #43: 3rd Social Studies classroom
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);

		// Location #44: School Auditorium
		locations.get(14).addExit("N", 20);
		locations.get(14).addExit("S", 52);
		locations.get(14).addExit("NW", 19);
		locations.get(14).addExit("SW", 15);
		locations.get(14).addExit("W", 17);
		locations.get(14).addExit("SE", 16);
		locations.get(14).addExit("NE", 18);
		locations.get(14).addExit("E", 9);
	}


	/* This method enables us to
	 * pick up items and store it
	 * in an inventory
	 */
	public static void pickUpItems(String newItem) {
		String[] yes = {"Y", "y", "yes", "Yes", "YES", "YEs", "yES", "yeS", "YeS"};
		String[] no = {"N", "n", "No", "no", "NO"};

		for (int i = 0; i < yes.length; i++) {
			yesAnswers.add(yes[i]);
		}

		for (int i = 0; i < yes.length; i++) {
			noAnswers.add(no[i]);
		}


		for (Map.Entry<ItemType, Inventory> item : inventory.entrySet()) {
			if (item.getValue().containsItem(newItem)) {
				System.out.println("You've already picked it up.\n");
				pause(2000);
			} else {
				System.out.println("You found " + newItem + "!\n");
				boolean stop = true;
				while (stop) {
					System.out.println("Do you want to pick it up? Yes or No.\n");
					String pickUp = scanner.nextLine();
					if (yesAnswers.contains(pickUp)) {
						System.out.println("What type of item is it?\n");
						String itemType = scanner.nextLine().toUpperCase();
						switch (itemType) {
							case "MELEE" :
								inventory.put(ItemType.MELEE, meleeInventory);
								meleeInventory.addToInventory(newItem);
								break;

							case "GUN" :
								inventory.put(ItemType.GUN, gunInventory);
								gunInventory.addToInventory(newItem);
								break;

							case "GRENADE" :
								inventory.put(ItemType.GRENADE, grenadeInventory);
								grenadeInventory.addToInventory(newItem);
								break;

							case "FIRST AID" :
								inventory.put(ItemType.FIRST_AID, firstAidInventory);
								firstAidInventory.addToInventory(newItem);
								break;

							default :
								System.out.println("I don't understand!\n");
						}
						System.out.println("\nYou acquired the " + newItem + "!\n");
						stop = false;
						pause(2000);
					} else if (noAnswers.contains(pickUp)) {
						System.out.println("Maybe later then.\n");
						stop = false;
						pause(2000);
					} else {
						System.out.println("I don't understand.\n");
					}
				}
			}
		}
	}


	/* This method access the arrayList inventory
	 * and equip an item for our player by printing
	 * the items and return a String value which is
	 * the item we chosen.
	 */
	public static String accessInventory() {
		String itemChosen = scanner.nextLine();
		for (Map.Entry<ItemType, Inventory> item : inventory.entrySet()) {
			if (item.getValue().containsItem(itemChosen)) {
				equippedItem = itemChosen;
				System.out.println("Equipped " + equippedItem + " successfully.\n");
				return equippedItem;
			}
		}
		return "There's no item with that name.\n";
	}


	/* This method processes the
	 * combat actions of the player
	 * with the enemies and handles
	 * the using of inventory and
	 * the pickUpItems method
	 */
	public static void combat() {
		String[] zombieType = {"Walking Zombie", "Running Zombie", "Crawling Zombie", "Bulky Zombie", "Radiating Zombie",
				"Toxic Zombie", "Zombie Hound", "Human Centipede Zombie", "Chimera Zombie"};
		String[] weaponChoice = {"baseball bat", "knife", "katana", "machete", "chainsaw", "handgun", "SMG", "shotgun",
				"assault rifle", "sniper rifle", "machine gun"};

		int zombie = random.nextInt(zombieType.length);
		System.out.println("You encountered a " + zombieType[zombie] + "!\n");
		System.out.println("What do you want to do?\n1 - Block\n2 - Inventory\n3 - Attack\n4 - Run away\n");

		boolean hasNextInt = scanner.hasNextInt();
		while (hasNextInt) {
			int choice = scanner.nextInt();
			switch (choice) {
				case 1: // Block the attack of the zombie
					zombieAttack = random.nextInt(50);
					System.out.println("You blocked " + zombieAttack + " damage!\n");

				case 2: // Open inventory and use item
					if (inventory.isEmpty()) {
						System.out.println("Your inventory is currently empty.\n");
					} else {
						System.out.println(inventory + "\n");
						System.out.println("What item do you want to use?\n");

					}

				case 3: // Attack the zombie


				case 4: // Run away from the zombie


				default:
					System.out.println("I don't understand.\n");
			}
		}

		for (int i = 0; i < weaponChoice.length; i++) {
			for (int j = 0; j < zombieType.length; j++) {

			}
		}

	}


	/* This method restarts the game
	 * when called
	 */
	public static void restart() {
		if (restartGame) {
			pause(2000);
			System.out.println("\n************ NEW GAME ************\n");
			run();
			System.gc();
		}
	}


	/*	This method quits the game and terminates
	 * 	the console and flush out memory.
	 */
	public static void quit() {
		System.exit(0);
	}
}
















