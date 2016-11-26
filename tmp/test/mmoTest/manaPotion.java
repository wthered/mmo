package mmoTest;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is mmoTest
 * The Project name is mmo
 */
public class manaPotion {

    private String name;
    private int mana;
    private String type;

    manaPotion(String manaName, int restore, String arcanePotion) {
        this.name = manaName;
        this.mana = restore;
        this.type = arcanePotion;
    }

    String consume() {
        System.out.println("manaPotion.consume Consumed and now health is full");
        return "************\nfull\n***************\n";
    }

    String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }

    String getType() {
        return type;
    }
}