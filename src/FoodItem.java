/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
class FoodItem extends Item {

	private String itemName;
	private int itemHealth;
	private int itemTime;

	// http://wowwiki.wikia.com/wiki/Conjure_Food
	FoodItem(String foodName, int health, int overTime) {
		super(foodName, 0, 0, 0);
		System.out.println("FoodItem.FoodItem A pack of 20 " + foodName + " that restores " + health + " over " + overTime + " clock ticks");
		this.itemName = foodName;
		this.itemHealth = health;
		this.itemTime = overTime;
	}

	// Used by Wizard.conjureFood
	double[] conjure(int howMany) {
		double[] bread = new double[howMany];
		for (int i = 0; i < howMany; i++) {
			// todo bread[i] = new FoodItem("Bread Name", 3000, 15, "Bread");
			bread[i] = Math.pow(i, 3);
		}
		return bread;
	}

	int getHealthPerTick() {
		float hps = this.itemHealth / this.itemTime;
		return Math.round(hps);
	}

	// How much Health the item gives
	int getItemHealth() {
		return this.itemHealth;
	}

	int getItemTime() {
		return this.itemTime;
	}

//	public int getItemType() {
//		return this.itemType;
//	}
}