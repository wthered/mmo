/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
class FoodItem {

    private int itemHealth;
    private int itemTime;

    private String itemType;

    // http://wowwiki.wikia.com/wiki/Conjure_Food
    FoodItem(String FoodName, int health, int overTime, String foodType) {
        System.out.println("Food.Food A pack of 20 " + FoodName + " that restores " + health + " over " + overTime + " seconds");
        System.out.println("Food.Food This is a type of " + foodType + " food");
        this.itemHealth = health;
        this.itemTime = overTime;
        this.itemType = foodType;
    }

    // Used by Wizard.conjureFood
    double[] conjure(int howMany) {
        double[] bread = new double[howMany];
        for (int i = 0; i < howMany; i++) {
            // todo bread[i] = new FoodItem("Bread Name", 3000, 500, "Bread");
            bread[i] = Math.pow(i, 3);
        }
        return bread;
    }

    int getHealthPerTick() {
        float hps = this.itemHealth / this.itemTime;
        return Math.round(hps);
    }

    int getItemHealth() {
        return this.itemHealth;
    }

    int getItemTime() {
        return this.itemTime;
    }

    String getItemType() {
        return this.itemType;
    }
}
