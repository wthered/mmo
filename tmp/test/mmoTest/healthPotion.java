package mmoTest;

import java.util.Random;

/**
 * Created by wthered on 26/11/2016.
 * The Package name is mmoTest
 * The Project name is mmo
 */
class healthPotion {
    private String Name;
    private int restore;
    private String type;

    healthPotion(String potionName, int health, String potionType) {
        this.Name = potionName;
        this.restore = health;
        this.type = potionType;
    }

    int consume() {
        Random health = new Random();
        int done = health.nextInt(100);
        System.out.println("healthPotion.consume Your health restored for " + done);
        return done;
    }
}
