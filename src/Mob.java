/**
 * Created by wthered on 24/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class Mob {

	private String mobName;
	private int mobHealth;
	private int mobMana;
	private String mobType;
	private Player target;

	public Mob(String mobName, int mobHealth, int mobMana, String mobType) {
		System.out.println("Mob.Mob You found a " + mobType + " named " + mobName);
	}

	public void attack(Player p) {
		this.target = p;
		System.out.println("Mob.attack " + this.getMobName() + " attacks " + target.getName());
		p.setItsHealth(p.getItsHealth() - 10);
	}

	String getMobName() {
		return this.mobName;
	}

	// I don't see any use of this
	// Placeholder for later
	public void setMobName(String mobName) {
		this.mobName = mobName;
	}

	public int getMobHealth() {
		return mobHealth;
	}

	public void setMobHealth(int mobHealth) {
		this.mobHealth = mobHealth;
	}

	public int getMobMana() {
		return this.mobMana;
	}

	public void setMobMana(int mobMana) {
		this.mobMana = mobMana;
	}

	public String getMobType() {
		return this.mobType;
	}

	// I dont't see any Use
	// Maybe later
	public void setMobType(String mobType) {
		this.mobType = mobType;
	}
}