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
        }

        System.out.println("Last action was " + action);
    }

    private static boolean auth(String username, String password) {
        System.out.println("Server Authentication in Main.auth");
        System.out.println("Username\t" + username);
        System.out.println("Password\t" + password);
        return true;
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