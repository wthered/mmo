import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is ${PACKAGE_NAME}
 * Feel Free to Edit mmo
 */
class PlayerAction {

	private int lastAction;
	private Player myself;

	PlayerAction(Player actor) {
		this.lastAction = 0;
		this.myself = actor;
	}

	int selectAction() {
		int thisAction = 0;
		boolean valid;
		System.out.println("*********************************************");
		System.out.println("** 1) Eat                                  **");
		System.out.println("** 2) Drink                                **");
		System.out.println("** 3) Fuck                                 **");
		System.out.println("** 4) Quest                                **");
		System.out.println("** 5) Go to City                           **");
		System.out.println("** 6) Go to Area                           **");
		System.out.println("** 7) Go to Location (x,y) of current Area **");
		System.out.println("** 8) Report yourself (Position and Stats) **");
		System.out.println("** 9) See What i have in Inventory         **");
		System.out.println("** 0) Done. Fly me to the moon and stars   **");
		System.out.println("*********************************************");
		System.out.print("What is your desire, " + myself.getRaceName() + "? ");
		Scanner actionScanner = new Scanner(System.in);
		try {
			thisAction = actionScanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println(" is not a valid option" + thisAction);
		}
		this.lastAction = thisAction;
		return thisAction;
	}

	private boolean validate(int action) {
		return action < 9;
	}

	private void report() {
		System.out.println(myself.getName() + " is level " + myself.level );
		System.out.println("I currently have " + myself.getHealth() + " Health Points and " + myself.getItsMana() );
		System.out.println("I have " + myself.getMoney() + " coins");
//		System.out.println("Currently being in " + myself.ge);
		System.out.println("Last Action of " + myself.getName() + " is " + this.lastAction);
	}

	void doAction() {
		/*
		** todo 1) look into Inventory to see if foodIsAvailable()
		** todo 2) look into Inventory to see if drinkIsAvailable()
		*/
		switch (this.lastAction) {
			case 3:
				System.out.println("Looking to find another player (thru http) for " + myself.getName() + " in PlayerAction.doAction");
				break;
			case 8:
				this.report();
				break;
			case 0:
				System.out.println("Exiting....");
				break;
			default:
				System.out.println("Not implemented yet in PlayerAction.doAction for " + this.lastAction);
		}
	}
}
