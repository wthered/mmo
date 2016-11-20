import java.util.Scanner;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class userAuth {

	private final ThreadLocal<String> name;

	userAuth(String username) {
		name = new ThreadLocal<>();
		this.name.set(username);
	}

	boolean validateName() {
		String name = this.name.get();
		Boolean valid = false;
		if (name.matches("^[a-zA-Z]{1,}")) { valid = true; }
		return valid;
	}

	void getNewName(Scanner userScan) {
		System.out.println("invalid Username! redo from start");
		System.out.print("What is you username? ");
		this.name.set(userScan.nextLine());
	}
}