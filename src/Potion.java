/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class Potion {

    private String Name;
    private int many;
    private int what;

    public String getName() {
        return this.Name;
    }

    public int getMany() {
        // How many of (both/health/mana) it restores
        return this.many;
    }

    public int getWhat() {
        // 0    -> Both Health and Mana
        // 1    -> heal Potion
        // 2    -> mana Potion
        return this.what;
    }

    public Potion(String potionName, int amount, int what) {
        this.Name = potionName;
        this.many = amount;
        this.what = what % 3;
    }

    public void consume(Player who, Potion pot) {
        switch (this.what) {
            case 0:
                this.consumeBothPotion(who);
                break;
            case 1:
                this.consumeHealPotion(who);
                break;
            case 2:
                this.consumeManaPotion(who);
                break;
            default:
                System.out.println("Potion.consume This option does not exists\t" + this.what);
        }
    }

    private void consumeBothPotion(Player p) {
        p.setItsHealth(p.getItsHealth() + this.many);
        p.setItsMana(p.getItsMana() + this.many);
        System.out.println("Potion.consumeBothPotion Your health now is " + p.getItsHealth());
        System.out.println("Potion.consumeBothPotion Your mana now is " + p.getItsMana());
    }

    private void consumeHealPotion(Player p) {
        p.setItsHealth(p.getMaxHealth() + this.many);
        System.out.println("Potion.consumeHealPotion Your health now is " + p.getItsHealth());
    }

    private void consumeManaPotion(Player p) {
        p.setItsMana(p.getItsMana() + this.many);
        System.out.println("Potion.consumeManaPotion Your mana now is " + p.getItsMana());
    }
}