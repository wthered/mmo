import java.util.Random;

/**
 * Created by wthered on 24/11/2016.
 * All the Mana Drinks are here
 * Later we will implement alcohol Drinks and
 * drinks that do nothing
 */
class DrinkItem {

    private Random manaGain = new Random();

    // manaDrink Name
    private String water;

    // How many mana is gained
    private int mana;

    // How much time is required
    private int over;

    // What type is the mana Drink
    private String type;

	DrinkItem(String waterName, int mana, int overTime, String type) {
		System.out.println("DrinkItem.DrinkItem A stack of 20 " + waterName + " has been made with type " + type);
		System.out.println("DrinkItem.DrinkItem Each of them gives you " + mana + " over " + overTime + " seconds");

		// Initialisation
		this.water = waterName;
		this.mana = mana;
		this.over = overTime;
		this.type = type;
    }

	double[] createWaterBottle(Player mage, int amount) {
		double[] bottles = new double[amount];
		for (int i = 0; i < amount; i++) {
			// TODO: 26/11/2016 Create ManaDrinks instead of integers
			bottles[i] = Math.pow(i, 2);
		}
		mage.setItsMana(mage.getItsMana() - 80);
		return bottles;
	}

	void useOne(Player m, double[] inventoryItem) {
        // TODO: 26/11/2016 Global Cooldown timer

        // Generate 10 to 30 mana
		int manaGained = 10 + manaGain.nextInt(20);

		m.setItsMana(m.getItsMana() + manaGained);
		System.out.println("DrinkItem.useOne Using the item #" + inventoryItem.length + " from the Inventory of " + m.getName());
		// TODO: 26/11/2016 Pop the last item of array

//		int len = inventoryItem.length;
//		inventoryItem[len] = 0;
	}

    String getWater() {
        return this.water;
    }

    public int getMana() {
        return this.mana;
    }

    public int getOver() {
        return this.over;
    }

    public String getType() {
        return this.type;
    }
}