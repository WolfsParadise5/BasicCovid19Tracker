import java.util.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
        try {data = readCSV.readFromFile("saves/customer.csv");}
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
        int no = readCSV.row("saves/customer.csv");
        System.out.println("ID:" + no);
        ArrayList<Customer> allCustomer = customerData();
        Customer registerCustomer = new Customer(no, phone, name, "Normal");
        allCustomer.add(registerCustomer);
        try{readCSV.saveToFile(allCustomer, "saves/customer.csv", "No,Phone,Username,Status");}
        catch (IOException e){}
    }

    public static boolean recordData(String path, String shopName)throws IOException{
        List<String> shop;
        shop = readCSV.readFromFile(path);
        for (int i = 0; i < shop.size(); i++){
            String[] items = shop.get(i).split(",");
            if(items[1].contains(shopName)){
                return true;
            }
        }
        return false; 
    }

    public static List<String> recordData() {
        List<String> recData = null;
        try {
            recData = readCSV.readFromFile("saves/record.csv");
        } catch (IOException e) {
        }
        /*
         * for (int i = 1; i < recData.size(); i++){ String[] items =
         * re.get(i).split(","); Customer tempCustomer = new
         * Customer(Integer.parseInt(items[0]), items[1], items[2], items[3]);
         * custData.add(tempCustomer);
         * 
         * }
         */
        return recData;
    }

    public static void checkIn(String name, String date, String time, String shop) {
        ArrayList<String> allRecord = new ArrayList<>();
        int no = readCSV.row("saves/record.csv");
        List<String> history = recordData();
        for (int i = 0; i < history.size(); i++){
            allRecord.add(history.get(i));
        }
        System.out.println("ID:" + no);
        history.add(Integer.toString(no) + "," + date + "," + time + "," + name + "," + shop);
        try{readCSV.saveToFileRecord(allRecord, "saves/record.csv", "No,Date,Time,Name,Shop");}
        catch (IOException e){}
    }

}

class CustomerApp{
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

            try{
                boolean findName = Functions.isNameExists(logInName);
                if (findName){
                    System.out.println("Welcome back! " + logInName);
                    Menu(logInName);
                }
                else{
                    System.out.println("Username not found");
                }
            }
            catch(Exception E){E.printStackTrace();}
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
    public static void Menu(String logInName)
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
                String strDate = dtfDate.format(date);
                String strTime = dtfTime.format(time);
                System.out.println("=========================");
                System.out.println("|        Check In       |");
                System.out.println("=========================");
                System.out.print("Please enter your location to check in: ");
                mainObj.nextLine();
                String location = mainObj.nextLine();
                try {
                    
                    //List<String[]> saveRecord = Functions.openCSVFile("save/record.csv");
                    
                    if (Customer.recordData("saves/shop.csv", location)){
                        System.out.println("You have successfully check into " + location + " at time " + dtfDate.format(date) + " " + dtfTime.format(time) + ".");
                        Customer.checkIn(logInName, strDate, strTime, location);
                    }
                    else{
                        System.out.println("Location not found.");

                    }
                }
                catch (IOException E){};
               
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
        } 
        while (true);
    }
}
