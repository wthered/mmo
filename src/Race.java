import java.util.Scanner;

/**
 * Created by wthered on 12/11/2016 3:29 μμ
 * The Project name is mmo.
 */
class Race {

	int raceID;
	private String raceName;
	private int raceStrength;
	private int raceAgility;
	private int raceStamina;
	private int raceIntellect;
	private int raceSpirit;

	Race() {
		this(20,20,20,20,20);
	}

	private Race(int Strength, int Agility, int Stamina, int Intellect, int Spirit) {
		this.raceStrength = Strength;
//		System.out.println("Your Race Strength is\t" + this.raceStrength);

		this.raceAgility = Agility;
//		System.out.println("Your Race Agility is\t" + this.raceAgility);

		this.raceStamina = Stamina;
//		System.out.println("Your Race Stamina is\t" + this.raceStamina);

		this.raceIntellect = Intellect;
//		System.out.println("Your Race Intellect is\t" + this.raceIntellect);

		this.raceSpirit = Spirit;
//		System.out.println("Your Race Spirit is\t\t" + this.raceSpirit);
	}

	// Strength
	int getRaceStrength() {
		return this.raceStrength;
	}

	void setRaceStrength(int raceStrength) {
		this.raceStrength = raceStrength;
	}

	// Agility
	int getRaceAgility() {
		return this.raceAgility;
	}

	void setRaceAgility(int raceAgility) {
		this.raceAgility = raceAgility;
	}

	// Stamina
	int getRaceStamina() {
		return this.raceStamina;
	}

	void setRaceStamina(int raceStamina) {
		this.raceStamina = raceStamina;
	}

	// Intellect
	public int getRaceIntellect() {
		return this.raceIntellect;
	}

	void setRaceIntellect(int raceIntellect) {
		this.raceIntellect = raceIntellect;
	}

	// Spirit
	int getRaceSpirit() {
		return this.raceSpirit;
	}

	void setRaceSpirit(int raceSpirit) {
		this.raceSpirit = raceSpirit;
	}

	int selectAllianceRace() {
		System.out.println("Race.selectAllianceRace");
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
		int horde = hordeScanner.nextInt();
		this.setRaceID(horde);
		return horde;
	}

	private int getRaceID() {
		return this.raceID;
	}

	void setRaceID(int raceID) {
		this.raceID = raceID;
	}

	String getRaceName(int FactionID) {
		switch (FactionID) {
			case 1:
				this.setAllianceRaceName();
				break;
			case 2:
				this.setHordeRaceName(this.getRaceID());
				break;
			default:
				System.out.println("Race.getRaceName This is never reached");
				this.setRaceName("StarTrooper");
				break;
		}
		return this.raceName;
	}

	void setAllianceRaceName() {
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
				System.out.println("Race.setAllianceRaceName\tRaceID is never " + this.getRaceID());
				break;
		}
		System.out.println("Race.setAllianceRaceName Setting Race as " + this.raceName);
	}

	private void setHordeRaceName(int raceID) {
		this.setRaceName("Orc");
		System.out.println("Race.setHordeRaceName Horde Race is " + raceID);
	}

	private void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	void setPlayerAttributes(Player p) {
		System.out.println("Race.setPlayerAttributes Player is " + p.getRaceName() );
	}
}