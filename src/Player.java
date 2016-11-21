import java.util.Scanner;

/**
 * Created by wthered on 12/11/2016 3:23 μμ
 * The Project name is mmo.
 */
class Player implements playerInterface {

	// playerFaction Setup
	static int FactionID;
	private static String Faction;

	// Player Attributes
	private static String Name;
	int maxHealth;
	int level;
	int RaceID;
	String RaceName;
	// playerClass SetUp
	int ClassID;
	String ClassName;
	String itsSexName;
	int maxMana;
	// Position Related Stuff
	private int itsX;
	private int itsY;
	// playerRace Setup
	private Race racist;
	private int money;
	// Health Variables
	/* The maximum amount of health a player
	** character has is determined by a
	** combination of the character's
	** level and stamina
	** playerHealth = 100*level + healthFromStamina
	** currentStamina = baseStamina + 2*level
	** Stamina provides 1 health per stamina for the first 20 points of stamina, and 14 health per point of stamina thereafter.
	** http://www.wowpedia.org/Attributes#Stamina
	*/
	private int itsHealth;
	// mana Variables
	private int itsMana;
	// Sex setup
	private int itsSex;
	private String City;
	private String Area;

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
		Player.FactionID = FactionID;
		Faction = "Alliance";

		/*
		** Race Initializer **
		** It is not sync'd **
		** with race Class  **
		*/
		this.RaceID = playRace.raceID;
		this.ClassID = classID;

//		System.out.println("Player.Player Faction #" + FactionID + ", race = " + this.RaceID + ", Class = " + classID);
	}

	// xAxis of Player
	private int getItsX() {
		System.out.println("Player.getItsX Currently X =" + this.itsX);
		return this.itsX;
	}

	private void setItsX(int itsX) {
		this.itsX = itsX;
	}

	// yAxis of Player
	private int getItsY() {
		return this.itsY;
	}

	private void setItsY(int itsY) {
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
		Name = playerName;
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

	private void setMoney(int money) {
		this.money = money;
	}

	// Health
	int getItsHealth() {
		return this.itsHealth;
	}

	private void setItsHealth(int itsHealth) {
		this.itsHealth = itsHealth;
	}

	// Mana
	int getItsMana() {
		return this.itsMana;
	}

	private void setItsMana(int itsMana) {
		this.itsMana = itsMana;
	}

	// Faction
	private int getFactionID() {
		return FactionID;
	}

	// Methods inherited from playerInterface

	// Race ID
	private int getRaceID() {
		return this.RaceID;
	}

	private void setRaceID(int raceID) {
		this.RaceID = raceID;
	}

	// RaceName
	String getRaceName() {
		System.out.println("Player.getRaceName reports " + this.getName() + " is " + this.RaceID + " " + this.ClassName);
		return this.RaceName;
	}

	@Override
	public String getFaction() {
		System.out.println("Player.getFaction");
		switch (FactionID) {
			case 1:
				Faction = "Alliance";
				break;
			case 2:
				Faction = "Horde";
				break;
			default:
				System.out.println("Neutral in Player.getFaction");
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
		switch (this.getFactionID()) {
			case 1:
//				System.out.println("Player.selectClass " + this.getName() + " will select Class for " + f.getFactionName());
				// todo playRace.getRaceName(this.RaceID)
				System.out.println("Player.selectClass The raceID is " + this.RaceID + " or " + playRace.raceID);
				System.out.println("Player.selectClass " + playRace.getRaceName(this.getFactionID()));
				pc.ShowAllianceClassesFor( playRace );
				// PlayerClassID is set into the function above
				//this.setClassID(pClass);
				// fixme this.RaceName = null
				this.RaceName = playRace.getRaceName(getFactionID());
				System.out.println("Player.selectClass Line 185 " + this.getName() + " is " + this.RaceName + " " + playRace.getRaceName(getFactionID()));
				break;
			case 2:
				System.out.println(this.getName() + " will select Class for " + f.getFactionName() );
				System.out.println("Player.selectClass Line 158");
				break;
			default:
				System.out.println("Player.selectClass Invalid Option " + this.getFactionID());
		}
	}

	void selectRace() {
		int raceID = 0;
		Race r = new Race();
		switch (this.getFactionID()) {
			case 1:
				System.out.println("You will select from Alliance Races");
				raceID = r.selectAllianceRace();
				break;
			case 2:
				System.out.println("You will select from Horde Races");
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

	void setClassID(int classID) {
		this.ClassID = classID;
	}

	void setSex(int sex) {
		switch (this.itsSex % 2) {
			case 0:
				this.itsSexName = "Female";
				break;
			case 1:
				this.itsSexName = "Male";
				break;
			default:
				System.out.println("Player sex is never " + this.itsSex + " in Player.setSex");
		}
		this.itsSex = sex;
	}

	String getPosition() {
		return "Bridge near Auction House";
	}

	// Area of Interest
	String getArea() {
		this.Area = "Don Morogh";
		return this.Area;
	}

	void setArea(String areaName) {
		this.Area = areaName;
	}

	String getCity() {
		this.City = "Ironforge";
		return this.City;
	}

	// City
	public void setCity(String cityName) {
		City = cityName;
	}

	/*
	** This should be called just after player
	** advances to next level
	*/
	public void setMaxHealth() {
		this.maxHealth = 100*this.level;
	}

	int getMaxHealth() {
		return maxHealth;
	}

	int getMaxMana() {
		return this.maxMana;
	}

	void travel(int newX, int newY) {
		System.out.println("Travelling from (" + this.getItsX() + "," + this.getItsY() + ")");
		this.setItsX(newX);
		this.setItsY(newY);
		System.out.println("Player.travel Reports (" + newX + ", " + newY + ")");
	}
}