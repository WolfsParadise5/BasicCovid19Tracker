import java.io.FileWriter;
import java.io.IOException;

import org.json.*;

public class Person {
    
    private String name;
    private int phone;
    private String[] statuslist = {"Normal", "Case", "Close"};
    private String status;
    //Vector<String> v = new Vector<>();

    Person() {}

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


    //Customer shenenigans to move to a new class
    private void checkIn(String date, String time, String location) {
        
        System.out.println("Under construction");
        //Add to JSON
    }

    public void checkStatus() {
        
    }

    public void checkLocation() {

    }






    
}
