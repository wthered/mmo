import java.util.Random;

/**
 * Created by wthered on 21/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class Quest {
	private Player me;

	private Random reward = new Random();

	Quest(Player myself) {
		this.me = myself;
	}

	void doQuest(int questID) {
		me.inBattle = true;
		System.out.println("Quest #" + questID + " has been completed for " + me.getName());
		int currentMoney = me.getMoney();
		int rewardMoney = reward.nextInt(100);
		// fixme Normalize experience per level
		int rewardXP = reward.nextInt(1 + me.getItsHealth());
		System.out.println("Quest.doQuest You have been rewarded with " + Main.convertMoney(rewardMoney) );
		me.setMoney(currentMoney + rewardMoney);
		System.out.println("Quest.doQuest You gained " + rewardXP + " experience");
		me.setExperience(me.getExperience() + rewardXP);
		System.out.println("Quest.doQuest You now have " + me.getExperience() + " experience and " + Main.convertMoney(me.getMoney()));
		me.showExperience();
		//todo Loss of Health depends on level and type of attack, me.defenceType etc of attacking mob
		int mobDamage = 1 + reward.nextInt(me.getItsHealth());
		me.setItsHealth(me.getItsHealth() - mobDamage);
//		System.out.printf("Quest.doQuest You now have %.2f health points", Double.valueOf(me.getItsHealth()) );
		System.out.println("Quest.doQuest You lost " + mobDamage + " and now have " + me.getItsHealth() + " health points");
	}
}