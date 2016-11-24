/**
 * Created by wthered on 24/11/2016.
 */
public class WizardAttack extends Wizard {

    Player playerWizard;

    public WizardAttack(Player p) {
        super(p);
        this.playerWizard = p;
        System.out.println("WizardAttack.WizardAttack The Wizard attacks");
    }
}
