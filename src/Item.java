/**
 * Created by wthered on 24/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class Item {

    private String itemName;

    /* ***************
    ** 0    -> Food
    ** 1    -> Drink / Mana
    ** 2    -> Both
    ************************/
    private int itemType;

    // How much health the item gives
    private int health;

    // How much mana the item gives
    private int thirst;

    Item(String Name, int Type, int healGain, int manaGain) {
        this.itemName = Name;
        this.itemType = Type;
        this.health = healGain;
        this.thirst = manaGain;
        System.out.println("Item.Item Constructor for " + this.getItemName() + " of type " + this.getItemTypeName());
    }

    int getItemType() {
        return this.itemType;
    }

    String getItemName() {
        return this.itemName;
    }

    int getWater() {
        return this.thirst;
    }

    int getFoodFromItem(FoodItem f) {
        if (this.getItemType() == 1) {
            return f.getItemHealth();
        }
        return 0;
    }

    int getHealth() {
        return health;
    }

    private String getItemTypeName() {
        String typeName;
        switch (this.getItemType()) {
            case 0:
                typeName = "Food";
                break;
            case 1:
                typeName = "Drink";
                break;
            case 2:
                typeName = "Both";
                break;
            default:
                typeName = "Unknown";
                break;
        }
        return typeName;
    }
}