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
		// Mage Rogue Warlock Warrior Monk DeathKnights
		PlayerClass pc = new PlayerClass(me);

		// Setting our Gnome to be Monk
		me.setClassID(10);
		System.out.println("Gnome.selectGnomeClass Gnomes can not be priests");
		return 10;
	}

	void setGnomeAttributes(Race r) {
		r.setRaceStrength(15);
		r.setRaceAgility(23);
		r.setRaceStamina(19);
		r.setRaceIntellect(23);
		r.setRaceSpirit(20);
		System.out.println("Gnome.setGnomeAttributes " + r.getRaceName(Player.FactionID));
	}
}
