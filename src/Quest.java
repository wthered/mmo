import java.util.Hashtable;
import java.util.Objects;
import java.util.Random;

/**
 * Created by wthered on 21/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 * https://www.youtube.com/watch?v=uR94mZAWhxs&t=400s
 */
// TODO: 27/11/2016 On each quest the armour durability gets less. Also mana is consumed
class Quest {
	private Player me;
	private Random reward = new Random();

	// The small area where the quest is done ("Northshire Vineyards")
	private int centerX;
	private int centerY;

	// The Large Area ("Elwynn Forest" for example)
	private String Area;

	Quest(Player myself, int aroundX, int aroundY, String questArea) {
		this.me = myself;

		// The Quest is done around Point(X,Y) of Area (see below)
		this.centerX = aroundX;
		this.centerY = aroundY;

		// Quest where the area is done ("Elwyn Forest" for Example)
		this.Area = questArea;
	}

	void doQuest(int questID) {
		me.setInBattle(true);
		System.out.println("Quest #" + questID + " has been completed for " + me.getName());

		// FIXME: 26/11/2016 Normalize experience per level
		int mouni = reward.nextInt(100);
		int fuckr = reward.nextInt(1 + me.getItsHealth());
		System.out.println("Quest.doQuest You have been rewarded with " + Main.convertMoney(mouni) );
		me.setMoney(me.getMoney() + mouni);
		System.out.println("Quest.doQuest You gained " + fuckr + " experience");
		me.setExperience(me.getExperience() + fuckr);
		System.out.println("Quest.doQuest You now have " + me.getExperience() + " experience and " + Main.convertMoney(me.getMoney()));
		me.showExperience();
		// TODO: 26/11/2016 Loss of Health depends on level and type of attack, me.defenceType etc of attacking mob
		int mobDamage = 1 + reward.nextInt(me.getItsHealth());
		me.setItsHealth(me.getItsHealth() - mobDamage);
//		System.out.printf("Quest.doQuest You now have %.2f health points", Double.valueOf(me.getItsHealth()) );
		System.out.println("Quest.doQuest You lost " + mobDamage + " and now have " + me.getItsHealth() + " health points");
		me.setInBattle(false);
	}

	boolean playerIsAround(int radius) {
		boolean play = Objects.equals(me.getArea(), this.getArea());
		boolean seex = Math.abs(me.getItsX() - this.centerX) < radius;
		boolean seey = Math.abs(me.getItsY() - this.centerY) < radius;
		return seex && seey && play;
	}

	String getArea() {
		return this.Area;
	}

	Hashtable<Quest, Integer> create(Quest q, int questID) {
//		Quest q = new Quest(me, reward.nextInt(100), reward.nextInt(100), this.getArea());
		Hashtable<Quest, Integer> qTable = new Hashtable<>();
		qTable.put(q,questID);
		return qTable;
	}

	int getCenterX() {
		return centerX;
	}

	int getCenterY() {
		return centerY;
	}
}