/**
 * Created by wthered on 24/11/2016.
 * The Package name is ${PACKAGE_NAME}
 * The Project name is mmo
 */
public class WizardAttack extends Wizard {

	private Player playerWizard;

	public WizardAttack(Wizard w) {
		super(w.getName(),w.getLevel(),w.getFactionID(),w.getPlayerRace(),1);
		System.out.println("WizardAttack.WizardAttack The Wizard named " + w.getName() + " attacks");
	}

	public void MeleeAttack(Mob target) {
		System.out.println("WizardAttack.MeleeAttack " + playerWizard.getName() + " attacks with sword in " + target.getMobName());
	}

	public void SpellAttack(Mob target) {
		System.out.println("WizardAttack.SpellAttack " + super.getName() + " attacks " + target.getMobName() + " with magic spells");
	}
}
