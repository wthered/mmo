import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by wthered on 25/11/2016.
 * The Package name is PACKAGE_NAME
 * The Project name is mmo
 */
public class MainTest {
	@Test
	public void main() throws Exception {
		ArrayList<Player> players = new ArrayList<>(3);
		ArrayList<Race> gamers = new ArrayList<>();
		ArrayList<ArrayList> all = new ArrayList<>();

		Player vasilis = new Player("Vasilis", 1, 2, new Race(), 1);
		vasilis.setCity("Ironforge");
		vasilis.setName("VasilisNewName");
        players.add(vasilis);

		Player william = new Player("William", 3, 2, new Race(), 2);
		william.setCity("Stormwind");
		william.setName("WilliamNewName");
        players.add(william);

		Player wallace = new Player("WillyAm", 6, 1, new Race(), 3);
		wallace.setCity("Darnasus");
		wallace.setName("WallaceNewName");
        players.add(wallace);

        Race theRace = new Race();
        gamers.add(theRace);

        all.add(gamers);
        all.add(players);
        Iterator<ArrayList> arrIter = all.iterator();

//        while (arrIter.hasNext()) {
//            System.out.println("MainTest.main" + arrIter.next());
//            System.out.println("MainTest.main End Loop");
//        }
    }
}