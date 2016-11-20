import java.util.Scanner;

/**
 * Created by wthered on 12/11/2016 3:23 μμ
 * The Project name is mmo.
 */
class Player implements playerInterface {

	// Player Attributes
	private static String Name;

	int level;
	private int money;

	// Health Variables
	/* The maximum amount of health a player
	** character has is determined by a
	** combination of the character's
	** level and stamina
	*/
	private int itsHealth;
	int maxHealth;

	// mana Variables
	private int itsMana;
	int maxMana;

	// playerFaction Setup
	static int FactionID;
	private String Faction;

	// playerRace Setup
	int RaceID;
	String RaceName;

	// playerClass SetUp
	int ClassID;
	String ClassName;

	// Sex setup
	private int itsSex;
	String itsSexName;

	// Position Related Stuff
	private static int itsX;
	private static int itsY;

	private String City;
	private String Area;

	Player(String newName, int newLevel, int FactionID, int RaceID, int classID) {
		this.setName(newName);
		this.setMoney(0);
		this.setLevel(newLevel);

		// Health Init
		this.setItsHealth(100 * newLevel);
		this.maxHealth = 100;

		// Mana Init
		this.setItsMana(150 * newLevel);
		this.maxMana = 150;

		Player.FactionID = FactionID;
		this.RaceID = RaceID;
		this.ClassID = classID;

//		System.out.println("Faction #" + FactionID + ", race = " + RaceID + ", Class = " + classID);
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

	private void setFaction(int faction) {
		FactionID = faction;
	}

	// Race ID
	private int getRaceID() {
		return this.RaceID;
	}

	private void setRaceID(int raceID) {
		this.RaceID = raceID;
	}

	// RaceName
	String getRaceName() {
		System.out.println("Player.getRaceName reports " + this.RaceName + " as raceName for " + this.ClassName );
		return this.RaceName;
	}

	// Methods inherited from playerInterface

	@Override
	public String getFaction() {
//		System.out.println("Player.getFaction");
		switch (FactionID) {
			case 1:
				this.Faction = "Alliance";
				break;
			case 2:
				this.Faction = "Horde";
				break;
			default:
				System.out.println("Neutral in Player.getFaction");
		}
		return this.Faction;
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

	void selectClass() {
		Faction f = new Faction(getFactionID());

		PlayerClass pc = new PlayerClass(this);
		switch (this.getFactionID()) {
			case 1:
				System.out.println(this.getName() + " will select Class for " + f.getFactionName() );
				pc.ShowAllianceClassesFor( this.RaceID );
				// PlayerClassID is set into the function above
				//this.setClassID(pClass);
				// fixme this.RaceName = null
				System.out.println("Player.selectClass Line 154 " + this.getName() + " is " + this.RaceName + " " + this.ClassName);
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
		return "Don Morogh";
	}

	public void setArea(String areaName) {
		Area = areaName;
	}

	// City
	public void setCity(String cityName) {
		City = cityName;
	}

	String getCity() {
		return "Ironforge";
	}

	// xAxis of Player
	public static int getItsX() {
		return itsX;
	}

	public static void setItsX(int itsX) {
		Player.itsX = itsX;
	}

	// yAxis of Player
	public static int getItsY() {
		return itsY;
	}

	public static void setItsY(int itsY) {
		Player.itsY = itsY;
	}

	/*
	** This should be called just after player
	** advances to next level
	*/
	public void setMaxHealth() {
		this.maxHealth = 100*this.level;
	}
}