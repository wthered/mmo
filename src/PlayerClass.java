/**
 * Created by wthered on 19/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class PlayerClass {

	private static int AllianceClassID;

	public PlayerClass() {
		System.out.println("PlayerClass.PlayerClass");
	}

	static int ShowAllianceClassesFor(int racist) {
		System.out.println("PlayerClass.ShowAvailableClassesFor " + racist);
		switch (racist) {
			case 1:
				Human h = new Human();
				AllianceClassID = h.selectClass();
				System.out.println("Human can be magician among others");
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
		return AllianceClassID;
	}
}
