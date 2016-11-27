import java.util.Hashtable;
import java.util.Map;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class PlayerInventory {

    // The Inventory
    private Hashtable<Item, Integer> foodBag;
    private Hashtable<Item, Integer> manaBag;
    private Hashtable<Potion, Integer> potions;
    private Bag[] bags;

    PlayerInventory(Bag food, Bag mana, Bag pots, Bag herbs) {
        this.foodBag = food.getFoods();
        this.manaBag = new Hashtable<>();
        this.potions = new Hashtable<>();
        // TODO: 27/11/2016 later. Now you get the idea
        bags[0] = food;
        bags[1] = mana;
        bags[2] = pots;
        bags[3] = herbs;
        System.out.println("playerInventory.playerInventory Inventory of Player");
    }

    void insertFood(FoodItem f, int quantity) {
        System.out.println("PlayerInventory.insertFood " + quantity + " item(s) of " + f.getItemType() + " has been put");
        this.foodBag.put(f, quantity);
    }

    void selectFood() {
        for (Map.Entry<Item, Integer> fItem : this.getFoodBag().entrySet()) {
            Item tmpFood = fItem.getKey();
            System.out.println("PlayerInventory.selectFood I have " + fItem.getValue() + " inside Food Bag of " + tmpFood.getItemType());
        }
    }

    void selectMana() {
        for (Map.Entry<Item, Integer> mItem : this.getManaBag().entrySet()) {
            Item tmpDrink = mItem.getKey();
            System.out.println("PlayerInventory.selectMana I have " + mItem.getValue() + " inside Mana Bag of " + tmpDrink.getWater());
        }
    }

    // See all the Potions I have
    void selectPots() {
        for(Map.Entry<Potion, Integer> pItem : this.getPotions().entrySet()) {
            Potion potion = pItem.getKey();
            System.out.println("PlayerInventory.selectPots I have " + pItem.getValue() + " potions that are labeled " + potion.getName());
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

    // Checks if Player Inventory is full
    public boolean isFull() {
        boolean foodFull = foodBag.size() == bags[0].getDimensions();
        boolean manaFull = manaBag.size() == bags[1].getDimensions();
        boolean potsFull = potions.size() == bags[2].getDimensions();
        boolean herbFull = potions.size() == bags[3].getDimensions();
        return foodFull && manaFull && potsFull && herbFull;
    }

    Hashtable<Item, Integer> getFoodBag() {
        return this.foodBag;
    }

    Hashtable<Item, Integer> getManaBag() {
        return this.manaBag;
    }

    Hashtable<Potion, Integer> getPotions() {
        return this.potions;
    }
}