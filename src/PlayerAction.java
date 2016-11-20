import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is ${PACKAGE_NAME}
 * Feel Free to Edit mmo
 */
class PlayerAction {

	private int lastAction;
	private Player myself;
	private Race racist;

	PlayerAction(Player actor, Race playRace) {
		this.lastAction = 0;
		this.myself = actor;
		this.racist = playRace;
	}

	int selectAction() {
		int thisAction = 0;
		System.out.println("*********************************************");
		System.out.println("** 1) Eat                                  **");
		System.out.println("** 2) Drink                                **");
		System.out.println("** 3) Fuck                                 **");
		System.out.println("** 4) Quest                                **");
		System.out.println("** 5) Sleep for 5 seconds until reach City **");
		System.out.println("** 6) Go to Area                           **");
		System.out.println("** 7) Go to Location (x,y) of current Area **");
		System.out.println("** 8) Report yourself (Position and Stats) **");
		System.out.println("** 9) See what I have in Inventory / Bank  **");
		System.out.println("** 0) Fly me to the moon among the stars   **");
		System.out.println("*********************************************");
		System.out.print("What is your desire, " + myself.getName() + "? ");
		Scanner actionScanner = new Scanner(System.in);
		try {
			thisAction = actionScanner.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println(thisAction + " is not a valid option");
			ex.printStackTrace();
		} finally {
			this.lastAction = thisAction;
		}
		return this.lastAction;
	}

	private void report() {
		System.out.println(myself.getName() + " is level " + myself.level );
		System.out.println("I currently have " + myself.getItsHealth() + " Health Points of " + myself.maxHealth + " max");
		System.out.println("I currently have " + myself.getItsMana() + " mana points of " + myself.maxMana + " max");
		System.out.println("I have " + myself.getMoney() + " coins");
		System.out.println("I have " + myself.showExperience() + " experience" );
		System.out.println("You can find me near " + myself.getPosition() + " of " + myself.getArea() + ", " + myself.getCity());
		System.out.println("Last Action of " + myself.getName() + " is " + this.lastAction);

		System.out.println("******** Attributes Report Starts here ********");
		System.out.println("** Strength for " + myself.getRaceName() + " is " + racist.getRaceStrength());
		System.out.println("** Agility for " + myself.getRaceName() + " is " + racist.getRaceAgility());
		System.out.println("** Stamina for " + myself.getRaceName() + " is " + racist.getRaceStamina());
		System.out.println("** Intellectual" + myself.getRaceName() + " is " + racist.getRaceSpirit());
		System.out.println("** Spirit  for " + myself.getRaceName() + " is " + racist.getRaceSpirit());
		System.out.println("***********************************************");
	}

	void doAction() throws InterruptedException {
		/*
		** todo 1) look into Inventory to see if foodIsAvailable()
		** todo 2) look into Inventory to see if drinkIsAvailable()
		*/
		switch (this.lastAction) {
			case 0:
				System.out.println("Exiting....");
				break;
			case 3:
				// Looking to find another player (thru http) for " + myself.getName() + " in PlayerAction.doAction;
				Timer timer = new Timer();
				timer.schedule(new PlayerChat(this.lastAction), 0, 5000);
				if (this.lastAction == 0) {
					timer.cancel();
					timer.purge();
				}
				break;
			case 5:
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						System.out.println("PlayerAction.doAction interrupted in line 83");
						ex.printStackTrace();
						Thread.currentThread().interrupt();
					}
					System.out.println(Thread.activeCount() + " in PlayerAction.doAction");
				}
			case 8:
				this.report();
				break;
			default:
				System.out.println("Not implemented yet in PlayerAction.doAction for " + this.lastAction);
		}
	}

	private class PlayerChat extends TimerTask {

		private int lastAction;

		PlayerChat(int lastAction) {
			this.lastAction = lastAction;
		}

		public void run() {
			System.out.println("PlayerChat.run in PlayerAction line 84 LastAction = " + this.lastAction);
			Toolkit.getDefaultToolkit().beep();
		}
	}
}
