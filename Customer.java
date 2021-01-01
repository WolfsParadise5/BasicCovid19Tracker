import java.util.*;
import java.time.LocalDateTime;
import java.time.format.Date;

public class Customer {
    static void MainMenu()
    {
        do{
        Scanner mainObj = new Scanner(System.in); 
        System.out.println("=========================");
        System.out.println("|       Main Menu       |");
        System.out.println("=========================");
        System.out.println("1. Check my status");
        System.out.println("2. Check In");
        System.out.println("3. History");
        System.out.println("4. Log Out");
        System.out.print("->");
        int mainSelect = mainObj.nextInt();

        if (mainSelect == 1)
        {
            System.out.println("=========================");
            System.out.println("|         Status        |");
            System.out.println("=========================");
            System.out.println("Your status is :");
        }

        else if (mainSelect == 2)
        {
            System.out.println("=========================");
            System.out.println("|        Check In       |");
            System.out.println("=========================");
            System.out.print("Please enter your location to check in: ");
            mainObj.nextLine();
            String location = mainObj.nextLine();
            System.out.println("You have successfully check into " + location + ".");
        }

        else if(mainSelect == 3)
        {
            System.out.println("=========================");
            System.out.println("|        History        |");
            System.out.println("=========================");
            System.out.println("This is the list of locations you visited");
            System.out.println("----------------------------------------");
            System.out.format("No\t" + "Date\t" + "Time\t" + "Location\t");
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println(" ");
        }
        
        else if(mainSelect == 4)
        {
            break;
        }

        else
        {
            System.out.println("Invalid Input. Please try again.");
        }
    } while (true);
    }

    public static void main(String[] args) {
	do{
		Scanner custObj = new Scanner(System.in);
		System.out.println("=========================");
		System.out.println("|  Sign in or Register? |");
		System.out.println("=========================");
		System.out.println("1. Register");
        System.out.println("2. Log In");
        System.out.println("3. Exit");
		System.out.print("->");
		int selection = custObj.nextInt();

		if(selection == 1)
		{
		    System.out.println("=========================");
	        System.out.println("   Register an account   ");
		    System.out.println("=========================");
		    System.out.print("Enter your name: ");
		    custObj.nextLine();
		    String userName = custObj.nextLine();
		    System.out.print("Enter your phone number: ");
		    int phoneNo = custObj.nextInt();
		    System.out.println("Thank you for your registration " + userName + "." + "Your phone number is " + phoneNo);
        }
		
		else if(selection == 2)
		{
			System.out.println("=========================");
	    	System.out.println("         Log in          ");
			System.out.println("=========================");
            System.out.print("Enter your name: ");
            custObj.nextLine();
            String logInName = custObj.nextLine();
            System.out.println("Welcome back! " + logInName);
            MainMenu();
        }
        
        else if(selection == 3)
        {
            System.out.println("Thanks for your usage! Please come back again.");
            break;
        }

        else
        {   
            System.out.println("Invalid input");
        }
    } while (true);
}
}