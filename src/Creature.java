import java.util.HashMap;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class Creature {

    private String itsName;
    private int maxHeal;
    private int maxMana;
    private int itsLevel;
    private boolean isHigh;
    private HashMap position;

    public Creature(String Name, int maxHealth, int maxMana, int itsLevel, boolean elite, HashMap pos) {
        this.itsName = Name;
        this.maxHeal = maxHealth;
        this.maxMana = maxMana;
        this.itsLevel= itsLevel;
        this.isHigh = elite;
        this.position= pos;
    }

    public String getItsName() {
        return this.itsName;
    }

    public void setItsName(String itsName) {
        this.itsName = itsName;
    }

    public int getMaxHeal() {
        return this.maxHeal;
    }

    public void setMaxHeal(int maxHeal) {
        this.maxHeal = maxHeal;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getItsLevel() {
        return this.itsLevel;
    }

    public void setItsLevel(int itsLevel) {
        this.itsLevel = itsLevel;
    }

    public boolean isHigh() {
        return this.isHigh;
    }

    public void setHigh(boolean high) {
        this.isHigh = high;
    }

    public HashMap getPosition() {
        return this.position;
    }

    public void setPosition(HashMap<Integer, Integer> position) {
        this.position = position;
    }
}