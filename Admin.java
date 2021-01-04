import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
//import java.util.LinkedList;
//import java.io.BufferedReader;

public class Admin extends Person {
    
    Admin() {}

    public void ChangeCustomerDetail() {
    
    }

    public void DisplayCustomerDetails() {
        System.out.print("CUSTOMER LIST");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Name\t" + "Phone\t" + "Status");
        System.out.println("");
        System.out.println("-------------------------");
    }
    
    public void DisplayShopDetails() {
        System.out.print("SHOP LIST");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Name\t" + "Phone\t" + "Manager\t" + "Status");
        System.out.println("");
        System.out.println("-------------------------");
    }

    public void MasterVisitHistory() {
        System.out.print("MASTER VISIT HISTORY");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Date\t" + "Time\t" + "Customer\t" + "Shop");
        System.out.println("");
        System.out.println("-------------------------");
    }
    
    
    public void changeToCase(String name) {
        //Find location went by customer
        File file = new File("saves/customer.csv");
        
        //Read existing file
        try {
            CSVReader reader = new CSVReader(new FileReader(file), ',');
            List<String[]> csvbody = reader.readAll();

            for(int i=0; i < csvbody.size(); i++) {
                String[] strArray = csvbody.get(i);
                for(int j=0; j<strArray.length; j++) {
                    if (strArray[j].equalsIgnoreCase(name)) {
                        csvbody.get(i)[j+1] = "Case"; 
                    }
                }
            }

            reader.close();

            FileWriter fi = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fi,',');

            writer.writeAll(csvbody);
            writer.flush();
            writer.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        //Flags the other customer in one hour radius



        //Flags the shops that kept their doors open
        

    }



}
