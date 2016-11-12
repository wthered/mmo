import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * Created by wthered on 12/11/2016 3:23 μμ
 * The Project name is mmo.
 */
class Player implements playerInterface {

    // Player Attributes
    private String Name;
    private int level;
    private int money;
    private int health;
    private int mana;

    public Player(String newName, int newLevel, int FactionID, int RaceID, int classID) {
        this.setName(newName);
        this.setHealth(100 * newLevel);
        this.setMana(150 * newLevel);
        this.setMoney(0);

        System.out.println("Faction #" + FactionID + ", race = " + RaceID + ", Class = " + classID);
    }

    /*********************
     * Setter & Getters **
     ********************/

    // playerName
    public String getName() {
        return Name;
    }

    private void setName(String name) {
        Name = name;
    }

    // Level
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Money money money
    public int getMoney() {
        return this.money;
    }

    private void setMoney(int money) {
        this.money = money;
    }

    // Health
    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    // Mana
    public int getMana() {
        return this.mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    // Methods inherited from plaerInterface
    @Override
    public void showMoney() {
        System.out.println("Player.showMoney");
    }

    @Override
    public void getFaction() {
        System.out.println("Player.getFaction");
    }

    @Override
    public void showHealth() {
        System.out.println("Player.showHealth");
    }

    @Override
    public void showMana() {
        System.out.println("Player.showMana");
    }


}