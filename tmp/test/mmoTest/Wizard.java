package mmoTest;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is mmoTest
 * The Project name is mmo
 */
public class Wizard {
    private String wizardName;
    private int wizardLevel;
    private String special;

    public Wizard(String itsName, int level, String speciality) {
        this.special = speciality;
        this.wizardLevel = level;
        this.wizardName = itsName;
    }
}
