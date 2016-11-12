import java.util.Random;
import java.util.Scanner;

public class Main {

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
        Player p = new Player("William", 1, 1, 2, 3);

        p.selectFaction();
        p.selectRace();
        p.selectClass();
        return p;
    }

    private static boolean auth(String username, String password) {
        Random rnd = new Random();
        System.out.println("Username\t" + username);
        System.out.println("Password\t" + password);
        boolean success = rnd.nextBoolean();
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
}