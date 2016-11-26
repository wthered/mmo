/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class Weapon {

    private String weaponName;
    private String weaponSlot;
    private WeaponBonus weaponBonus;
    private ItemQuality quality;
    private int money;

    public Weapon(String wName, String wSlot, WeaponBonus bonus, ItemQuality quality) {
        this.weaponName = wName;
        this.weaponSlot = wSlot;
        this.weaponBonus = bonus;
        this.quality = quality;
        System.out.println("Weapon.Weapon Constructor");
    }

    public void equip(Player me) {
        System.out.println("Weapon.equip " + me.getName() + " equiped " + this.weaponName + " in " + this.getWeaponSlot());
        me.setStrength(me.getStrength() + weaponBonus.getStrength());
        me.setAgility(me.getAgility() + weaponBonus.getAgility());
        me.setStamina(me.getStamina() + weaponBonus.getStamina());
        me.setIntellect(me.getIntellect() + weaponBonus.getIntellect());
        me.setSpirit(me.getSpirit() + weaponBonus.getSpirit());
    }

    public String getWeaponName() {
        return this.weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    private String getWeaponSlot() {
        return this.weaponSlot;
    }

    public void setWeaponSlot(String weaponSlot) {
        this.weaponSlot = weaponSlot;
    }

    public WeaponBonus getWeaponBonus() {
        return this.weaponBonus;
    }

    public void setWeaponBonus(WeaponBonus weaponBonus) {
        this.weaponBonus = weaponBonus;
    }

    public ItemQuality getQuality() {
        return this.quality;
    }

    public void setQuality(ItemQuality quality) {
        this.quality = quality;
    }

    public int getMoney() {
        System.out.println("Weapon.getMoney If you sell this item you will get " + Main.convertMoney(this.money));
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}