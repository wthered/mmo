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

//        this.initialize();
        Item newItem = new Item("Item Name", 1, 50, 60);
        food.getItems().put(newItem, 1);

//        Potion potion= new Potion("Minor Rejuvenation Potion", 40, 0);
//        pots.getPotions().put(potion, 15);

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
        int weaponCounter = 0;
        for (Map.Entry<Weapon, Integer> mItem : this.getWeapons().entrySet()) {
            Weapon theWeapon = mItem.getKey();
            System.out.println("PlayerInventory.selectWeapon I have " + mItem.getValue() + " " + theWeapon.getWeaponName() + " weapons found");
            weaponCounter += mItem.getValue();
        }
        System.out.println("PlayerInventory.selectWeapon I have " + weaponCounter + " weapons in " + this.getWeapons().size() + " slots");
    }

    // See all the Potions I have
    void selectPots() {
        for(Map.Entry<Potion, Integer> pItem : this.getPotions().entrySet()) {
            Potion potion = pItem.getKey();
            System.out.println("PlayerInventory.selectPots I have " + pItem.getValue() + " potions that are labeled " + potion.getName());
        }
    }

    void insertPotion(Potion p, int q) {
//        this.getPotions().put(p, q);
//        System.out.println("PlayerInventory.insertPotion I now have " + this.getPotions().size() + " potions");
        System.out.println("PlayerInventory.insertPotion " + q + " items of " + p.getName() + " has been put");
    }

    // Checks if Player Inventory is full
    boolean isFull() {
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

    Hashtable<Weapon, Integer> getWeapons() {
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

    public Hashtable<Weapon, Integer> getWeaponTable() {
        return this.weaponTable;
    }

    // Used by playerInventory.playerInventory and only by playerInventory.playerInventory
    private void initialize() {
        Item i = new Item("Smashing Pumpkin", 1,61,0);
        Item j = new Item("Tiny Glass of Milk", 1,0,100);
        Potion k=new Potion("minor Healing potion", 75, 1);

        WeaponBonus wb = new WeaponBonus(10,10,50,40,30, 10);
        ItemQuality iq = new ItemQuality(0);
        Weapon z    = new Weapon("Tiny Sword", "Hand", wb, iq);

        this.getItemBag().putIfAbsent(i,1);
        this.getItemBag().putIfAbsent(j,2);
        this.getPotions().putIfAbsent(k,3);
        this.getWeapons().putIfAbsent(z,4);
    }
}