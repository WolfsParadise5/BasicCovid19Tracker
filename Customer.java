import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Customer extends Person {
	private String date;
	private String time;
	
	Customer () {}
	
	Customer(String name, int phone, String status, String date, String time) {
		super(name, phone, status);
		this.date = date;
		this.date = time;
	}
	
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
			LocalDateTime date = LocalDateTime.now();
            LocalDateTime time = LocalDateTime.now();
			DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println("=========================");
            System.out.println("|        Check In       |");
            System.out.println("=========================");
            System.out.print("Please enter your location to check in: ");
            mainObj.nextLine();
            String location = mainObj.nextLine();
            System.out.println("You have successfully check into " + location + " at time " + dtfDate.format(date) + " " + dtfTime.format(time) + ".");
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
