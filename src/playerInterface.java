/**
 * Created by wthered on 12/11/2016 3:24 μμ
 * The Project name is mmo.
 */
interface playerInterface {

    default void showMoney() {
        System.out.println("playerInterface.showMoney says you have some money");
    }

    default void getFaction() {
        System.out.println("playerInterface.getFaction says you belong to Faction");
    }

    default void showHealth() {
        System.out.println("playerInterface.showHealth");
    }

    default void showMana() {
        System.out.println("playerInterface.showMana");
    }
}