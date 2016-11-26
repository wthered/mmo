import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by wthered on 12/11/2016 3:23 μμ
 * The Project name is mmo.
 */
class Player implements playerInterface {

	// playerFaction Setup
	private int FactionID;
	private String Faction;

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
		Bag foods = new Bag("FoodBag", 4, 8, foodHashTab);
		this.inventory = new PlayerInventory(foods);
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

	@Override
	public String getFaction() {
//		System.out.println("Player.getFaction");
		switch (FactionID) {
			case 1:
				Faction = "Alliance";
				break;
			case 2:
				Faction = "Horde";
				break;
			default:
				Faction = "Neutral";
				System.out.println("Player.getFaction Faction is never " + Faction + "\nSetting to Neutral");
		}
		return Faction;
	}

	private void setFaction(int faction) {
		FactionID = faction;
	}

	// The Game has started and we set the new created Player
	void selectFaction() {
		System.out.println("*****************");
		System.out.println("** 1) Alliance **");
		System.out.println("** 2) Horde    **");
		System.out.println("*****************");
		System.out.print("What Faction you want to join? ");
		Scanner faction = new Scanner(System.in);
		int selectedFaction = faction.nextInt();
		this.setFaction(selectedFaction);
	}

	void selectClass(Race playRace) {
		Faction f = new Faction(getFactionID());

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

	/*
	** This should be called just after player
	** advances to next level
	*/
//	public void setMaxHealth() {
//		this.maxHealth = 100*this.level;
//	}

	int getMaxHealth() {
		return maxHealth;
	}

	int getMaxMana() {
		return this.maxMana;
	}

	void travel(int newX, int newY) {
		System.out.println("Player.travel Travelling from (" + this.getItsX() + "," + this.getItsY() + ") to (" + newX + ", " + newY + ")");
		this.setItsX(newX);
		this.setItsY(newY);
		System.out.println("Player.travel " + this.getName() + " is at (" + this.getItsX() + "," + this.getItsY() + ")");
	}

	String getClassName() {
		return this.ClassName;
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
		Random pos = new Random();
		switch (pos.nextInt() % 2) {
			case 1:
				this.setPosition("Entrance");
				break;
			default:
				this.setPosition("Auction House");
				break;
		}
		System.out.println("Player.setStartingCity You are a " + this.getRaceName() + " in " + this.getCity() + " of " + this.getArea());
	}

	void setRaceName(String raceName) {
		this.RaceName = raceName;
	}

	void seeInsideInv() {
		Hashtable<FoodItem, Integer> invFoods = this.inventory.getFoodBag();
		Hashtable<DrinkItem,Integer> invDrink = this.inventory.getManaBag();
		Hashtable<Potion, Integer> invPotions = this.inventory.getPotions();
		System.out.println("Player.seeInsideInv Start Food");
		inventory.selectFood();
		inventory.selectMana();
		inventory.selectPots();
		System.out.println("Player.seeInsideInv *End* Food");
	}

	void setClassName(String className) {
		this.ClassName = className;
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

	public Race getPlayerRace() {
		return this.playerRace;
	}

	public void setFactionID(int factionID) {
		FactionID = factionID;
	}

	public void setFaction(String faction) {
		this.Faction = faction;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	PlayerInventory getInventory() {
		return this.inventory;
	}

	public void setInventory(PlayerInventory inventory) {
		this.inventory = inventory;
	}

	public void setPlayerRace(Race playerRace) {
		this.playerRace = playerRace;
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
}