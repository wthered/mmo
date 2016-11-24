import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is ${PACKAGE_NAME}
 * Feel Free to Edit mmo
 */
class PlayerAction {

	private int lastAction;
	private Player myself;
	private Race racist;
	private Random randomAction = new Random();

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
		System.out.println("I have " + Main.convertMoney(myself.getMoney()));
		System.out.println("I have " + myself.showExperience() + " experience" );
		System.out.println("You can find me near " + myself.getPosition() + " of " + myself.getArea() + ", " + myself.getCity());
		System.out.println("Last Action of " + myself.getName() + " is " + this.lastAction);

		System.out.println("******** Attributes Report Starts here ********");
		System.out.println("** Strength\t\t" + myself.getRaceName() + " is " + racist.getRaceStrength());
		System.out.println("** Agility\t\t" + myself.getRaceName() + " is " + racist.getRaceAgility());
		System.out.println("** Stamina\t\t" + myself.getRaceName() + " is " + racist.getRaceStamina());
		System.out.println("** Intellect\t" + myself.getRaceName() + " is " + racist.getRaceSpirit());
		System.out.println("** Spirit\t\t" + myself.getRaceName() + " is " + racist.getRaceSpirit());
		System.out.println("***********************************************");
	}

	void doAction() throws InterruptedException {
		Random place = new Random(100);
		/*
		** todo 1) look into Inventory to see if foodIsAvailable()
		** todo 2) look into Inventory to see if drinkIsAvailable()
		*/
		switch (this.lastAction) {
			case 0:
				System.out.println("Exiting....");
				break;
			case 1:
				this.eat();
				break;
			case 2:
				this.drink();
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
			case 4:
				Random questID = new Random();
				Quest q = new Quest(myself);
				q.doQuest(questID.nextInt(100));
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
					System.out.println("Thread counts " + Thread.activeCount() + " in PlayerAction.doAction");
				}
				break;
			case 6:
				Travel t = new Travel(myself);
				String destination = t.selectDestination();
				t.visit(destination);
				myself.setItsX(place.nextInt(100));
				myself.setItsX(place.nextInt(100));

				System.out.println("PlayerAction.doAction Area = " + myself.getArea());
				System.out.println("PlayerAction.doAction City = " + myself.getCity());
				System.out.println("PlayerAction.doAction " + myself.getPosition() + " (" + myself.getItsX() + "," + myself.getItsY() + ")");
				break;
			case 7:
				myself.travel(1 + place.nextInt(100), 1 + place.nextInt(100));
				break;
			case 8:
				this.report();
				System.out.println("PlayerAction.doAction You have " + myself.getItsHealth() + " health points");
				System.out.println("PlayerAction.doAction You have " + myself.getItsMana() + " mana");
				break;
			case 9:
				System.out.println("PlayerAction.doAction Looking into my Inventory");
				System.out.println("PlayerAction.doAction Found None");
				break;
			default:
				System.out.println("Not implemented yet in PlayerAction.doAction for " + this.lastAction);
		}
	}

	private void eat() {
		if(myself.getItsHealth() == myself.getMaxHealth()) {
			System.out.println("Already have max Health. Can not eat more");
		} else {
			FoodItem food = new FoodItem("Potato Bread", 24, 24, "Bread");
			for (int i = 0; i < food.getItemTime(); i++) {
				try {
					TimeUnit.SECONDS.sleep(5);
					// todo Να παίρνει αντικείμενα από το Player.inventory
					float healthPerSecond = food.getHealthPerTick();
					// todo ConsumablesEat have property healthPerSecond
					if(myself.getMaxHealth() < myself.getItsHealth()) {
						System.out.println("PlayerAction.eat Gained " + healthPerSecond + " health points in " + i + " seconds");
						myself.setItsHealth(myself.getItsHealth() + Math.round(healthPerSecond));
					}
					System.out.println("PlayerAction.eat maxHealth is " + myself.getMaxHealth() + "\tcurHealth is " + myself.getItsHealth());
					System.out.println("PlayerAction.eat Your health now is " + myself.getItsHealth() + " health points");
				} catch (InterruptedException e) {
					System.out.println("PlayerAction.eat Interrupting in line 140");
					e.printStackTrace();
				}
			}
			System.out.println("PlayerAction.eat Consuming a " + food.getItemType() + " from the Inventory");
			System.out.println("PlayerAction.eat You gained " + food.getItemHealth() +" health points");
		}
	}

	private void drink() {
		// ToDo This will work for all players
		// ToDo Wizards can conjure Drinks, all players can drink items
		System.out.println("PlayerAction.drink I can not find any drinks in your Inventory");
		System.out.println("PlayerAction.drink Visit an Inn to the nearest Town or Capital City");
		System.out.println("I currently have " + myself.getItsMana() + " / " + myself.getMaxMana() + " Mana Points");
		System.out.println("PlayerAction.drink Inside my Inventory I have");
		DrinkItem mana = new DrinkItem("Fresh Water", 10, 10, "Water");
		double[] manaDrinks = mana.createWaterBottle(myself, 15);
		for (double manaDrink : manaDrinks) {
			System.out.printf("PlayerAction.drink I see %f into %s inventory", manaDrink, myself.getName());
		}
		mana.useOne(myself, manaDrinks);
		mana.create(randomAction.nextInt());
	}

	private class PlayerChat extends TimerTask {

		private int lastAction;

		PlayerChat(int lastAction) {
			this.lastAction = lastAction;
		}

		public void run() {
			System.out.println("PlayerChat.run in PlayerAction line 84 LastAction = " + this.lastAction);
		}
	}
}
