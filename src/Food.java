/**
 * Created by wthered on 24/11/2016.
 */
public class Food {

    // http://wowwiki.wikia.com/wiki/Conjure_Food
    public Food(String FoodName, int health, int overTime, String foodType) {
    }

    public void placeInventory(Player p) {
        System.out.println("Food.placeInventory This food inventory has been placed into inventory of " + p.getName());
    }

    public int[] conjure(int howMany) {
        int[] bread = new int[howMany];
        for (int i = 0; i < howMany; i++) {
            bread[i] = i;
        }
        return bread;
    }
}
