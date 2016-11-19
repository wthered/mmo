import java.text.MessageFormat;
import java.util.Random;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		// write your code here
		String username;
		String password;
		int action = 0;

		System.out.println("Main.main");
		System.out.print("What is you username? ");
		Scanner userScan = new Scanner(System.in);
		username = userScan.nextLine();

		/*
		While username not contains numbers
		notValid if contains [0-9] at least once
		todo Place this snippet inside auth Class
		*/
		while( username.matches("^[a-zA-Z]{1,}") ) {
			System.out.println("invalid Username! redo from start");
			System.out.print("What is you username? ");
			userScan = new Scanner(System.in);
			username = userScan.nextLine();
		}

		System.out.print("What is your Password? ");
		password = userScan.nextLine();

		/*
		** todo while identify != false { auth(username,password); }
		*/
		boolean identify = auth(username, password);

		if (identify) {
			action = createOrLogin();

			while ((action != 1) && (action != 2)) {
				System.out.println("Line 39 of Main.main");
				action = createOrLogin();
			}
			switch (action) {
				case 1:
					System.out.println("You will create a new Player");
					Player p = createNewPlayer();
					Race r = new Race();

					// Init these vars or reset Project
					p.setClassID(p.ClassID);
					r.setRaceID(p.RaceID);

					System.out.println("Main.main\t\t Player RaceID is\t" + p.RaceID );

					// Setting PlayerName
					System.out.printf("What is your name " + r.getRaceName(p.FactionID) + "? ");
					Scanner playerInfo = new Scanner(System.in);
					String playerName = playerInfo.nextLine();
					p.setName(playerName);

					// Setting PlayerSex
					System.out.println("***************");
					System.out.println("** 1) Male   **");
					System.out.println("** 2) Female **");
					System.out.println("***************");
					System.out.print("What is your desired sex " + p.getName() + "? ");
					p.setSex(playerInfo.nextInt());

					System.out.println("Ok " + playerName + "!");

					System.out.println("Your health is " + p.getHealth() + " health points");
					System.out.println("Your Mana is " + p.getMana() );

					int[] m = convertMoney(p.getMoney());
					String money = m[0] + "g " + m[1] + "s " + m[2] + "c";
					System.out.println(p.getName() + " has " + money + "! Use them wisely");

					String message = MessageFormat.format("Main.main says {0} is {1} {2} (sex {4}) from {3}", p.getName(), r.getRaceName(p.FactionID), p.ClassID, p.getFaction(), p.itsSexName);
					System.out.println(message);

					System.out.println("You are ready to quest " + p.getName());
					PlayerAction a = new PlayerAction(p);

					int lastPlayerAction = a.selectAction();
					while (lastPlayerAction != 0) {
						lastPlayerAction = a.selectAction();
						a.doAction();
					}
					break;
				case 2:
					System.out.println("Sending http request to see your old Characters");
					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		}

		System.out.println("Last action was " + action);
	}

	private static Player createNewPlayer() {
		Random rnd = new Random();
		Player p = new Player("William", 1, 1 + rnd.nextInt(3), 1 + rnd.nextInt(3), 1 + rnd.nextInt(3));

		p.selectFaction();
		p.selectRace();
		p.selectClass();
		return p;
	}

	private static boolean auth(String username, String password) {
		System.out.println("Username\t" + username);
		System.out.println("Password\t" + password);
		httpAuth auth = new httpAuth();
		boolean success = auth.send(username, password);
		System.out.println("Server Authentication in Main.auth is " + success);
		return success;
	}

	private static int createOrLogin() {
		int creation = 0;
		System.out.println("Main.createOrLogin");
		System.out.println("**************************");
		System.out.println("** 1) Create Character  **");
		System.out.println("** 2) Resume saved Game **");
		System.out.println("**************************");
		System.out.print("What is your desired action? ");
		Scanner actScan = new Scanner(System.in);

		// Check if input is valid int
		if( actScan.hasNextInt() ) {
			System.out.println("Line 134 of Main.createOrLogin creation = " + actScan.hasNextInt() );
			creation = actScan.nextInt();
		}

		while (creation != 1 && creation != 2 ) {
			System.out.print("What is your desired action? ");
			actScan = new Scanner(System.in);
			creation = actScan.nextInt();
		}
		return creation;
	}

	private static int[] convertMoney(int money) {
		int[] data;

		int copper = money % 100;

		int silver = (money - copper) / 100;
		silver = silver % 100;

		int amount = 100 * silver + copper;

		int gold = money - amount;
		gold = gold / 10000;

		data = new int[]{gold, silver, copper};
		return data;
	}
}