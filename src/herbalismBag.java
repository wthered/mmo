import java.util.Hashtable;

/**
 * Created by wthered on 27/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class herbalismBag extends Bag {

    private String herbsBagName;
    private int herbRows;
    private int herbColumns;
    private Hashtable<Herb, Integer> herbs = new Hashtable<>();

    herbalismBag(String bagName, int rows, int cols, Hashtable<Herb, Integer> herbTable) {
        super(bagName, rows, cols, new Hashtable<>());
    }

    public String getHerbsBagName() {
        return this.herbsBagName;
    }

    public void setHerbsBagName(String herbsBagName) {
        this.herbsBagName = herbsBagName;
    }

    public int getHerbRows() {
        return this.herbRows;
    }

    public void setHerbRows(int herbRows) {
        this.herbRows = herbRows;
    }

    public int getHerbColumns() {
        return this.herbColumns;
    }

    public void setHerbColumns(int herbColumns) {
        this.herbColumns = herbColumns;
    }

    Hashtable<Herb, Integer> getHerbs() {
        return this.herbs;
    }

    public void setHerbs(Hashtable<Herb, Integer> herbs) {
        this.herbs = herbs;
    }
}