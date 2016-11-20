/**
 * Created by wthered on 19/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class PlayerClass {

	private Player myself;
	private String PlayerClassName;

	PlayerClass(Player p) {
		this.myself = p;
		System.out.println("PlayerClass.PlayerClass");
	}

	void ShowAllianceClassesFor(int racist) {
		System.out.println("PlayerClass.ShowAvailableClassesFor " + racist);
		switch (racist) {
			case 1:
				Human h = new Human();
				myself.ClassID = h.selectClass();
				System.out.println("Humans (ClassID = " + myself.ClassID +") can be magician among others");
				myself.ClassName = this.getAllianceClassName();
				System.out.println(myself.getName() + " is a " + this.PlayerClassName);
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
	}

	private String getAllianceClassName() {
		switch (myself.ClassID) {
			case 1:
				this.PlayerClassName = "Mage";
				break;
			case 2:
				this.PlayerClassName = "Paladin";
				break;
			case 3:
				this.PlayerClassName = "Priest";
				break;
			case 4:
				this.PlayerClassName = "Rogue";
				break;
			default:
				this.PlayerClassName = "someAllianceClassName";
				System.out.println("PlayerClass.getAllianceClassName Βαριέμαι τώρα και έχω πονοκέφαλο");
		}
		return this.PlayerClassName;
	}
}
