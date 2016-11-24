/**
 * Created by wthered on 24/11/2016.
 */
public class Wizard {

    Player mage;

    public Wizard(Player mage) {
        this.mage = mage;
    }

    public void blink() {
        System.out.println("Wizard.blink The Wizard has blinked");
        mage.setItsX(mage.getItsX() + 10);
        mage.setItsY(mage.getItsY() + 10);
        //todo Cooldown 5 seconds
    }

    public int[] conjureFood() {
        Food conjuredBread = new Food("ConjuredBread", 16, 18, "Bread");
        int[] food = conjuredBread.conjure(20);
        System.out.println("Wizard.conjureFood The new Bread hass been put inside Inventory");
        return food;
    }
}
