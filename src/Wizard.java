import java.util.Hashtable;
import java.util.Random;

/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
public class Wizard {

	private Player mage;

	Wizard(Player mage) {
		this.mage = mage;
	}

	public void blink() {
		System.out.println("Wizard.blink The Wizard has blinked");
		mage.setItsX(mage.getItsX() + 10);
		mage.setItsY(mage.getItsY() + 10);
		//todo Cooldown 5 seconds
	}

	public double[] conjureFood() {
		Random foodStack = new Random();
		FoodItem conjuredBread = new FoodItem("ConjuredBread", 16, 18, "Bread");
		double[] food = conjuredBread.conjure(foodStack.nextInt());
		System.out.println("Wizard.conjureFood The new Bread has been put inside Inventory");
		return food;
	}

	public Hashtable conjureMana() {
		Random mageBool = new Random();
		DrinkItem conjuredDrink = new DrinkItem("Conjured Water", 150, 18, "Water");
		return conjuredDrink.createWaterBottle(mage, mageBool.nextInt(20), mageBool.nextBoolean());
	}
}
