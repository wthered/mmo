import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by wthered on 18/11/2016.
 * This is not the default Template
 */
class Human extends Race {

	private int HumanClassID;
	private static String HumanClass;
	private Player myself;

	Human(Player p) {
		this.myself = p;
		System.out.println("Human.Human Constructor");
	}

	int selectClass() {
		System.out.println("Human.selectClass");
		System.out.println("*****************");
		System.out.println("** 1) Magician **");
		System.out.println("** 2) Paladin  **");
		System.out.println("** 3) Priest   **");
		System.out.println("** 4) Rogue    **");
		System.out.println("** 5) Warlock  **");
		System.out.println("** 6) Warrior  **");
		System.out.println("** 7) Hunter   **");
		System.out.println("** 8) Monk     **");
		System.out.println("*****************");
		System.out.print("Select your Class, Human? ");
		Scanner humanScan = new Scanner(System.in);
		try {
			myself.ClassID = humanScan.nextInt();
			this.setHumanClassID(myself.ClassID);
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input in Human.selectClass");
			ex.printStackTrace();
		}
		return this.HumanClassID;
	}

	private void setHumanClassID(int humanClassID) {
		this.HumanClassID = humanClassID;
	}

	void setHumanAttributes(Race human) {
		switch (myself.ClassID) {
			case 1:
				this.setHumanClass("Mage");
				human.setRaceIntellect(23);
				human.setRaceSpirit(23);
				break;
			case 2:
				human.setRaceStrength(22);
				human.setRaceStamina(22);
				human.setRaceSpirit(22);
				this.setHumanClass("Paladin");
				break;
			case 3:
				human.setRaceIntellect(22);
				human.setRaceSpirit(24);
				this.setHumanClass("Priest");
				break;
			case 4:
				human.setRaceStrength(21);
				human.setRaceAgility(23);
				human.setRaceStamina(21);
				human.setRaceSpirit(21);
				this.setHumanClass("Rogue");
				break;
			case 5:
				human.setRaceStamina(21);
				human.setRaceIntellect(22);
				human.setRaceSpirit(23);
				this.setHumanClass("Warlock");
				break;
			case 6:
				human.setRaceStrength(23);
				human.setRaceStamina(22);
				human.setRaceSpirit(21);
				this.setHumanClass("Warrior");
				break;
			case 7:
				human.setRaceAgility(23);
				human.setRaceStamina(21);
				human.setRaceSpirit(21);
				this.setHumanClass("Hunter");
				break;
			case 8:
				human.setRaceStrength(21);
				human.setRaceAgility(21);
				human.setRaceStamina(21);
				human.setRaceIntellect(22);
				this.setHumanClass("Monk");
				break;
			default:
				System.out.println("Human.getHumanClass HumanClassID is never " + this.HumanClassID);
				HumanClass = "StarYoda";
		}
	}

	private void setHumanClass(String humanClass) {
		HumanClass = humanClass;
	}

}
