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
    private Hashtable<FoodItem, Integer> foods;

    Bag(String bagName, int rows, int cols, Hashtable<FoodItem, Integer> hashTableToContain) {
        this.Name = bagName;
        this.rows = rows;
        this.columns = cols;
        this.foods = hashTableToContain;
    }

    public void seeInside() {
        for (Map.Entry<FoodItem, Integer> container : foods.entrySet()) {
            FoodItem tmpFoodItem = container.getKey();
            System.out.println("Bag.seeInside Inside I see many food Items");
            System.out.println("Bag.seeInside Type " + tmpFoodItem.getItemType() + " you have " + container.getValue() + " foods");
        }
    }

    public void getDimensions() {
        System.out.println("Bag.getDimensions The Bag named " + Name + " has " + rows + " rows and " + columns + " columns");
    }

}
