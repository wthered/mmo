import java.util.Hashtable;
import java.util.Random;

/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
public class Wizard extends Player {

	private Player me;

	Wizard(String newName, int newLevel, int FactionID, Race playRace, int classID) {
		super(newName, newLevel, FactionID, playRace, classID);
	}

	public void blink() {
		System.out.println("Wizard.blink The Wizard has blinked");
		me.setItsX(me.getItsX() + 10);
		me.setItsY(me.getItsY() + 10);
		//todo Cooldown 5 seconds
	}

	public Hashtable conjureFood() {
		Random foodStack = new Random();
		FoodItem conjuredBread = new FoodItem("ConjuredBread", 16, 18, me.getLevel());
		Hashtable food = conjuredBread.conjure(me, foodStack.nextInt(20));
		System.out.println("Wizard.conjureFood The new Bread has been put inside Inventory");
		return food;
	}

	public Hashtable conjureMana() {
		DrinkItem conjuredDrink = new DrinkItem("Conjured Water", 150, 18, true);
		return conjuredDrink.createWaterBottle(me, new Random().nextInt(20) );
	}
}