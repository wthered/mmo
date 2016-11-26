import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		System.out.println("** 6) Go to City                           **");
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
		System.out.println(myself.getName() + " is level " + myself.getLevel() );
		System.out.println("I currently have " + myself.getItsHealth() + " Health Points of " + myself.getMaxHealth()+ " max");
		System.out.println("I currently have " + myself.getItsMana() + " mana points of " + myself.getMaxMana() + " max");
		System.out.println("I have " + Main.convertMoney(myself.getMoney()));
		System.out.println("I have " + myself.getExperience() + " experience" );
		System.out.println("You can find me near " + myself.getPosition() + " of " + myself.getCity() + ", " + myself.getArea());
		System.out.println("My exact Location is (" + myself.getItsX() + "," + myself.getItsY() + ")");
		System.out.println("Last Action of " + myself.getName() + " is " + this.getLastAction());

		// TODO: 26/11/2016 cout << ... << " and 25 Intellect from Armory"
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

		/* **********************************************************************
		** TODO: 2/11/2016 1) look into Inventory to see if foodIsAvailable()
		** TODO: 2/11/2016 2) look into Inventory to see if drinkIsAvailable()
		************************************************************************/
		switch (this.getLastAction()) {
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
				Quest quest = new Quest(myself, questID.nextInt(100), questID.nextInt(100), "Elwyn Forest");
				// TODO: 26/11/2016 Create a function that returns array of Quest like this
				quest.doQuest(myself.getName().length());
				System.out.println("PlayerAction.doAction " + myself.getName() + " is around? " + quest.playerIsAround(questID.nextInt(5)));
				this.fun(questID);
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
				PlayerInventory myInventory = myself.getInventory();
				System.out.println("PlayerAction.doAction Looking into my Inventory");
				System.out.println("PlayerAction.doAction Found " + myInventory.getPotions().size());
				// TODO: 26/11/2016 myself.getInventory();
				FoodItem bread = new FoodItem("Minor Healing Bread", 61, 18, "food");
				FoodItem loaf = new FoodItem("Major Healing Loaf", 243, 21, "food");
				myInventory.insertFood(bread, 10);
				myInventory.insertFood(loaf, 1);
				myself.seeInsideInv();
				break;
			default:
				String reason = "Not implemented yet in PlayerAction.doAction for " + this.getLastAction();
				InterruptedException ex = new InterruptedException(reason);
				ex.printStackTrace();
		}
	}

	private void fun(Random r) {
		List<Quest> quests = new ArrayList<>(5);
		for (Quest quest : quests) {
			quest = new Quest(myself, r.nextInt(100), r.nextInt(100), "Elwyn Forest");
			quest.doQuest(quests.size());
			quests.remove(quests.size());
			System.out.println("PlayerAction.fun Have done with quest #" + quests.size());
		}
		System.out.println("PlayerAction.fun Have done some quests");
	}

	private void eat() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int oldPlayerHealth = myself.getItsHealth();
		if(myself.getItsHealth() >= myself.getMaxHealth()) {
			myself.setItsHealth(myself.getMaxHealth());
			System.out.println("Already have max Health. Can not eat more");
		} else {
			// TODO: 26/11/2016 Να παίρνει αντικείμενα από το Player.inventory
			FoodItem food = new FoodItem("Potato Bread", 61, 18, "Bread");
			int foodGain = Math.round(food.getHealthPerTick());
			for (int i = 0; i < food.getItemTime(); i++) {
				try {
					TimeUnit.SECONDS.sleep(5);
					Date date = new Date();
					if(myself.getMaxHealth() > myself.getItsHealth()) {
						myself.setItsHealth(myself.getItsHealth() + foodGain);
						System.out.println("PlayerAction.eat Gained " + foodGain + " health points on time " + dateFormat.format(date));
					} else {
						System.out.println("PlayerAction.eat You have max health (" + myself.getItsHealth() + ") and feeling well");
					}
				} catch (InterruptedException e) {
					System.out.println("PlayerAction.eat Interrupting in line 140");
					e.printStackTrace();
				}
			}
			int newPlayerHealth = myself.getItsHealth();
			int gainedHealth = newPlayerHealth - oldPlayerHealth;
			System.out.println("PlayerAction.eat Consumed a " + food.getItemType() + " from the Inventory");
			System.out.println("PlayerAction.eat You gained " + gainedHealth +" health points and now have " + myself.getItsHealth() + " HP");
		}
	}

	private void drink() {
		PlayerInventory myInv = myself.getInventory();
		// TODO: 26/11/2016 This will work for all players
		// TODO: 26/11/2016 Wizards can conjure Drinks, all players can drink items
		System.out.println("PlayerAction.drink I can not find any drinks in your Inventory");
		System.out.println("PlayerAction.drink Visit an Inn to the nearest Town or Capital City");
		System.out.println("PlayerAction.drink I currently have " + myself.getItsMana() + " / " + myself.getMaxMana() + " Mana Points");
		System.out.println("PlayerAction.drink Inside my Inventory I have");
		DrinkItem mana = new DrinkItem("Fresh Water", 90, 15, "Water");
		// TODO: 26/11/2016 All bags are unified and we should use the unified inventory
		Hashtable<DrinkItem, Integer> manaDrinks = myInv.getManaBag();
		manaDrinks.put(mana, 20);
		myself.seeInsideInv();
		mana.useOne(myself);
		System.out.println("PlayerAction.drink I currently have " + myself.getItsMana() + " / " + myself.getMaxMana() + " Mana Points");
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

	private int getLastAction() {
		return lastAction;
	}
}