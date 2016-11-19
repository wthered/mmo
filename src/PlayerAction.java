import java.util.Scanner;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is ${PACKAGE_NAME}
 * Feel Free to Edit mmo
 */
class PlayerAction {

    private int lastAction;
    private String playerName;

    PlayerAction(Player actor) {
        this.lastAction = 0;
        this.playerName = actor.getName();
    }

    public int selectAction() {
        System.out.println("***************");
        System.out.println("** 1) Eat   **");
        System.out.println("** 2) Drink **");
        System.out.println("** 3) Fuck  **");
        System.out.println("** 4) Quest **");
        System.out.println("** 5) Go to City **");
        System.out.println("** 6) Go to Area **");
        System.out.println("** 7) Go to Location (x,y) or current Area **");
        System.out.println("** 8) Report yourself                      **");
        System.out.println("*********************************************");
        Scanner actionScanner = new Scanner(System.in);
        this.lastAction = actionScanner.nextInt(3);
        return this.lastAction;
    }

    public void report() {
        System.out.println("Last Action of " + this.playerName + " is " + this.lastAction);
    }
}
