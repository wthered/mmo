/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class WeaponBonus {

    private int strength;
    private int agility;
    private int stamina;
    private int intellect;
    private int spirit;
    private int armor;

    public WeaponBonus(int strength, int agility, int stamina, int intellect, int spirit, int armour) {
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
        this.intellect = intellect;
        this.spirit = spirit;
        this.armor = armour;
    }

    int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    int getAgility() {
        return this.agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    int getIntellect() {
        return this.intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    int getSpirit() {
        return this.spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public int getArmor() {
        return this.armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}