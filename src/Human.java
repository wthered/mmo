import java.util.Scanner;

/**
 * Created by wthered on 18/11/2016.
 * This is not the default Template
 */
class Human {

	private int HumanClassID;
	private String HumanClass;
	private Player myself;

	Human(Player p) {
		this.myself = p;
		System.out.println("Human.Human Constructor");
	}

	int selectClass() {
		System.out.println("Human.selectClass");
		System.out.println("*****************");
		System.out.println("** 1) Magician **");
		System.out.println("** 2) Paladin  **");
		System.out.println("** 3) Priest   **");
		System.out.println("** 4) Rogue    **");
		System.out.println("** 5) Warlock  **");
		System.out.println("** 6) Warrior  **");
		System.out.println("** 7) Hunter   **");
		System.out.println("** 8) Monk     **");
		System.out.println("*****************");
        System.out.print("Select your Class, Human? ");
        Scanner humanScan = new Scanner(System.in);
		try {
			myself.ClassID = humanScan.nextInt();
			this.setHumanClassID(myself.ClassID);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
        return this.HumanClassID;
    }

//    public int getHumanClassID() {
//        return HumanClassID;
//    }

    private void setHumanClassID(int humanClassID) {
        this.HumanClassID = humanClassID;
    }

    public String getHumanClass() {
	    switch (this.HumanClassID) {
		    case 1:
		    	this.setHumanClass("Mage");
			    break;
		    case 2:
		    	this.setHumanClass("Paladin");
			    break;
		    case 3:
		    	this.setHumanClass("Priest");
			    break;
		    case 4:
		    	this.setHumanClass("Rogue");
			    break;
		    case 5:
		    	this.setHumanClass("Warlock");
			    break;
		    case 6:
		    	this.setHumanClass("Warrior");
			    break;
		    case 7:
		    	this.setHumanClass("Hunter");
			    break;
		    case 8:
		    	this.setHumanClass("Monk");
			    break;
		    default:
			    System.out.println("Human.getHumanClass This is never reached");
			    this.setHumanClass("StarYoda");
	    }
        return HumanClass;
    }

    private void setHumanClass(String humanClass) {
        this.HumanClass = humanClass;
    }


}
