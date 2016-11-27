import java.util.Hashtable;

/**
 * Created by wthered on 27/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class weaponBag extends Bag {

    private String oploName;
    private int rows;
    private int columns;
    private Hashtable<Weapon, Integer> weaponIntegerHashtable;

    weaponBag(String weapoName, int rows, int cols, Hashtable<Weapon, Integer> weapons) {
        super(weapoName, rows, cols, new Hashtable<>());
    }

    public String getOploName() {
        return this.oploName;
    }

    public void setOploName(String oploName) {
        this.oploName = oploName;
    }

    Hashtable<Weapon, Integer> getWeaponIntegerHashtable() {
        return this.weaponIntegerHashtable;
    }

    public void setWeaponIntegerHashtable(Hashtable<Weapon, Integer> weaponIntegerHashtable) {
        this.weaponIntegerHashtable = weaponIntegerHashtable;
    }
}
