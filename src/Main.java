import java.util.Random;
import java.util.Scanner;

import static java.text.MessageFormat.format;

/* todo
	Players have (maybe 2?) Professions
	AttackPower
	Block / Parry Abilities
	Wizards / Warlocks use SpellPower
	Rogue / Warriors use MeleePower
	Some weapons have spellPower (or addSpellPower() ? ), some Melee (maybe some both?)

	All players have explore Abilities. When you explore you might find monsters / gold / weapon
	Each Weapon has accuracy (spellAccuracy / MeleeAcc)
	Each weapon has CriticalChance (if succeed { this.damage *= 2; } on this cast of attackAction

	example: https://www.youtube.com/watch?v=WrYEZdQZ3aw
	 class Ogre {
	    this.level = new RandomBetween(1,2).toInt();
	    CurrentHealth = 200/200;
	    minimumDamage = 30;
	    maximumDamage = 65;
	    chanceToHit = 60;
	    chanceToBlock = 15;
	 }
 */
class Main {

	public static void main(String[] args) {
		// write your code here
		String username;
		String password;
		int action = 0;

		System.out.print("What is your username? ");
		Scanner userScan = new Scanner(System.in);
		username = userScan.nextLine();

		userAuth usr = new userAuth(username);
		/*
		** While username not contains numbers
		*/
		while( !usr.validateName() ) {
			usr.getNewName(userScan);
		}

		System.out.print("What is your password? ");
		password = userScan.nextLine();

		/*
		** todo while identify != false { auth(username,password); }
		*/
		boolean identify = auth(username, password);

		if (identify) {
			action = createOrLogin();

			while ((action != 1) && (action != 2) && (action != 3)) {
				System.out.println("Line 39 of Main.main");
				action = createOrLogin();
			}
			switch (action) {
				case 1:
					System.out.println("You will create a new Player");
					Race r = new Race();
					Player p = createNewPlayer(r);

					// Init these vars or reset Project
//					System.out.println("Main.main Before line 51\n");
					p.setClassID(p.ClassID);
//					System.out.println("Main.main After Line 51\n");
					r.setRaceID(p.RaceID);
					System.out.println("Main.main Setting Player Attributes in line 53");
					r.setPlayerAttributes(p);

					// Setting PlayerName
					System.out.printf("What is your name " + r.getRaceName(Player.FactionID) + "? ");

					Scanner playerInfo = new Scanner(System.in);
					String playerName = playerInfo.nextLine();
					if (playerName.matches("[a-zA-Z]{1,}")) {
						p.setName(playerName);
					} else {
						while (playerName.matches("[a-zA-Z]{1,}")) {
							System.out.println("Your name can only contain letters");
							playerName = playerInfo.nextLine();
						}
					}

					// Setting PlayerSex
					System.out.println("***************");
					System.out.println("** 1) Male   **");
					System.out.println("** 2) Female **");
					System.out.println("***************");
					System.out.print("What is your sex " + p.getName() + "? ");
					p.setSex(playerInfo.nextInt());

					System.out.println("Ok " + playerName + "!");

					System.out.println("Your health is " + p.getItsHealth() + " health Points");
					System.out.println("Your Mana is " + p.getItsMana() + " Mana Points");

					System.out.println(p.getName() + " has " + Main.convertMoney(p.getMoney()) + "! Use them wisely");

					String message = format("Main.main says {0} is {4} {1} {2} from {3}", p.getName(), r.getRaceName(Player.FactionID), p.ClassName, p.getFaction(), p.itsSexName);
					System.out.println(message);

//					System.out.println("Main.main line 110");
					p.setStartingCity();
					System.out.println("You are ready to quest " + p.getName());
					PlayerAction a = new PlayerAction(p, r);

					// Select What to do and do it
					int lastPlayerAction = a.selectAction();

					// Test-> Put a.doAction into a.selectAction
					try {
						a.doAction();
						// Repeat until I say so
						while (lastPlayerAction != 0 && p.getItsHealth() > 0) {
							lastPlayerAction = a.selectAction();
							a.doAction();
						}
						if(p.getItsHealth() <= 0) {
							System.out.println("Main.main You died");
							break;
						}
					} catch (InterruptedException ex) {
						System.out.println("Interrupted in line 93 of Main.main");
						ex.printStackTrace();
					}
					break;
				case 2:
					System.out.println("Sending http request to see your old Characters");
					break;
				case 3:
					System.out.println("Main.main line 132 Enter the following random string to delete all your characters");
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} else {
			System.out.println("Main.main Line 145 User Authentication Failed. Try Again");
		}
		System.out.println("Last action was " + action);
	}

	private static Player createNewPlayer(Race r) {
		Random rnd = new Random();
		Player p = new Player("Anonymous", 1, 1 + rnd.nextInt(3), r, 1 + rnd.nextInt(3));

		p.selectFaction();
		p.selectRace();
		p.selectClass(r);
		return p;
	}

	private static boolean auth(String username, String password) {
		Random suck = new Random();
		Boolean success;
		System.out.println("Username\t" + username);
		System.out.println("Password\t" + password);
		httpAuth auth = new httpAuth();
		success = suck.nextBoolean() && auth.send(username, password);
		System.out.println("Server Authentication in Main.auth is " + success);
		return success;
	}

	private static int createOrLogin() {
		int creation = 0;
		System.out.println("Main.createOrLogin");
		System.out.println("**************************");
		System.out.println("** 1) Create Character  **");
		System.out.println("** 2) Resume saved Game **");
		System.out.println("** 3) Delete a last game**");
		System.out.println("**************************");
		System.out.print("What is your desired action? ");
		Scanner actScan = new Scanner(System.in);

		// Check if input is valid int
		if( actScan.hasNextInt() ) {
//			System.out.println("Line 150 of Main.createOrLogin creation = " + actScan.hasNextInt() );
			creation = actScan.nextInt();
		}

		while (creation != 1 && creation != 2 && creation != 3) {
			System.out.print("What is your desired action? ");
			actScan = new Scanner(System.in);
			creation = actScan.nextInt();
		}
		return creation;
	}

	static String convertMoney(int money) {
//		int[] data;

		int copper = money % 100;

		int silver = (money - copper) / 100;
		silver = silver % 100;

		int amount = 100 * silver + copper;

		int gold = money - amount;
		gold = gold / 10000;

//		data = new int[]{gold, silver, copper};
		return gold + "g " + silver + "s " + copper + "c";
	}
}