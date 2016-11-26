package mmoTest;

import java.util.ArrayList;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is mmoTest
 * The Project name is mmo
 */
public class Potion {

    private String name;
    private String type;
    private ArrayList inventory;

    public Potion(String potionName, String potionType, ArrayList invite) {
        this.name = potionName;
        this.type = potionType;
        this.inventory = invite;
    }
}
