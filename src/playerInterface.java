/**
 * Created by wthered on 12/11/2016 3:24 μμ
 * The Project name is mmo.
 */
interface playerInterface {

    default void showMoney(Player p) {
        System.out.println("playerInterface.showMoney says you have some money");
    }

    default void getFaction(Player p) {
        System.out.println("playerInterface.getFaction says you belong to Faction");
    }
}