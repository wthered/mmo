import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by wthered on 21/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class Gnome {

	// MySelf is a gnome
	private Player me;

	Gnome(Player myself) {
		this.me = myself;
	}

	int selectGnomeClass() {
		int gnomeClass;
		System.out.println("**********************");
		System.out.println("** 1) Wizard / Mage **");
		System.out.println("** 2) Rogue         **");
		System.out.println("** 3) Warlock       **");
		System.out.println("** 4) Warrior       **");
		System.out.println("** 5) Monk          **");
		System.out.println("** 6) Death Knight  **");
		System.out.println("**********************");
		System.out.print("What is your class " + me.getRaceName() + "? ");
		Scanner gScan = new Scanner(System.in);
		try {
			gnomeClass = this.setGnomeClass(gScan.nextInt() % 7);
			me.setClassID(gnomeClass);
		} catch (InputMismatchException ex) {
			System.out.println("Gnome.selectGnomeClass Exception");
			ex.printStackTrace();
		}
		// Setting our Gnome to be Monk
		System.out.println("Gnome.selectGnomeClass Your Gnome class is #" + me.getClassID() + " or " + this.setGnomeClass(me.getClassID()));
		return me.getClassID();
	}

	private int setGnomeClass(int gone) {
		int properClassID = 1;
		switch (gone) {
			case 1:
				properClassID = 1;
				break;
			case 2:
				properClassID = 4;
				break;
			case 3:
				properClassID = 8;
				break;
			case 4:
				properClassID = 5;
				break;
			case 5:
				properClassID = 10;
				break;
			case 6:
				properClassID = 11;
				break;
			default:
				System.out.println("Gnome.setGnomeClass You can not select " + gone);
				break;
		}
		return properClassID;
	}

	void setGnomeAttributes(Race r) {
		r.setRaceStrength(15);
		r.setRaceAgility(23);
		r.setRaceStamina(19);
		r.setRaceIntellect(23);
		r.setRaceSpirit(20);
		System.out.println("Gnome.setGnomeAttributes " + r.getRaceName(me.getFactionID()) + " attributes have been set");
	}
}