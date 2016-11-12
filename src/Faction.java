/**
 * Created by wthered on 12/11/2016 3:28 μμ
 * The Project name is mmo.
 */
class Faction {

    private int FactionID;
    private String FactionName;

    Faction(int factionID) {
        this.setFactionID(factionID);
        System.out.println("Faction.Faction #" + this.getFactionID() + " or " + this.getFactionName() );
    }

     /************************
     ** Setters and Getters **
     ************************/

    // FactionID
     private int getFactionID() {
        return this.FactionID;
    }

    private void setFactionID(int factionID) {
        this.FactionID = factionID;
    }

    // FactionName
    private String getFactionName() {
        switch (this.getFactionID()) {
            case 1:
                this.setFactionName("Alliance");
                break;
            case 2:
                this.setFactionName("Horde");
                break;
            default:
                System.out.println("This is never reached in Faction.getFactionName");
                break;
        }
        return this.FactionName;
    }

    private void setFactionName(String factionName) {
        this.FactionName = factionName;
    }
}