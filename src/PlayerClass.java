/**
 * Created by wthered on 19/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class PlayerClass {

	private Player myself;

	PlayerClass(Player p) {
		this.myself = p;
		System.out.println("PlayerClass.PlayerClass");
	}

	void ShowAllianceClassesFor(Race racist) {
		System.out.println("PlayerClass.ShowAvailableClassesFor " + myself.getRaceName());
		switch (racist.raceID) {
			case 1:
				Human h = new Human(this.myself);
				myself.ClassID = h.selectClass();
				h.setHumanAttributes(racist);
				System.out.println("Humans (ClassID = " + myself.ClassID + ") can be wizards among others");
//				myself.ClassName = this.getAllianceClassName();
				break;
			case 2:
				Gnome regan = new Gnome(myself);
				myself.ClassID = regan.selectGnomeClass();
//				myself.ClassName = this.getAllianceClassName();
				regan.setGnomeAttributes(racist);
				System.out.println("Gnome can be Warlocks");
				break;
			case 3:
				// selectDwarfRace();
				System.out.println("Dwarfs are warriors");
				break;
			case 4:
				// selectElvenRace();
				System.out.println("Night Elves can be hunters");
				break;
			default:
				System.out.println("PlayerClass.ShowAvailableClassesFor never reaches " + racist.raceID);
				break;
		}
		// Setting For now
		// Will change after coding is complete
		myself.RaceName = "defaultClassName";
		myself.ClassName = this.getAllianceClassName();
	}

	private String getAllianceClassName() {
		switch (myself.ClassID) {
			case 1:
				myself.ClassName = "Wizard";
				break;
			case 2:
				myself.ClassName = "Paladin";
				break;
			case 3:
				myself.ClassName = "Priest";
				break;
			case 4:
				myself.ClassName = "Rogue";
				break;
			case 5:
				myself.ClassName = "Warrior";
				break;
			case 6:
				myself.ClassName = "Druid";
				break;
			case 7:
				myself.ClassName = "Hunter";
				break;
			case 8:
				myself.ClassName = "Warlock";
				break;
			case 9:
				myself.ClassName = "Shaman";
				break;
			case 10:
				myself.ClassName = "Monk";
				break;
			case 11:
				myself.ClassName = "Death Knight";
				break;
			default:
				myself.ClassName = "someAllianceClassName";
				System.out.println("PlayerClass.getAllianceClassName ClassID is never " + myself.ClassID);
		}
		return myself.ClassName;
	}
}