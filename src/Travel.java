import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Random;
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

	// The Travel has a Cost
	private Random randCost = new Random();

	Travel(Player myself) {
		this.me = myself;
	}

	void visit(String destination) {
		int travelCost = this.calculateCost(me.getCity(), destination);
		System.out.println("Traveling from " + me.getCity() + " to " + destination);
		if(this.checkMoney(destination, travelCost) ) {
			me.setMoney(me.getMoney() - travelCost);
			System.out.println("This trip is allowed because you have enough money");
			System.out.println("Travel.visit You've been charged with " + travelCost + "c");
			System.out.println("Travel.visit You now have " + me.getMoney() + "c");
			me.setCity(destination);
		} else {
			System.out.println("You need " + travelCost + "c to do this trip");
			System.out.println(me.getName() + " is now in City " + me.getCity() + " of " + me.getArea());
		}
	}

	private boolean checkMoney(String destination, int travelCost) {
		System.out.println("You already have " + me.getMoney() + "c");
		System.out.println("This will cost you " + this.calculateCost(me.getCity(), destination) + "c");
		return me.getMoney() > travelCost;
	}

	String selectDestination() {
		System.out.println("The faction of " + me.getName() + " is " + me.getFaction() + " or " + Player.FactionID);
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
				travelDestination = "Daralan";
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
			return this.convertAllianceCity(cityScan.nextInt());
		} catch (InputMismatchException ex) {
			System.out.println("Travel.showAllianceCapitals Invalid Input\t" + cityScan.nextLine());
			ex.printStackTrace();
		}
		return city;
	}

	private String convertAllianceCity(int cityID) {
		String allianceCityName = "Exodar";
		switch (cityID) {
			case 1:
				allianceCityName = "Stormwind";
				break;
			case 2:
				allianceCityName = "Ironforge";
				break;
			case 3:
				allianceCityName = "Silvanaar";
				break;
			default:
				if(cityID > 3) { convertAllianceCity(cityID % 3); }
				System.out.println("Travel.convertAllianceCity destinationCityID can never be " + cityID);
		}
		System.out.println("Travel.convertAllianceCity\t" + allianceCityName);
		return allianceCityName;
	}

	private String showHordeCapitals() {
		System.out.println("**************************");
		System.out.println("** 1) Thunder Bluff 	**");
		System.out.println("** 2) Under City 		**");
		System.out.println("** 3) Silvermoon City 	**");
		System.out.println("**************************");
		System.out.print("What is your destination, " + me.getName() + "? ");
		cityScan = new Scanner(System.in);
		try {
			return this.convertHordeCity(cityScan.nextInt());
		} catch (InputMismatchException ex) {
			System.out.println("Travel.showHordeCapitals Invalid Input\t" + cityScan.nextLine());
			ex.printStackTrace(System.err);
		}
		return "Orgrimmar";
	}

	private String convertHordeCity(int hordeCityName) {
		String city = "Ogrimaar";
		switch ( hordeCityName % 3) {
			case 0:
				city = "Thunder Bluff";
				break;
			case 1:
				city = "UnderCity";
				break;
			case 2:
				city = "Silvermoon City";
				break;
			default:
				System.out.println("Travel.convertHordeCity hordeCityName can not be " + hordeCityName);
				break;
		}
		return city;
	}

	private int calculateCost(String fromCity, String destCity) {
		int cost = randCost.nextInt(50);
		if(Objects.equals(fromCity, "Ironforge") && destCity.equals("Stormwind")) { cost = 30; }
		if(Objects.equals(fromCity, "Ironforge") && destCity.equals("Silvanaar")) { cost = 40; }
		if(Objects.equals(fromCity, "Stormwind") && destCity.equals("Ironforge")) { cost = 40; }
		if(Objects.equals(fromCity, "Stormwind") && destCity.equals("Silvanaar")) { cost = 50; }
		if(Objects.equals(fromCity, "Silvanaar") && destCity.equals("Stormwind")) { cost = 50; }
		if(Objects.equals(fromCity, "Silvanaar") && destCity.equals("Ironforge")) { cost = 40; }
		if(Objects.equals(fromCity, destCity) ) {
			System.out.println("Travel.calculateCost You already are in " + me.getCity());
			System.out.println("Can not travel from " + fromCity + " to " + destCity);
			cost = 0;
		}
		return cost;
	}
}