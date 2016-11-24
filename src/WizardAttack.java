/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
public class WizardAttack extends Wizard {

	private Player playerWizard;

	public WizardAttack(Player p) {
		super(p);
		this.playerWizard = p;
		System.out.println("WizardAttack.WizardAttack The Wizard attacks");
	}

	public void MeleeAttack(Mob target) {
		System.out.println("WizardAttack.MeleeAttack " + playerWizard.getName() + " attacks with sword in " + target.getMobName());
	}
}
