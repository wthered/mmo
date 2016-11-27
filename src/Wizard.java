import java.util.Hashtable;
import java.util.Random;

/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
public class Wizard {

	private Player w;

	Wizard(Player mage) {
		this.w = mage;
	}

	public void blink() {
		System.out.println("Wizard.blink The Wizard has blinked");
		w.setItsX(w.getItsX() + 10);
		w.setItsY(w.getItsY() + 10);
		//todo Cooldown 5 seconds
	}

	public double[] conjureFood() {
		Random foodStack = new Random();
		FoodItem conjuredBread = new FoodItem("ConjuredBread", 16, 18);
		double[] food = conjuredBread.conjure(foodStack.nextInt());
		System.out.println("Wizard.conjureFood The new Bread has been put inside Inventory");
		return food;
	}

	public Hashtable conjureMana() {
		DrinkItem conjuredDrink = new DrinkItem("Conjured Water", 150, 18);
		return conjuredDrink.createWaterBottle(w, new Random().nextInt(20), new Random().nextBoolean());
	}
}