import java.util.Scanner;

/**
 * Created by wthered on 12/11/2016 3:23 μμ
 * The Project name is mmo.
 */
class Player implements playerInterface {

	// Player Attributes
	private String Name;
	private int level;
	private int money;
	private int health;
	private int mana;
	int FactionID;
	private String Faction;
	int RaceID;
	int ClassID;
	private int itsSex;
	private String itsSexName;

	Player(String newName, int newLevel, int FactionID, int RaceID, int classID) {
		this.setName(newName);
		this.setHealth(100 * newLevel);
		this.setMana(150 * newLevel);
		this.setMoney(0);

		this.FactionID = FactionID;
		this.RaceID = RaceID;
		this.ClassID = classID;

		System.out.println("Faction #" + FactionID + ", race = " + RaceID + ", Class = " + classID);
	}

	/*********************
	 ** Setter & Getters **
	 *********************/

	// playerName
	String getName() {
		return this.Name;
	}

	void setName(String name) {
		this.Name = name;
	}

	// Level
	public int getLevel() {
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
	int getHealth() {
		return this.health;
	}

	private void setHealth(int health) {
		this.health = health;
	}

	// Mana
	int getMana() {
		return this.mana;
	}

	private void setMana(int mana) {
		this.mana = mana;
	}

	// Faction
	private int getFactionID() {
		return this.FactionID;
	}

	private void setFaction(int faction) {
		this.FactionID = faction;
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
		switch (this.FactionID) {
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
		return this.health;
	}

	@Override
	public int showMana() {
		System.out.println("Player.showMana");
		return this.mana;
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
		Faction f = new Faction(this.getFactionID());
		switch (this.getFactionID()) {
			case 1:
				System.out.println("Faction " + f.getFactionName());
				System.out.println("Player.selectClass Line 129 RaceID is " + this.getRaceID());
				break;
			case 2:
				f.getFactionName();
				System.out.println("Player.selectClass Line 132");
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
		System.out.print("Player.selectRace is " + this.getRaceID() + " or " + r.getRaceName(this.getFactionID()) );
		System.out.println(" from " + this.getFaction());
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