import java.util.Hashtable;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class PlayerInventory {

    // The Inventory
    private Hashtable<FoodItem, Integer> foodBag;
    private Hashtable<Object, Object> manaBag;
    private Hashtable potions;
    private Player me;

    PlayerInventory(Player p, Bag b) {
        this.me = p;
        this.foodBag = new Hashtable<>();
        this.manaBag = new Hashtable<>();
        this.potions = new Hashtable();
        System.out.println("playerInventory.playerInventory Inventory of " + p.getName());
    }

    public void insertFood(FoodItem f, int quantity) {
        System.out.println("PlayerInventory.insertFood " + quantity + " item(s) of " + f.getItemType() + " has been put");
        this.foodBag.put(f, quantity);
    }

    public void insertMana(DrinkItem d, int q) {
        this.manaBag.put(d, q);
        System.out.println("PlayerInventory.insertMana" + q + " item(s) of " + d.getWater() + " has been put");
    }

    public Hashtable<FoodItem, Integer> getFoodBag() {
        return foodBag;
    }

    public Hashtable<Object, Object> getManaBag() {
        return manaBag;
    }

    public Hashtable getPotions() {
        return potions;
    }
}
