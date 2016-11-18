import java.util.Scanner;

/**
 * Created by wthered on 12/11/2016 3:29 μμ
 * The Project name is mmo.
 */
class Race {

	private int raceStrength;
	private int raceAgility;
	private int raceStamina;
	private int raceIntellect;
	private int raceSpirit;

	private int raceID;
	private String raceName;

	Race() {
		this(20,20,20,20,20);
	}

	private Race(int Strength, int Agility, int Stamina, int Intellect, int Spirit) {
		this.raceStrength = Strength;
		System.out.println("Your race Strength is\t" + this.raceStrength);

		this.raceAgility = Agility;
		System.out.println("Your Race Agility is\t" + this.raceAgility);

		this.raceStamina = Stamina;
		System.out.println("Your Race Stamina is\t" + this.raceStamina);

		this.raceIntellect = Intellect;
		System.out.println("Your Race Intellect is\t" + this.raceIntellect);

		this.raceSpirit = Spirit;
		System.out.println("Your Race Spirit is\t" + Spirit);
	}

	// Strength
	public int getRaceStrength() {
		return this.raceStrength;
	}

	public void setRaceStrength(int raceStrength) {
		this.raceStrength = raceStrength;
	}

	// Agility
	public int getRaceAgility() {
		return this.raceAgility;
	}

	public void setRaceAgility(int raceAgility) {
		this.raceAgility = raceAgility;
	}

	// Stamina
	public int getRaceStamina() {
		return this.raceStamina;
	}

	public void setRaceStamina(int raceStamina) {
		this.raceStamina = raceStamina;
	}

	// Intellect
	public int getRaceIntellect() {
		return this.raceIntellect;
	}

	public void setRaceIntellect(int raceIntellect) {
		this.raceIntellect = raceIntellect;
	}

	// Spirit
	public int getRaceSpirit() {
		return this.raceSpirit;
	}

	public void setRaceSpirit(int raceSpirit) {
		this.raceSpirit = raceSpirit;
	}

	int selectAllianceRace() {
		System.out.println("******************");
		System.out.println("** 1) Human     **");
		System.out.println("** 2) Gnome     **");
		System.out.println("** 3) Dwarf     **");
		System.out.println("** 4) Night Elf **");
		System.out.println("******************");
		System.out.print("What race are you? ");
		Scanner raceScan = new Scanner(System.in);
		int alliance = raceScan.nextInt();
		this.setRaceID(alliance);
		return alliance;
	}

	int selectHordeRace() {
		System.out.println("******************");
		System.out.println("** 1) Orc       **");
		System.out.println("** 2) Undead    **");
		System.out.println("** 3) Troll     **");
		System.out.println("** 4) Blood Elf **");
		System.out.println("******************");
		System.out.print("What Race are you? ");
		Scanner hordeScanner = new Scanner(System.in);
		int horder = hordeScanner.nextInt();
		this.setRaceID(horder);
		return horder;
	}

	private int getRaceID() {
		return this.raceID;
	}

	private void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	String getRaceName(int FactionID) {
		System.out.println("Faction Selector in Race.getRaceName");
		switch (FactionID) {
			case 1:
				this.setAllianceRaceName();
//				this.setRaceName("Orc or Human");
				break;
			case 2:
				this.setHordeRaceName(this.getRaceID());
				break;
			default:
				System.out.println("This is never reached in Race.getRaceName");
				this.setRaceName("Darth Vader White");
				break;
		}
		return this.raceName;
	}

	private void setAllianceRaceName() {
		switch (this.getRaceID()) {
			case 1:
				this.setRaceName("Human");
				break;
			case 2:
				this.setRaceName("Gnome");
				break;
			case 3:
				this.setRaceName("Dwarf");
				break;
			case 4:
				this.setRaceName("Night Elf");
				break;
			default:
				System.out.println("This is never reached");
				break;
		}
		System.out.println("Setting Race as " + this.raceName);
	}

	private void setHordeRaceName(int raceID) {
		this.setRaceName("Orc or another");
		System.out.println("Race.setHordeRaceName Horde Race is " + raceID);
	}

	private void setRaceName(String raceName) {
		this.raceName = raceName;
	}
}