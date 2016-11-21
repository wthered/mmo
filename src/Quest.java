/**
 * Created by wthered on 21/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class Quest {
	private Player me;

	Quest(Player myself) {
		this.me = myself;
	}

	void doQuest(int questID) {
		System.out.println("Quest #" + questID + " has been completed for " + me.getName());
	}
}