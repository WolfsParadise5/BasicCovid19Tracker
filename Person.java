//import org.json.*;

public class Person {
    
    public String name;
    private String phone;
    private String[] statuslist = {"Normal", "Case", "Close"};
    private String status;
    //Vector<String> v = new Vector<>();

    Person() {}

    Person(String name,String phone) {
        this.name = name;
        this.phone = phone;
        this.status = statuslist[0];
    }
    
    Person(String name,String phone, String status) {
        this.name = name;
        this.phone = phone;
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getStatus(){
        return status;
    }

   /*
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
*/

    //Customer shenenigans to move to a new class
    private void checkIn(String date, String time, String location) {
        
        System.out.println("Under construction");
        //Add to CSV
    }

    public void checkStatus() {
        
    }

    public void checkLocation() {

    }






    
}
