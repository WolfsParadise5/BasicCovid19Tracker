import java.util.*;

public class Authentication {
  public static void main(String[] args) {
	
	Scanner logObj = new Scanner(System.in);
	
	System.out.println("=========================");
	System.out.println("- Sign in or Register? -");
	System.out.println("=========================");
	System.out.println("1. Sign In");
	System.out.println("2. Register");
	
	System.out.print("->");
	int selection = logObj.nextInt();
	logObj.close();

	if (selection == 1){
		Scanner regObj = new Scanner(System.in);
		System.out.println("=========================");
	    System.out.println("          Sign in        ");
		System.out.println("=========================");

		System.out.println();
	}

	if (selection == 2){
		Scanner loginObj = new Scanner(System.in);
		System.out.println("=========================");
	    System.out.println("   Register an account   ");
		System.out.println("=========================");

		System.out.println();
	}
  }
}