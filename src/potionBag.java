import java.util.Hashtable;

/**
 * Created by wthered on 27/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class potionBag extends Bag {

    private String Name;

    // How much Healing the Potion Does
    private int healing;

    // How much Mana the Potion gives
    private int thirsty;

    // The Holder of all the potions
    private Hashtable<Potion, Integer> potions;

    potionBag(String potioName, int healAmount, int manAmount, Hashtable<Potion, Integer> potionTable) {
        super(potioName, healAmount, manAmount, new Hashtable<>());
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getHealing() {
        return this.healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getThirsty() {
        return this.thirsty;
    }

    public void setThirsty(int thirsty) {
        this.thirsty = thirsty;
    }

    Hashtable<Potion, Integer> getPotions() {
        return this.potions;
    }

    public void setPotions(Hashtable<Potion, Integer> potions) {
        this.potions = potions;
    }
}
