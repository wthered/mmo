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
		int rewardXP = this.gain(rewardMoney);
		System.out.println("Quest.doQuest You have been rewarded with " + rewardMoney + "c");
		me.setMoney(currentMoney + rewardMoney);
		System.out.println("Quest.doQuest You gained " + rewardXP + " experience");
		me.setExperience(me.getExperience() + rewardXP);
		System.out.println("Quest.doQuest You now have " + me.getExperience() + " experience and " + Main.convertMoney(me.getMoney()));
		me.showExperience();
		//todo Loss of Health depends on level and type of attack, me.defenceType etc of attacking mob
//		int mobDamage = reward.nextInt(me.getItsHealth());
		me.setItsHealth(me.getItsHealth() / 2);
	}

	private int gain(int experience) {
		return reward.nextInt(experience);
	}
}