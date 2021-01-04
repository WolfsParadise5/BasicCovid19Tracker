/*
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;

public class TestJSON {

    public static void main(String[] args) {
        System.out.println("Testing JSON file");

        JSONParser parseFile = new JSONParser();

        try
        {
            Object file = parseFile.parse(new FileReader("sample.json"));
            JSONArray jsondata = (JSONArray)file;

            //Getting customer data
            JSONObject customer = (JSONObject)jsondata.get(0);
            JSONArray datalist = (JSONArray)customer.get("Customer");

            //Get specific customer
            String name = "Siti Ricardo";  //Test find name
            String foundName = new String();
            int i = 0;

            try {
                int length = datalist.length; 
                System.out.print(length);
                while(foundName != name) {
                    JSONObject peopleData = (JSONObject)datalist.get(i);
                    foundName = (String)peopleData.get("name");

                    System.out.println(name + "=" + foundName);
                    long phone = (long)peopleData.get("phone");
                    String[] location = (String[])peopleData.get("location");
                    String[] timeCheckedin = (String[])peopleData.get("timeCheckedIn");
                    
                    String status = (String)peopleData.get("status");
                    String username = (String)peopleData.get("username");

                    System.out.print("Phone: " + phone + ", Status "  + status + ", Usermame: "  + username);
                    
                    i++;
                }
                  


            }
            
            catch (Exception e) {
                e.printStackTrace();
            }

            //Getting shop data
            JSONObject shop = (JSONObject)jsondata.get(1);

            System.out.print(datalist);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

*/