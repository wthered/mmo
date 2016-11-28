import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by wthered on 12/11/2016 3:23 μμ
 * The Project name is mmo.
 */
class Player implements playerInterface {

	// playerFaction Setup
	private int FactionID;

	// Player Attributes
	private String Name;

	private String ClassName;
	private int maxHealth;
	private int level;
	private int RaceID;

	private String RaceName;
	// playerClass SetUp
	private int ClassID;

	// placeHolder for later (see toDo section in Main.java)
	private boolean inBattle = false;

	// Position Related Stuff
	private int itsX;
	private int itsY;
	private String Position;

	// playerRace Setup
	private int money;
	// Health Variables
	/* *************************************************
	** The maximum amount of health a player
	** character has is determined by a
	** combination of the character's
	** level and stamina
	** playerHealth = 100*level + healthFromStamina
	** currentStamina = baseStamina + 2*level
	** Stamina provides 1 health per stamina for the first 20 points of stamina, and 14 health per point of stamina thereafter.
	** http://www.wowpedia.org/Attributes#Stamina
	***************************************************/
	private int itsHealth;

	// mana Variables
	private int itsMana;
	private int maxMana;

	// Sex setup
	private int itsSex;
	private String City;
	private String Area;
	private boolean inCity;

	// Experience Handler
	private int experience;

	// TODO: 26/11/2016 Add Potions Bag that Accepts only Potions (l8r extra herbsBag)

	// my Inventory implementation
	private PlayerInventory inventory;

	private Race playerRace;

	// Player Basic Attributes
	private int strength;
	private int agility;
	private int stamina;
	private int intellect;
	private int spirit;

	Player(String newName, int newLevel, int FactionID, Race playRace, int classID) {

		this.setName(newName);
		this.setMoney(0);
		this.setLevel(newLevel);

		// Health Init
		this.setItsHealth(100 * newLevel);
		this.maxHealth = 100;

		// Mana Init
		this.setItsMana(150 * newLevel);
		this.maxMana = 150;

		// Faction Initializer
		this.setFaction(FactionID);
//		Faction = "Alliance";

		/* *******************
		** Race Initializer **
		** It is not sync'd **
		** with race Class  **
		*********************/
		// TODO: 26/11/2016 Do the Sync (read above)
		this.playerRace = playRace;
		this.setRaceID(playRace.getRaceID());
		this.ClassID = classID;

		// All the foods that mobs drop are here
		Hashtable<Item, Integer> foodHashTab = new Hashtable<>();
		Hashtable<Weapon, Integer> drinksTabs = new Hashtable<>();
		Hashtable<Potion, Integer> potionHashtable = new Hashtable<>();

		// TODO: 27/11/2016 if(Player.getProfession() == "Alchemy") { ... }
		Hashtable<Herb, Integer> herbsHashtable = new Hashtable<>();

		// We define the bags each Player (actually the slots into the inventory) has
		Bag foods = new Bag("FoodBag", 4, 8, foodHashTab);
		weaponBag drinks = new weaponBag("Drinks", 3, 4, drinksTabs);
		potionBag potion = new potionBag("Potions Bag", 4, 3, potionHashtable);
		herbalismBag herbs = new herbalismBag("Herbalism Bag", 4, 4, herbsHashtable);
		this.inventory = new PlayerInventory(foods, drinks, potion, herbs);
//		System.out.println("Player.Player Faction #" + FactionID + ", race = " + this.RaceID + ", Class = " + classID);
	}

	// xAxis of Player
	int getItsX() {
		System.out.println("Player.getItsX Currently X = " + this.itsX);
		return this.itsX;
	}

	void setItsX(int itsX) {
		this.itsX = itsX;
	}

	// yAxis of Player
	int getItsY() {
		System.out.println("Player.getItsY Currently Y = " + this.itsY);
		return this.itsY;
	}

	void setItsY(int itsY) {
		this.itsY = itsY;
	}

	/*********************
	 ** Setter & Getters **
	 *********************/

	// playerName
	public String getName() {
		return Name;
	}

	void setName(String playerName) {
		this.Name = playerName;
	}

	// Level
	int getLevel() {
		return this.level;
	}

	private void setLevel(int level) {
		this.level = level;
	}

	// Money money money
	int getMoney() {
		return this.money;
	}

	void setMoney(int money) {
		this.money = money;
	}

	// Health
	int getItsHealth() {
		return this.itsHealth;
	}

	void setItsHealth(int itsHealth) {
		this.itsHealth = itsHealth;
	}

	// Mana
	int getItsMana() {
		return this.itsMana;
	}

	void setItsMana(int itsMana) {
		this.itsMana = itsMana;
	}

	// Faction
	int getFactionID() {
		return this.FactionID;
	}

	// Methods inherited from playerInterface

	public void setFactionID(int factionID) {
		this.FactionID = factionID;
	}

	// Race ID
	int getRaceID() {
		return this.RaceID;
	}

	private void setRaceID(int raceID) {
		this.RaceID = raceID;
	}

	// RaceName
	String getRaceName() {
//		System.out.print("Player.getRaceName reports " + this.getName() + " is " + this.RaceName + " " + this.getClassName());
//		System.out.println(" in " + this.getPosition() + " of " + this.getCity() + " of " + this.getArea());
		return this.RaceName;
	}

	void setRaceName(String raceName) {
		this.RaceName = raceName;
	}

	@Override
	public String getFaction() {
//		System.out.println("Player.getFaction");
		String faction;
		switch (FactionID) {
			case 1:
				faction = "Alliance";
				break;
			case 2:
				faction = "Horde";
				break;
			default:
				faction = "Neutral";
				System.out.println("Player.getFaction Faction is never " + faction + "\nSetting to Neutral");
		}
		return faction;
	}

	private void setFaction(int faction) {
		this.FactionID = faction;
	}

	// The Game has started and we set the new created Player
	void selectFaction() {
		System.out.println("*****************");
		System.out.println("** 1) Alliance **");
		System.out.println("** 2) Horde    **");
		System.out.println("*****************");
		System.out.print("What Faction you want to join? ");
		Scanner faction = new Scanner(System.in);
		this.setFaction(faction.nextInt());
	}

	void selectClass(Race playRace) {
		Faction f = new Faction(this.getFactionID());

		// Set the RaceID Properly
		playRace.setRaceID(this.RaceID);

		// Set the RaceName for Alliance Races
		playRace.setAllianceRaceName();

		PlayerClass pc = new PlayerClass(this);
		pc.ShowAllianceClassesFor( playRace );
		switch (this.getFactionID()) {
			case 1:
//				pc.ShowAllianceClassesFor( playRace );
				// FIXME: 26/11/2016 this.getRaceName() = null
				System.out.println("Player.selectClass Line 244 " + this.getName() + " is " + this.getRaceName() + "\t" + this.getClassName());
				break;
			case 2:
				System.out.println("Player.selectClass " + this.getName() + " will select Class for " + f.getFactionName() );
				break;
			default:
				System.out.println("Player.selectClass Invalid Option " + this.getFactionID());
		}
		this.RaceName = playRace.getRaceName(this.getFactionID());
	}

	void selectRace() {
		int raceID = 0;
		Race r = new Race();
		switch (this.getFactionID()) {
			case 1:
				System.out.println("Player.selectRace You will select from Alliance Races");
				raceID = r.selectAllianceRace();
				break;
			case 2:
				System.out.println("Player.selectRace You will select from Horde Races");
				raceID = r.selectHordeRace();
				break;
			default:
				System.out.println("Player.selectRace invalid Option");
				System.out.println("We will join you in Neutral");
				this.setFaction(0);
		}

		this.setRaceID(raceID);
//		System.out.println("Player.selectRace is " + r.getRaceName(this.getFactionID()) + " from " + this.getFaction());
	}

	void setSex(int newSex) {
		switch (newSex % 2) {
			case 0:
				break;
			case 1:
				break;
			default:
				System.out.println("Player.setSex Player sex is never " + this.itsSex);
		}
		this.itsSex = newSex;
	}

	// TODO: 28/11/2016 Look around this.getPosition() και αν βρεις τέρατα μετρησέ τα και πες μου πόσα είναι
	public int lookAround(Mob ogre, int areaSize) {
		int mobsAround = 0;
		double distance;
//		double doubleX = this.itsX;
//		double doubleY = this.itsY;

		// Area size is what we call radius is that other function
		ogre.setLineOfSight( Math.sqrt( 2 * Math.pow(  areaSize, 2) ) );

		for (int i = 0; i < areaSize; i++) {
			for (int j = 0; j < areaSize; j++) {
				distance = Math.sqrt( Math.pow(this.getItsX() - ogre.getItsX(), 2) + Math.pow(this.getItsY() - ogre.getItsY(), 2) );

				// If the mob is in one of the 8 neighboring squares, the mob is near the Player and should Attack him
				if(distance > Math.sqrt(ogre.getLineOfSight())) {
					System.out.println("Player.lookAround Mob Found in (" + i + "," + j + ")");
					System.out.println("Player.lookAround You are at (" + this.getItsX() + "," + this.getItsY() + ")");
					mobsAround++;
				}
			}
		}
		return mobsAround;
	}

	String getPosition() {
		return this.Position;
	}

	private void setPosition(String position) {
		this.Position = position;
	}

	// Area of Interest
	String getArea() {
		return this.Area;
	}

	/*
	** This should be called just after player
	** advances to next level
	*/
//	public void setMaxHealth() {
//		this.maxHealth = 100*this.level;
//	}

	void setArea(String areaName) {
		this.Area = areaName;
	}

	String getCity() {
		return this.City;
	}

	// City
	void setCity(String cityName) {
		this.City = cityName;
	}

	int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	int getMaxMana() {
		return this.maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	void travel(int newX, int newY) throws InterruptedException {
		System.out.println("Player.travel Travelling from (" + this.getItsX() + "," + this.getItsY() + ") to (" + newX + ", " + newY + ")");
		for(int x = this.getItsX(); x < newX; x++) {
			TimeUnit.SECONDS.wait(5);
			for (int y = 0; y < newY; y++) {
				TimeUnit.SECONDS.wait(5);
				this.setItsY(y);
			}
			this.setItsX(x);
		}
		this.setItsX(newX);
		this.setItsY(newY);
		System.out.println("Player.travel " + this.getName() + " is at (" + this.getItsX() + "," + this.getItsY() + ")");
	}

	String getClassName() {
		return this.ClassName;
	}

	void setClassName(String className) {
		this.ClassName = className;
	}

	int getClassID() {
		return this.ClassID;
	}

	void setClassID(int classID) {
		this.ClassID = classID;
	}

	int getExperience() {
		return this.experience;
	}

	void setExperience(int experience) {
		this.experience = experience;
	}

	void setStartingCity() {
		switch (this.getRaceName()) {
			case "Human":
				this.setCity("Stormwind");
				this.setArea("Elwyn Forest");
				break;
			case "Gnome":
			case "Dwarf":
				this.setCity("Ironforge");
				this.setArea("Dun Morogh");
				break;
			case "Night Elf":
				this.setCity("Shadowglen");
				this.setArea("Teldrassil");
				break;
			case "Orc":
				this.setCity("Orgrimmar");
				this.setArea("Durotar");
				break;
			case "Undead":
				this.setCity("Deathknell");
				this.setArea("Tirisfal Glades");
				break;
			case "Troll":
				this.setCity("Valley of Trials");
				this.setArea("Durotar");
				break;
			case "Blood Elf":
				this.setCity("Sunstrider Isle");
				this.setArea("Eversong Woods");
				break;
			default:
				System.out.println("Player.setStartingCity You can't be a " + this.getRaceName() + "!!");
				this.setCity("CityName");
				this.setArea("AreaName");
		}

		// Position in Starting City
		if (new Random().nextBoolean()) {
			this.setPosition("Entrance");
		} else {
			this.setPosition("Auction House");
		}
		System.out.println("Player.setStartingCity You are a " + this.getRaceName() + " in " + this.getCity() + " of " + this.getArea());
	}

	void seeInsideInv() {
		Hashtable<Item, Integer> invFoods = this.inventory.getItemBag();
		Hashtable<Weapon, Integer> weapons = this.inventory.getWeapons();
		Hashtable<Potion, Integer> invPotions = this.inventory.getPotions();
		System.out.println("Player.seeInsideInv Start");
		inventory.selectItem();
		inventory.selectWeapon();
		inventory.selectPots();
		System.out.println("Player.seeInsideInv *End*");
	}

	public boolean isInBattle() {
		return this.inBattle;
	}

	void setInBattle(boolean inBattle) {
		this.inBattle = inBattle;
	}

	int getItsSex() {
		return this.itsSex;
	}

	public void setItsSex(int itsSex) {
		this.itsSex = itsSex;
	}

	Race getPlayerRace() {
		return this.playerRace;
	}

	public void setPlayerRace(Race playerRace) {
		this.playerRace = playerRace;
	}

	PlayerInventory getInventory() {
		return this.inventory;
	}

	public void setInventory(PlayerInventory inventory) {
		this.inventory = inventory;
	}

	int getStrength() {
		return this.strength;
	}

	void setStrength(int strength) {
		this.strength = strength;
	}

	int getAgility() {
		return this.agility;
	}

	void setAgility(int agility) {
		this.agility = agility;
	}

	int getStamina() {
		return this.stamina;
	}

	void setStamina(int stamina) {
		this.stamina = stamina;
	}

	int getIntellect() {
		return this.intellect;
	}

	void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	int getSpirit() {
		return this.spirit;
	}

	void setSpirit(int spirit) {
		this.spirit = spirit;
	}

	boolean isInCity() {
		return this.inCity;
	}

	void setInCity(boolean inCity) {
		this.inCity = inCity;
	}
}