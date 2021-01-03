import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;

public class Admin extends Person {
    
    Admin() {}

    public void ChangeCustomerDetail() {
    
    }

    public void DisplayCustomerDetails() {
        System.out.print("CUSTOMER LIST");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Name\t" + "Phone\t" + "Status");
        System.out.println("");
        System.out.println("-------------------------")
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
        JSONParser parseFile = new JSONParser();
        Object file = parseFile.parse(new FileReader("sample.json"));
        JSONArray jsondata = (JSONArray)file;

        //Getting customer data
        JSONObject customer = (JSONObject)jsondata.get(0);
        JSONArray datalist = (JSONArray)customer.get("Customer");
        String foundName = new String();

        int i = 0;
        while(name != foundName) {
            try {
                JSONObject peopleData = (JSONObject)datalist.get(i);
                foundName = (String)peopleData.get("name");
            }

            catch(Exception e) {
                break;
            }
        }

        String status = (String)peopleData.get("status");

        //Change status
        status = "case";

        //Update json
        

        
        i++;

            //Get the time


        //Flags the other customer in one hour radius



        //Flags the shops that kept their doors open
        

    }



}
