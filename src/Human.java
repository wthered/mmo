import java.util.Scanner;

/**
 * Created by wthered on 18/11/2016.
 * This is not the default Template
 */
class Human {

	private int HumanClassID;
	private String HumanClass;

	Human() {
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
        System.out.print("Select your Human Class? ");
        Scanner humanScan = new Scanner(System.in);
        int humanClass = humanScan.nextInt();
        this.setHumanClassID(humanClass);
        return humanClass;
    }

    public int getHumanClassID() {
        return HumanClassID;
    }

    private void setHumanClassID(int humanClassID) {
        this.HumanClassID = humanClassID;
    }

    public String getHumanClass() {
        return HumanClass;
    }

    public void setHumanClass(String humanClass) {
        this.HumanClass = humanClass;
    }


}
