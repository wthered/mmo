import java.util.Hashtable;

/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
class FoodItem extends Item {

	private int itemHealth;
	private int itemTime;
	private int overTime;

	// http://wowwiki.wikia.com/wiki/Conjure_Food
	FoodItem(String foodName, int health, int overTime, int minItemLevel) {
		super(foodName, 0, 0, 0);
		System.out.println("FoodItem.FoodItem A pack of 20 " + foodName + " that restores " + health + " over " + overTime + " clock ticks");
		this.itemHealth = health;
		this.itemTime = overTime;
	}

	private FoodItem(Item food, int overTime) {
		super(food.getItemName(), food.getItemType(), food.getHealth(), food.getWater());
		this.setOverTime(overTime);
	}

	// Used by Wizard.conjureFood
	// TODO: 28/11/2016 implement the minimum minPlayerLevel
	Hashtable conjure(Player wizard, int howMany) {
		Hashtable<Item, Integer> bread = wizard.getInventory().getItemBag();
		for (int i = 1; i <= howMany; i++) {
			Item tempLoaf = new Item(this.getItemName(), 0, 61, 0);
			FoodItem realLoaf = new FoodItem(tempLoaf, 18);
			bread.put(realLoaf, i);
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

	// How many seconds does it take to eat the foodItem
	int getItemTime() {
		return this.itemTime;
	}

	public int getOverTime() {
		return this.overTime;
	}

	private void setOverTime(int overTime) {
		this.overTime = overTime;
	}
}