package mmoTest;

import org.junit.Test;

import java.util.*;

/**
 * Created by wthered on 25/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class MainTest {
	@Test
	public void main() throws ArrayStoreException {
		healthPotion h = new healthPotion("Minor Healing Potion", 80, "healthPotion");
		manaPotion m = new manaPotion("Minor Drinking Potion", 90, "arcanePotion");

		List<healthPotion> healing = new ArrayList<>();
		healing.add(h);

		List<manaPotion> arcane = new ArrayList<>();
		arcane.add(m);

//		Potion p = new Potion("potionName", "potionType", healing);

		for (healthPotion hp: healing) {
			System.out.println("MainTest.main\t" + hp.consume());
		}

		for (manaPotion mp : arcane) {
			System.out.println("MainTest.main\t" + mp.consume());
		}

		this.table(h, m);
	}

	private void table(healthPotion h, manaPotion m) {
		Hashtable<healthPotion, Integer> healingPotions = new Hashtable<>();
		Hashtable<manaPotion, Integer> manaPotions = new Hashtable<>();

		healthPotion lorem = new healthPotion("Minor Healing Potion", 70, "fuck");
		healthPotion ipsum = new healthPotion("Major Healing Potion", 260, "fuck");

		manaPotion dolor = new manaPotion("Minor Casting Potion", 30, "suck");
		manaPotion musir = new manaPotion("Major Castion Potion", 350, "suck");

		// Declaration of HashTables
		healingPotions.put(lorem, 10);
		healingPotions.put(ipsum, 3);
		healingPotions.put(h, 40);

		manaPotions.put(dolor, 4);
		manaPotions.put(musir, 18);
		manaPotions.put(m, 64);

		for (HashMap.Entry<manaPotion, Integer> entry: manaPotions.entrySet()){
			manaPotion mp = entry.getKey();
			System.out.println("MainTest.table You have "+ entry.getValue() + " item(s) of " + mp.getName() + " is of type " + mp.getType());
		}
	}
}