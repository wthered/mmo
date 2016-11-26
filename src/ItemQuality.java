/**
 * Created by wthered on 26/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class ItemQuality {

    private int quality;

    public ItemQuality(int quality) {
        this.quality = quality;
        System.out.println("ItemQuality.ItemQuality The quality is " + this.getQualityName());
    }

    private String getQualityName() {
        String qName;
        switch (this.getQuality()) {
            case 0:
                qName = "poor";
                break;
            case 1:
                qName = "common";
                break;
            case 2:
                qName = "Uncommon";
                break;
            case 3:
                qName = "Rare";
                break;
            case 4:
                qName = "Epic";
                break;
            case 5:
                qName = "Legendary";
                break;
            case 6:
                qName = "Artifact";
                break;
            case 7:
                qName = "Heirloom";
                break;
            default:
                qName = "poor";
        }
        return qName;
    }

    private int getQuality() {
        return this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}