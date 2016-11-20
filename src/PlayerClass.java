/**
 * Created by wthered on 19/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class PlayerClass {

	private Player myself;

	PlayerClass(Player p) {
		this.myself = p;
//		System.out.println("PlayerClass.PlayerClass");
	}

	void ShowAllianceClassesFor(int racist) {
//		System.out.println("PlayerClass.ShowAvailableClassesFor " + myself.getRaceName());
		switch (racist) {
			case 1:
				Human h = new Human(this.myself);
				myself.ClassID = h.selectClass();
				System.out.println("Humans (ClassID = " + myself.ClassID +") can be magician among others");
				myself.ClassName = this.getAllianceClassName();
				break;
			case 2:
				// selectGnomeRace();
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
				System.out.println("PlayerClass.ShowAvailableClassesFor never reaches " + racist);
				break;
		}
		myself.RaceName = "Human";
	}

	private String getAllianceClassName() {
		switch (myself.ClassID) {
			case 1:
				myself.ClassName = "Mage";
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
			default:
				myself.ClassName = "someAllianceClassName";
				System.out.println("PlayerClass.getAllianceClassName Βαριέμαι τώρα και έχω πονοκέφαλο");
		}
		return myself.ClassName;
	}
}
