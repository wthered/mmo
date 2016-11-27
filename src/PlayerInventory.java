import java.util.Hashtable;
import java.util.Map;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class PlayerInventory {

    // The Inventory
    private Hashtable<Item, Integer> itemBag;
    private Hashtable<Weapon, Integer> weaponTable;
    private Hashtable<Potion, Integer> potions;
    private Hashtable<Herb, Integer> herbalBag;
    private Bag[] bags;

    // TODO: 27/11/2016 Create weaponBag share space with ArmorBag (Στην ίδια και Armour & Weapons)
    PlayerInventory(Bag food, weaponBag weapons, potionBag pots, herbalismBag herbs) {
        this.itemBag = food.getItems();
        this.weaponTable = weapons.getWeaponIntegerHashtable();
        this.potions = pots.getPotions();
        this.herbalBag = herbs.getHerbs();

        this.bags = new Bag[]{food, weapons, pots, herbs};
        System.out.println("playerInventory.playerInventory Inventory of Player");
    }

    void insertFood(FoodItem f, int quantity) {
        System.out.println("PlayerInventory.insertFood " + quantity + " item(s) of " + f.getItemName() + " has been put");
        this.getItemBag().put(f, quantity);
    }

    void selectItem() {
        for (Map.Entry<Item, Integer> fItem : this.getItemBag().entrySet()) {
            Item tmpFood = fItem.getKey();
            System.out.println("PlayerInventory.selectFood I have " + fItem.getValue() + " inside Food Bag of " + tmpFood.getItemType());
        }
    }

    void selectWeapon() {
        for (Map.Entry<Weapon, Integer> mItem : this.getWeaponBag().entrySet()) {
            Weapon theWeapon = mItem.getKey();
            System.out.println("PlayerInventory.selectWeapon I have " + mItem.getValue() + " weapons in my WeaponBag");
        }
    }

    // See all the Potions I have
    void selectPots() {
        for(Map.Entry<Potion, Integer> pItem : this.getPotions().entrySet()) {
            Potion potion = pItem.getKey();
            System.out.println("PlayerInventory.selectPots I have " + pItem.getValue() + " potions that are labeled " + potion.getName());
        }
    }

    public void insertPotion(Potion p, int q) {
        this.potions.put(p,q);
        System.out.println("PlayerInventory.insertPotion " + q + " items of " + p.getName() + " has been put");
    }

    // Checks if Player Inventory is full
    public boolean isFull() {
        boolean foodFull = itemBag.size() == bags[0].getDimensions();
        boolean armories = weaponTable.size() == bags[1].getDimensions();
        boolean potsFull = potions.size() == bags[2].getDimensions();
        boolean herbFull = potions.size() == bags[3].getDimensions();
        return foodFull && armories && potsFull && herbFull;
    }

    Hashtable<Item, Integer> getItemBag() {
        // TODO: 27/11/2016 Show all Items
        return this.itemBag;
    }

    Hashtable<Weapon, Integer> getWeaponBag() {
        // TODO: 27/11/2016 show all milk
        return this.weaponTable;
    }

    Hashtable<Potion, Integer> getPotions() {
        // TODO: 27/11/2016 Show All Potions
        return this.potions;
    }

    public Hashtable<Herb, Integer> getHerbalBag() {
        return herbalBag;
    }

    public void setHerbalBag(Hashtable<Herb, Integer> herbalBag) {
        this.herbalBag = herbalBag;
    }
}