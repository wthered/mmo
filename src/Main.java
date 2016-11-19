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

		System.out.print("What is your Password? ");
		password = userScan.nextLine();

		boolean identify = auth(username, password);

		if (identify) {
			action = createOrLogin();
			switch (action) {
				case 1:
					System.out.println("You will create a new Player");
					Player p = createNewPlayer();
					int[] m = convertMoney(p.getMoney());
					String money = m[0] + "g " + m[1] + "s " + m[2] + "c";
					System.out.println(p.getName() + " has " + money + "! Use them wisely");
					System.out.println("Main.main says PlayerClass is " + p.ClassID + " from " + p.getFaction());
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
		System.out.println("**************************");
		System.out.println("** 1) Create Character  **");
		System.out.println("** 2) Resume saved Game **");
		System.out.println("**************************");
		System.out.print("What is your desired action? ");
		Scanner actScan = new Scanner(System.in);
		return actScan.nextInt();
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