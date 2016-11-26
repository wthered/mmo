import java.util.Hashtable;
import java.util.Random;

/**
 * Created by wthered on 24/11/2016.
 * All the Mana Drinks are here
 * Later we will implement alcohol Drinks and
 * drinks that do nothing
 */
class DrinkItem extends Item {

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
        super(waterName, type);
        System.out.println("DrinkItem.DrinkItem A stack of 20 " + waterName + " has been made with type " + type);
		System.out.println("DrinkItem.DrinkItem Each of them gives you " + mana + " over " + overTime + " seconds");

		// Initialisation
		this.water = waterName;
		this.mana = mana;
		this.over = overTime;
		this.type = type;
    }

	Hashtable createWaterBottle(Player mage, int amount, boolean isMage) {
		Hashtable<DrinkItem, Integer> created = mage.inventory.getManaBag();
		if(isMage) {
		    for(int i=0; i<amount; i++) {
		        DrinkItem drink = new DrinkItem("Conjured Water", 120, 30, "Water");
                System.out.println("DrinkItem.createWaterBottle Created " + created.put(drink, i) + " items");
            }
        } else {
            System.out.println("DrinkItem.createWaterBottle Only mages can conjure Water" );
        }
        System.out.println("DrinkItem.createWaterBottle " + mage.getName() + " is wizard? " + mage.getClassName());
        return created;
	}

	Hashtable useOne(Player m) {
        // TODO: 26/11/2016 Global Cooldown timer

        // Generate 10 to 30 mana
		int manaGained = 10 + manaGain.nextInt(20);

		m.setItsMana(m.getItsMana() + manaGained);
		Hashtable<DrinkItem, Integer> manaBag = m.inventory.getManaBag();

        System.out.println("DrinkItem.useOne Removing the " + manaBag.size() + "th item of the Bag from the Inventory of " + m.getName());
        // TODO: 26/11/2016 Implement the consuming function { manaBag.remove( Object o); }
        System.out.println("DrinkItem.useOne The bag now has " + manaBag.size() + " items");

        // Return the rest of the Bag Contents
        return manaBag;
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