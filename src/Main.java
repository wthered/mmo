public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Main.main");

        int action = createOrLogin();
        System.out.println("Last action was " + action);
    }

    private static int createOrLogin() {
        return 3;
    }
}