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
	private int itsHealth;
	int maxHealth;

	// mana Variables
	private int itsMana;
	int maxMana;

	// playerFaction Setup
	int FactionID;
	private String Faction;

	// playerRace Setup
	int RaceID;
	private String RaceName;

	// playerClass SetUp
	int ClassID;
	String ClassName;

	// Sex setup
	private int itsSex;
	String itsSexName;

	public String getRaceName() {
		System.out.println("Player.getRaceName sets raceName to <sth> for " + this.getRaceID() );
		return this.RaceName;
	}

	public void setRaceName(String raceName) {
		System.out.println("Player.setRaceName faction is " + this.Faction);
		this.RaceName = raceName;
	}

	Player(String newName, int newLevel, int FactionID, int RaceID, int classID) {
		this.setName(newName);
		this.setItsHealth(100 * newLevel);
		this.setItsMana(150 * newLevel);
		this.setMoney(0);

		this.FactionID = FactionID;
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

	public void setLevel(int level) {
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
		return this.FactionID;
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

	// Methods inherited from playerInterface
	@Override
	public int showMoney() {
		System.out.println("Player.showMoney");
		return this.money;
	}

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

	@Override
	public int showHealth() {
		System.out.println("Player.showHealth");
		return this.itsHealth;
	}

	@Override
	public int showMana() {
		System.out.println("Player.showMana");
		return this.itsMana;
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

		// Test
		PlayerClass pc = new PlayerClass(this);
		switch (this.getFactionID()) {
			case 1:
				System.out.println(this.getName() + " will select Class for " + f.getFactionName() );
				pc.ShowAllianceClassesFor( this.RaceID );
				// PlayerClassID is set into the function above
				//this.setClassID(pClass);
				// fixme this.RaceName = null
				System.out.println("Player.selectClass Line 154 RaceID is " + this.getRaceID() + " or " + this.ClassName);
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

	int getClassID() {
		return this.ClassID;
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
}