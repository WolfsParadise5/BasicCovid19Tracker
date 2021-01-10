import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class RunFile {
    
    public static void main(String[] args) {
        
        if (!Functions.isFileExists("saves/records.csv")) {
            try {
            Functions.GenerateShops();
            Functions.GenerateCustomer();
            }

            catch (IOException e) {
                System.out.println("Unable to generate");
            }
        }
        Scanner custObj = new Scanner(System.in);
        //Main Menu
        do{
            
            
            
            System.out.println("=========================");
            System.out.println("|  Sign in or Register? |");
            System.out.println("=========================");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("->");
            
            int selection = custObj.nextInt();
            //signIn.close();
    
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
                //register.close();
            }
            
            else if(selection == 2)
            {

                System.out.println("=========================");
                System.out.println("         Log in          ");
                System.out.println("=========================");
                
                System.out.println("");
                System.out.println("Select login type: ");
                System.out.println("");
                
                System.out.println("1. Customer");
                System.out.println("2. Shop");
                int typeLoginSelection = custObj.nextInt();

                //Customer
                if (typeLoginSelection == 1) {
                    System.out.println("");
                    System.out.print("Enter your name: ");
                    custObj.nextLine();
                    String logInName = custObj.nextLine();
                    
                    if (!logInName.equals("admin")) {   
                        try{
                            boolean findName = Functions.isNameExists(logInName);
                            
                            if (findName){
                                System.out.println("Welcome back! " + logInName);
                                CustomerMenu(logInName); //Fix starts here
                            }
                            else {
                                System.out.println("Username not found");
                            }
                        }
                        
                        catch (Exception E) {
                            E.printStackTrace();
                        }
                    }

                    else {
                        System.out.println("Admin detected!");
                        adminMenu();
                    }
                }

                //Shop
                else if (typeLoginSelection == 2) {
                    System.out.println("");
                    System.out.print("Enter your name: ");
                    custObj.nextLine();
                    String logInName = custObj.nextLine();

                    try {
                        boolean findShop = Functions.isShopExists(logInName);

                        if (findShop) {
                            System.out.println("Welcome back! " + logInName);
                            ShopMenu(logInName); //Fix starts here
                        }
                        else {
                            System.out.println("Shop not found");
                        }
                    }

                    catch (Exception E) {
                        E.printStackTrace();
                    }
                }

                else {
                    System.out.println("Invalid input, please try again");
                }

                
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
        } 
        while (true);
    }

    public static void CustomerMenu(String logInName) {
        Scanner mainObj2 = new Scanner(System.in); 
        do {
            
            
            System.out.println("=========================");
            System.out.println("|       Main Menu       |");
            System.out.println("=========================");
            System.out.println("1. Check my status");
            System.out.println("2. Check In");
            System.out.println("3. History");
            System.out.println("4. Log Out");
            System.out.print("->");
            
            int mainSelect = mainObj2.nextInt();

            if (mainSelect == 1)
            {
                System.out.println("=========================");
                System.out.println("|         Status        |");
                System.out.println("=========================");
                System.out.print("Your status is :");
                try {
                    List<String[]> nameData = Functions.openCSVFile("saves/customer.csv");
                    for(int i=0; i < nameData.size(); i++) {
                        if (nameData.get(i)[1].equalsIgnoreCase(logInName)) {
                            System.out.println(nameData.get(i)[3]);
                        } 
        
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
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
                mainObj2.nextLine();
                String location = mainObj2.nextLine();
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
                try {
                    List<String[]> nameData = Functions.openCSVFile("saves/records.csv");
                    int index = 1;
                    for(int i=0; i < nameData.size(); i++) {
                        if (nameData.get(i)[1].equalsIgnoreCase(logInName)) {
                            //Sort date and time display
                            System.out.println(nameData.get(index)[0] + "\t" + nameData.get(i)[1] + "\t" + nameData.get(i)[2] + "\t" + nameData.get(i)[3]);
                            index++;
                        } 
        
                    }
                }
        
                catch (IOException e) {
                    e.printStackTrace();
                }
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

    public static void ShopMenu(String shopName) {
        do {
            Scanner shopScanner = new Scanner(System.in);

            Shop shop = new Shop();

            System.out.println("-------------");
            System.out.println("==========================");
            System.out.println("|1. View Status          |");
            System.out.println("|2. Exit                 |");
            System.out.println("==========================");
            System.out.print("->");

            int inputData = shopScanner.nextInt();

            if (inputData == 1) {
                shop.checkStatus(shopName);
            }

            else if (inputData == 2) {
                System.out.println("Logging off.");
                break;
            }

            else {
                System.out.println("Invalid input.");
            }
 


        }
        while(true);
    }

    public static void adminMenu()
    {
        Scanner adminScanner = new Scanner(System.in);
        do{
            Admin admin = new Admin();

            System.out.println("-------------");
            System.out.println("==========================");
            System.out.println("|1. Master visit history |");
            System.out.println("|2. View customer list   |");
            System.out.println("|3. View shop list       |");
            System.out.println("|4. Flag customer        |");
            System.out.println("|5. Load 30 customer data|");
            System.out.println("|6. Exit                 |");
            System.out.println("==========================");
            System.out.print("->");
            int mainSelect = adminScanner.nextInt();

            if(mainSelect == 1)
                admin.MasterVisitHistory();

            else if(mainSelect == 2)
                admin.DisplayCustomerDetails();

            else if(mainSelect == 3)
                admin.DisplayShopDetails();

            else if(mainSelect == 4) {

                System.out.println(" ");
                System.out.println("==========================");
                System.out.print("Pick a customer to flag: ");
                String flagName = adminScanner.next();

                admin.changeToCase(flagName);  
            }
            
            else if(mainSelect == 5)
                try {Functions.LoadPeople();} catch (IOException e) {e.printStackTrace();}

            else if(mainSelect == 6)
            {
                System.out.println("Logging off. See you again Agent 47.");
                break;
            }
        }
        while (true);
    }
}
