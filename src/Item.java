/**
 * Created by wthered on 24/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
class Item {

    private String itemType;

    Item(String Name, String Type) {
        System.out.println("Item.Item Item " + Name + " of type " + Type);
    }

    public String getItemType() {
        return itemType;
    }
}
