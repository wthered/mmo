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

	Race() {
		this(20,20,20,20,20);
	}

	private Race(int Strength, int Agility, int Stamina, int Intellect, int Spirit) {
		System.out.println("Your race Strength is\t" + Strength);
		System.out.println("Your Race Agility is\t" + Agility);
		System.out.println("Your Race Stamina is\t" + Stamina);
		System.out.println("Your Race Intellect is\t"+ Intellect);
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
		return raceStamina;
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
        return raceScan.nextInt();
    }

    int selectHordeRace() {
        System.out.println("******************");
        System.out.println("** 1) Orc       **");
        System.out.println("** 2) Undead    **");
        System.out.println("** 3) Blood Elf **");
        System.out.println("** 4) Troll     **");
        System.out.println("******************");
        Scanner hordeScanner = new Scanner(System.in);
        return hordeScanner.nextInt();
    }
}