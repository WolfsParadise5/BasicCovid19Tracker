import java.util.*;

public class Administrator {
    static void adminMenu()
    {
        do{
            Scanner mainObj = new Scanner(System.in);
            System.out.println("-------------");
            System.out.println("==========================");
            System.out.println("|1. Master visit history |");
            System.out.println("|2. View customer list   |");
            System.out.println("|3. View shop list       |");
            System.out.println("|4. Flag customer        |");
            System.out.println("|5. Exit                 |");
            System.out.print("->");
            int mainSelect = mainObj.nextInt();

            if(mainSelect == 1)
            {
                System.out.print("MASTER VISIT HISTORY");
                System.out.println("-------------------------");
                System.out.format("No\t" + "Date\t" + "Time\t" + "Customer\t" + "Shop");
                System.out.println("");
                System.out.println("-------------------------");
            }

            else if(mainSelect == 2)
            {
                System.out.print("CUSTOMER LIST");
                System.out.println("-------------------------");
                System.out.format("No\t" + "Name\t" + "Phone\t" + "Status");
                System.out.println("");
                System.out.println("-------------------------");
            }

            else if(mainSelect == 3)
            {
                System.out.print("SHOP LIST");
                System.out.println("-------------------------");
                System.out.format("No\t" + "Name\t" + "Phone\t" + "Manager\t" + "Status");
                System.out.println("");
                System.out.println("-------------------------");
            }

            else if(mainSelect == 4)
            {
                System.out.println("I don't know how to do this yet lol");
            }

            else if(mainSelect == 5)
            {
                System.out.println("Logging off. See you again Agent 47.");
                break;
            }
            }while (true);
        }
    }
    public static void main(String[] args) {
        do{
            Scanner adminObj = new Scanner(System.in);
            System.out.println("=========================");
            System.out.println("|      Admin System     |");
            System.out.println("=========================");
            System.out.print("Please key in your administrator key to process: ");
            int adminKey = adminObj.nextInt();

            if(adminKey == 69420)
            {
                System.out.println("Welcome back Agent 47. What can I help you today?");
                adminMenu();
                break;
            }

            else
            {
                System.out.println("Intruder detected! System will shut down immediately.");
                break;
            }
        }while (true);
    }
}
