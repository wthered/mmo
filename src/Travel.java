import java.util.*;
import java.util.concurrent.TimeUnit;

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

	// FIXME: 26/11/2016 Each Capital City has a capitalID to prevent traveling from CityID = 3 to CityID = 3 for example
	private Map<Integer, String> capitalCitiesAlliance = new HashMap<>();

	Travel(Player myself) {
		this.me = myself;
		capitalCitiesAlliance.put(1, "Stormwind");
		capitalCitiesAlliance.put(2, "Ironforge");
		capitalCitiesAlliance.put(3, "Darnassus");
	}

	void visit(String newCity, String newArea) {
		int travelCost = this.calculateCost(me.getCity(), newCity);
		System.out.println("Travel.visit Traveling from " + me.getCity() + " to " + newCity + " with cost " + Main.convertMoney(travelCost));

		// If I have the money to feed the centaur during travel
		if (this.checkMoney(newCity, travelCost)) {
			me.setMoney(me.getMoney() - travelCost);
			System.out.println("Travel.visit You've been charged with " + Main.convertMoney(travelCost) );
			System.out.println("Travel.visit You now have " + Main.convertMoney(me.getMoney()) );
			if (!Objects.equals(me.getCity(), newCity)) {
				// TODO: 27/11/2016 When I change City, I should also change Area Properly
				String fromCity = me.getCity() + "," + me.getArea();
				String destCity = newCity + "," + newArea;
				System.out.println("Travel.visit Traveling from " + fromCity + " to " + destCity);
				this.centaur(newCity);
				me.setCity(newCity);
				me.setArea(newArea);
			}
			System.out.println("Travel.visit You now are in " + me.getCity());
		} else {
			System.out.println("Travel.visit You need " + Main.convertMoney(travelCost) + " to do this trip");
			System.out.println("Travel.visit " + me.getName() + " is now in City " + me.getCity() + " of " + me.getArea());
		}
		me.setInCity(true);
	}

	private void centaur(String destination) {
		for (int i = 0; i < destination.length(); i++) {
			try {
				TimeUnit.SECONDS.sleep(5);
				System.out.println("Travel.centaur Traveling from " + me.getCity() + " to " + destination + " on a centaur Step #" + i);
			} catch (InterruptedException e) {
				System.out.println("Travel.centaur Exception Line 57");
				e.printStackTrace();
			}
		}
	}

	private boolean checkMoney(String destination, int travelCost) {
		int theCost = this.calculateCost(me.getCity(), destination);
		System.out.println("Travel.checkMoney You already have " + Main.convertMoney(me.getMoney()) );
		System.out.println("Travel.checkMoney This will cost you " + Main.convertMoney(theCost) );
		return me.getMoney() > travelCost;
	}

	String[] selectDestination() {
		System.out.println("The faction of " + me.getName() + " is " + me.getFaction() + " or " + me.getFactionID());
		String[] travelDestination;
		switch (me.getFactionID()) {
			case 1:
				travelDestination = this.showAllianceCapitals();
				break;
			case 2:
				travelDestination = this.showHordeCapitals();
				break;
			case 0:
				System.out.println("Travel.selectDestination");
				travelDestination = new String[]{"Neutral City", "Neutral Area"};
				break;
			default:
				travelDestination = new String[]{};
				System.out.println("Travel.selectDestination The PlayerFaction can not be " + me.getFactionID());
		}
		return travelDestination;
	}

	private String[] showAllianceCapitals() {
		String[] capitalCity = new String[]{"Exodar", "Azuremist Isles"};
		System.out.println("******************");
		System.out.println("** 1) Stormwind **");
		System.out.println("** 2) Ironforge **");
		System.out.println("** 3) Darnassus **");
		System.out.println("******************");
		System.out.println("Travel.showAllianceCapitals Currently at " + me.getCity() + " of " + me.getArea());
		System.out.print("What is your destination, " + me.getName() + "? ");
		cityScan = new Scanner(System.in);
		try {
			return this.convertAllianceCity(cityScan.nextInt());
		} catch (InputMismatchException ex) {
			System.out.println("Travel.showAllianceCapitals Invalid Input\t" + cityScan.nextLine());
			ex.printStackTrace();
		}
		return capitalCity;
	}

	private String[] convertAllianceCity(int cityID) {
		String[] allianceCityName = new String[]{"Sylvanaar", "Blade Edge mountains"};
		switch (cityID % 4) {
			case 0:
				allianceCityName[0] = "Exodar";
				allianceCityName[1] = "Azuremyst Isle";
				break;
			case 1:
				allianceCityName[0] = "Stormwind";
				allianceCityName[1] = "Elwyn Forest";
				break;
			case 2:
				allianceCityName[0] = "Ironforge";
				allianceCityName[1] = "Dun Morogh";
				break;
			case 3:
				allianceCityName[0] = "Darnassus";
				allianceCityName[1] = "Teldrassil";
				break;
			default:
				System.out.println("Travel.convertAllianceCity destinationCityID can never be " + cityID);
		}
		me.setCity(allianceCityName[0]);
		me.setArea(allianceCityName[1]);
		System.out.println("Travel.convertAllianceCity\t" + allianceCityName[0] + "," + allianceCityName[1]);
		return allianceCityName;
	}

	private String[] showHordeCapitals() {
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
		return new String[]{"Shatrath City", "Random Area"};
	}

	private String[] convertHordeCity(int hordeCityName) {
		String[] city = new String[]{"Random Horde City", "Ogrimaar"};
		switch ( hordeCityName % 3) {
			case 0:
				city[0] = "Thunder Bluff";
				city[1] = "Northern Mulgore";
				break;
			case 1:
				city[0] = "UnderCity";
				city[1] = "Tirisfal Glades";
				break;
			case 2:
				city[0] = "Silvermoon City";
				city[1] = "Eversong Woods";
				break;
			default:
				System.out.println("Travel.convertHordeCity hordeCityName can not be " + hordeCityName);
				break;
		}
		me.setCity(city[0]);
		me.setArea(city[1]);
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
		if (Objects.equals(fromCity, destCity)) {
			System.out.println("Travel.calculateCost You already are in " + me.getCity());
			System.out.println("Can not travel from " + fromCity + " to " + destCity);
			cost = 0;
		}
		return cost;
	}
}