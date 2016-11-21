/**
 * Created by wthered on 21/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class Travel {
	private Player me;

	Travel(Player myself) {
		this.me = myself;
	}

	void visit(String destination) {
		System.out.println("Traveling to " + destination);
		me.setArea(destination);
	}
}