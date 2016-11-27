import java.util.Hashtable;
import java.util.Map;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class Bag {
    private String Name;
    private int rows;
    private int columns;
    private Hashtable<Item, Integer> items;
    private Hashtable<Potion, Integer> potions;

    Bag(String bagName, int rows, int cols, Hashtable<Item, Integer> hashTableToContain) {
        this.Name = bagName;
        this.rows = rows;
        this.columns = cols;
        this.items = hashTableToContain;
    }

    public void seeInside() {
        for (Map.Entry<Item, Integer> container : items.entrySet()) {
            Item tmpItem = container.getKey();
            System.out.println("Bag.seeInside Inside I see many food Items");
            System.out.println("Bag.seeInside Type " + tmpItem.getItemType() + " you have " + container.getValue() + " foods");
        }
    }

    int getDimensions() {
        System.out.println("Bag.getDimensions The Bag named " + this.Name + " has " + this.rows + " rows and " + this.columns + " columns");
        return this.rows * this.columns;
    }

    Hashtable<Item, Integer> getItems() {
        return this.items;
    }

    public void setFoods(Hashtable<Item, Integer> foods) {
        this.items = foods;
    }
}