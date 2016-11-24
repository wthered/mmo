import java.util.ArrayList;
import java.util.Random;

/**
 * Created by wthered on 12/11/2016 3:24 μμ
 * The Project name is mmo.
 */
interface playerInterface {

	// Before we begin, we init with random Values
	Random rndStats = new Random();

	default int showMoney() {
		System.out.println("playerInterface.showMoney says you have some money");
		return 0;
	}

	default String getFaction() {
		System.out.println("playerInterface.getFaction says you belong to Faction");
		return "InterfacePlayerFactionName";
	}

	default void showExperience() {
//		System.out.println("playerInterface.showExperience I have " + Player.experience + " experience");
	}

	default void putInventory(double[] stackItems) {
		ArrayList<int[]> inv = new ArrayList<>();
		inv.add(20, Player.inventory);
	}
}