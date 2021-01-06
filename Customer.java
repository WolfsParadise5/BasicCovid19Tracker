import java.util.*;

//import jdk.vm.ci.code.Register;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

public class Customer extends Person {
    private int no;
	
	Customer () {}
	
	Customer(int no, String phone, String name, String status) {
		super(name, phone, status);
        this.no = no;
    }
    public ArrayList<Customer> customerData(){
        ArrayList<Customer> custData = new ArrayList<>();
        List<String> data = null; 
        try {data = readCSV.readFromFile("customer.csv");}
        catch (IOException e){}
        for (int i = 1; i < data.size(); i++){
            String[] items = data.get(i).split(",");
            Customer tempCustomer = new Customer(Integer.parseInt(items[0]), items[1], items[2], items[3]);
            custData.add(tempCustomer);
        }
        return custData;
    }

    public String toString(){
        return no + "," + getPhone() + ","+ getName() + "," + getStatus();
    }

    public void Register(String phone, String name){
        int no = readCSV.row("customer.csv");
        System.out.println("ID:" + no);
        ArrayList<Customer> allCustomer = customerData();
        Customer registerCustomer = new Customer(no, phone, name, "Normal");
        allCustomer.add(registerCustomer);
        try{readCSV.saveToFile(allCustomer, "customer.csv", "No,Phone,Username,Status");}
        catch (IOException e){}
    }
}

class CustomerApp{
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
        mainObj.close();
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
            String phoneNo = custObj.nextLine();
            Customer c = new Customer();
            c.Register(phoneNo, userName);
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
