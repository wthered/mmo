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

	void ShowAllianceClassesFor(Race racist) {
//		System.out.println("PlayerClass.ShowAvailableClassesFor " + this.getAllianceClassName());
        switch (racist.getRaceID()) {
            case 1:
				Human h = new Human(this.myself);
				myself.setClassID(h.selectClass());
				h.setHumanAttributes(racist);
				myself.setRaceName("Human");
				myself.setArea("Elwyn Forest");
				break;
			case 2:
				Gnome regan = new Gnome(myself);
				myself.setClassID(regan.selectGnomeClass());
				regan.setGnomeAttributes(racist);
				myself.setCity("Ironforge");
				myself.setArea("Dun Morogh");
				myself.setRaceName("Gnome");
				break;
			case 3:
				// selectDwarfRace();
				myself.setRaceName("Dwarf");
				System.out.println("PlayerClass.ShowAllianceClassesFor " + myself.getRaceName() + " are warriors");
				break;
			case 4:
				// selectElvenRace();
				myself.setRaceName("Night Elf");
				System.out.println("PlayerClass.ShowAllianceClassesFor " + myself.getRaceName() + " can be hunters");
				break;
			default:
				myself.setRaceName("defaultRaceName");
                System.out.println("PlayerClass.ShowAvailableClassesFor never reaches " + racist.getRaceID());
                break;
		}
//		myself.ClassName = this.getAllianceClassName();
		System.out.println("PlayerClass.ShowAllianceClassesFor " + myself.getRaceName() + " can be " + this.getAllianceClassName());
	}

	private String getAllianceClassName() {
		switch (myself.getClassID()) {
			case 1:
				myself.setClassName("Wizard");
				break;
			case 2:
				myself.setClassName("Paladin");
				break;
			case 3:
				myself.setClassName("Priest");
				break;
			case 4:
				myself.setClassName("Rogue");
				break;
			case 5:
				myself.setClassName("Warrior");
				break;
			case 6:
				myself.setClassName("Druid");
				break;
			case 7:
				myself.setClassName("Hunter");
				break;
			case 8:
				myself.setClassName("Warlock");
				break;
			case 9:
				myself.setClassName("Shaman");
				break;
			case 10:
				myself.setClassName("Monk");
				break;
			case 11:
				myself.setClassName("Death Knight");
				break;
			default:
				myself.setClassName("defaultClassName");
				System.out.println("PlayerClass.getAllianceClassName ClassID is never " + myself.getClassID());
		}
		return myself.getClassName();
	}
}