import java.awt.font.NumericShaper;
import java.awt.font.NumericShaper.Range;
import java.util.Scanner;

import static java.awt.font.NumericShaper.Range.*;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is ${PACKAGE_NAME}
 * Feel Free to Edit mmo
 */
class PlayerAction {

    private int lastAction;
    private String playerName;
    private Player myself;

    PlayerAction(Player actor) {
        this.lastAction = 0;
        this.myself = actor;
        this.playerName = actor.getName();
    }

    int selectAction() {
        int thisAction;
        System.out.println("*********************************************");
        System.out.println("** 1) Eat                                  **");
        System.out.println("** 2) Drink                                **");
        System.out.println("** 3) Fuck                                 **");
        System.out.println("** 4) Quest                                **");
        System.out.println("** 5) Go to City                           **");
        System.out.println("** 6) Go to Area                           **");
        System.out.println("** 7) Go to Location (x,y) or current Area **");
        System.out.println("** 8) Report yourself (Position and Stats) **");
        System.out.println("** 0) Done. Fly me to the moon and stars   **");
        System.out.println("*********************************************");
        System.out.print("What is your desire, " + this.playerName + "? ");
        Scanner actionScanner = new Scanner(System.in);
        thisAction = actionScanner.nextInt();

        if (!actionScanner.hasNextInt()) {
            System.out.print("What is your desire, " + this.playerName + "? ");
            thisAction = actionScanner.nextInt();
        } else {
            System.out.println(thisAction + " is valid in PlayerAction.selectAction");
        }

        while(!(thisAction > 0) && (thisAction < 9)) {
            System.out.println(thisAction + " validates as " + actionScanner.hasNextInt() );
            System.out.println("Cum again " + this.playerName + "? ");
            thisAction = actionScanner.nextInt();
        }
        this.lastAction = thisAction;
        return thisAction;
    }

    public void report() {
        System.out.println("Last Action of " + this.playerName + " is " + this.lastAction);
    }

    void doAction() {
        /*
        * todo
        *   1) look into Inventory to see if foodIsAvailable()
        *   2) look into Inventory to see if drinkIsAvailable()
        */
        switch (this.lastAction) {
            case 3:
                System.out.println("Looking around to find another player (thru http) for " + this.playerName + " in PlayerAction.doAction");
                break;
            default:
                System.out.println("Not implemented yet in PlayerAction.doAction for " + this.lastAction);
        }
    }
}
