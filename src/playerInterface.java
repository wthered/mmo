/**
 * Created by wthered on 12/11/2016 3:24 μμ
 * The Project name is mmo.
 */
interface playerInterface {
	/*
Before we begin, we init with random Values
Random rndStats = new Random();
*/

	default String showMoney() {
		System.out.println("playerInterface.showMoney says you have some money");
		return "The Money";
	}

	default String getFaction() {
		System.out.println("playerInterface.getFaction says you belong to Faction");
		return "InterfacePlayerFactionName";
	}

	default void showExperience() {
		System.out.println("playerInterface.showExperience I have some experience in this game");
	}

	default void putInventory(Player p, Item i ) {
		System.out.println("playerInterface.putInventory The item name " + i.getClass().toString() + " put in " + p.getName() + " inventory");
//		p.inventory.add(i);
//		inv.add(20, Player.inventory);
	}
}