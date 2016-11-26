/**
 * Created by wthered on 24/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class Item {

    private String itemName;
    private String itemType;

    Item(String Name, String Type) {
        this.itemName = Name;
        this.itemType = Type;
        System.out.println("Item.Item Constructor for " + this.getItemName() + " of type " + this.getItemType());
    }

    public String getItemType() {
        return this.itemType;
    }

    private String getItemName() {
        return itemName;
    }
}
