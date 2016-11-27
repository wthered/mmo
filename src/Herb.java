/**
 * Created by wthered on 27/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class Herb {

    private String herbName;
    private boolean collected;

    public Herb(String Name, boolean collectable) {
        this.herbName = Name;
        this.collected = collectable;
    }

    public String getHerbName() {
        return herbName;
    }

//    public void setHerbName(String herbName) {
//        this.herbName = herbName;
//    }

    public boolean isCollected() {
        return this.collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
