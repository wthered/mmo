/**
 * Created by wthered on 12/11/2016 3:28 μμ
 * The Project name is mmo.
 */
class Faction {

	private static int FactionID;
	private static String FactionName;

    Faction(int factionID) {
        this.setFactionID(factionID);
//	    System.out.println("Faction.Faction #" + this.getFactionID() + " or " + this.getFactionName());
    }

    /************************
     ** Setters and Getters **
     ************************/

    // FactionID
    private int getFactionID() {
	    return FactionID;
    }

    private void setFactionID(int factionID) {
	    FactionID = factionID;
    }

    // FactionName
    String getFactionName() {
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
	    return FactionName;
    }

    private void setFactionName(String factionName) {
	    FactionName = factionName;
    }
}