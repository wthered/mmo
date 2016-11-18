/**
 * Created by wthered on 12/11/2016 3:24 μμ
 * The Project name is mmo.
 */
interface playerInterface {

    default void showMoney() {
        System.out.println("playerInterface.showMoney says you have some money");
    }

    default String getFaction() {
        System.out.println("playerInterface.getFaction says you belong to Faction");
        return "InterfacePlayerFactionName";
    }

    default int showHealth() {
        System.out.println("playerInterface.showHealth");
        return 100;
    }

    default int showMana() {
        System.out.println("playerInterface.showMana");
        return 100;
    }
}