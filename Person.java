import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import org.json.*;

public class Person {
    
    String name;
    int phone;
    String[] statuslist = {"Normal", "Case", "Close"};
    String status;
    Vector<String> v = new Vector<>();

    Person(String name,int phone) {
        this.name = name;
        this.phone = phone;
        this.status = statuslist[2];
    }
    
    Person(String name,int phone, String status) {
        this.name = name;
        this.phone = phone;
        this.status = status;
    }
    //Testing JSON Parsing
    public void PersonToJSON() {
        JSONObject people = new JSONObject();
        
        people.put("name",name);
        people.put("phone",phone);
        people.put("status",status);

        String filename = "saves.json";

        try (FileWriter file = new FileWriter(filename)) {
            file.write(people.toString());
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
