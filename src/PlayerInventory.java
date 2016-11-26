import java.util.Hashtable;
import java.util.Map;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class PlayerInventory {

    // The Inventory
    private Hashtable<FoodItem, Integer> foodBag;
    private Hashtable<DrinkItem, Integer> manaBag;
    private Hashtable<Potion, Integer> potions;

    PlayerInventory(Bag b) {
        this.foodBag = new Hashtable<>();
        this.manaBag = new Hashtable<>();
        this.potions = new Hashtable<>();
        b.getDimensions();
        System.out.println("playerInventory.playerInventory Inventory of Player");
    }

    void insertFood(FoodItem f, int quantity) {
        System.out.println("PlayerInventory.insertFood " + quantity + " item(s) of " + f.getItemType() + " has been put");
        this.foodBag.put(f, quantity);
    }

    void selectFood() {
        for (Map.Entry<FoodItem, Integer> fItem : this.getFoodBag().entrySet()) {
            FoodItem tmpFood = fItem.getKey();
            System.out.println("PlayerInventory.selectFood I have " + fItem.getValue() + " inside Food Bag of " + tmpFood.getItemType());
        }
    }

    public void selectMana() {
        for(Map.Entry<DrinkItem, Integer> mItem : this.getManaBag().entrySet()) {
            DrinkItem tmpDrink = mItem.getKey();
            System.out.println("PlayerInventory.selectMana I have " + mItem.getValue() + " inside Mana Bag of " + tmpDrink.getWater());
        }
    }

    public void insertMana(DrinkItem d, int q) {
        this.manaBag.put(d, q);
        System.out.println("PlayerInventory.insertMana" + q + " item(s) of " + d.getWater() + " has been put");
    }

    public void insertPotion(Potion p, int q) {
        this.potions.put(p,q);
        System.out.println("PlayerInventory.insertPotion " + q + " items of " + p.getName() + " has been put");
    }

    Hashtable<FoodItem, Integer> getFoodBag() {
        return this.foodBag;
    }

    Hashtable<DrinkItem, Integer> getManaBag() {
        return this.manaBag;
    }

    Hashtable getPotions() {
        return potions;
    }
}