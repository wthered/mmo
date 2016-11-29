import java.util.Scanner;

/**
 * Created by wthered on 19/11/2016.
 * The Package Name is PACKAGE_NAME
 * Feel Free to Edit mmo
 */
class userAuth {

	private String username;

	userAuth(String username) {
		this.username = username;
	}

	boolean validateName() {
		Boolean valid = false;
		if (this.username.matches("^[a-zA-Z]+")) { valid = true; }
		return valid;
	}

	String getUserName(Scanner userScan) {
		System.out.println("invalid Username! redo from start");
		System.out.print("What is you username? ");
		return this.username;
	}

	void setUsername(String username) {
		this.username = username;
	}
}