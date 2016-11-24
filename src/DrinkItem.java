import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wthered on 24/11/2016.
 * All the Mana Drinks are here
 * Later we will implement alcohol Drinks and
 * drinks that do nothing
 */
class DrinkItem {

	Random amount = new Random();

	DrinkItem(String waterName, int mana, int overTime, String type) {
		System.out.println("DrinkItem.DrinkItem A stack of 20 " + waterName + " has been made with type " + type);
		System.out.println("DrinkItem.DrinkItem Each of them gives you " + mana + " over " + overTime + " seconds");
	}

	double[] createWaterBottle(Player mage, int amount) {
		double[] bottles = new double[amount];
		for (int i = 0; i < amount; i++) {
			// todo Create ManaDrinks instead of integers
			bottles[i] = Math.pow(i, 2);
		}
		mage.setItsMana(mage.getItsMana() - 80);
		return bottles;
	}

	void useOne(Player m, double[] inventoryItem) {
		System.out.println("DrinkItem.useOne Using the item #" + inventoryItem.length + " from the Inventory of " + m.getName());
		//todo Pop the last item of array
//		int len = inventoryItem.length;
//		inventoryItem[len] = 0;
	}

	ArrayList create(int many) {
		ArrayList<DrinkItem> waterItems = new ArrayList<>(many);
		for (int i = 0; i < many; i++) {
			DrinkItem manaItem = new DrinkItem("Fresh Water", 16, 18, "Water");
			waterItems.add(manaItem);
		}
		return waterItems;
	}
}