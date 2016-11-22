import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by wthered on 21/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class Travel {

	// MySelf
	private Player me;

	// General Scanner Variable
	private Scanner cityScan;

	Travel(Player myself) {
		this.me = myself;
	}

	void visit(String destination) {
		System.out.println("Traveling to " + destination);
		me.setArea(destination);
	}

	String selectDestination() {
		System.out.println("The faction of Player " + me.getName() + " is " + me.getFaction() + " or " + Player.FactionID);
		String travelDestination;
		switch (Player.FactionID) {
			case 1:
				travelDestination = this.showAllianceCapitals();
				break;
			case 2:
				travelDestination = this.showHordeCapitals();
				break;
			case 0:
				travelDestination = "The Wandering Isles";
				break;
			default:
				travelDestination = "The Wan";
				System.out.println("Travel.selectDestination The PlayerFaction can not be " + Player.FactionID);
		}
		return travelDestination;
	}

	private String showAllianceCapitals() {
		String city = "Exodar";
		System.out.println("******************");
		System.out.println("** 1) Stormwind **");
		System.out.println("** 2) Ironforge **");
		System.out.println("** 3) Silvanaar **");
		System.out.println("******************");
		System.out.print("What is your destination, " + me.getName() + "? ");
		cityScan = new Scanner(System.in);
		try {
			return cityScan.nextLine();
		} catch (InputMismatchException ex) {
			System.out.println("Travel.showAllianceCapitals Invalid Input\t" + cityScan.nextLine());
			ex.printStackTrace();
		}
		return city;
	}

	private String showHordeCapitals() {
		String city = "Orgrimmar";
		System.out.println("**************************");
		System.out.println("** 1) Thunder Bluff 	**");
		System.out.println("** 2) Under City 		**");
		System.out.println("** 3) Silvermoon City 	**");
		System.out.println("**************************");
		System.out.print("What is your destination, " + me.getName() + "? ");
		cityScan = new Scanner(System.in);
		try {
			return cityScan.nextLine();
		} catch (InputMismatchException ex) {
			System.out.println("Travel.showHordeCapitals Invalid Input\t" + cityScan.nextLine());
			ex.printStackTrace(System.err);
		}
		return city;
	}
}