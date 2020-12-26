import org.json.JSONArray;
import org.json.JSONObject;

public class Functions {
    
    public static void LoadPeople() {
        
        JSONObject randomData = new JSONObject();

        //Preload the data
        randomData.put("name","Ur mom");
        randomData.put("age",69);
        randomData.put("status", "Normal");
        
        JSONObject locationTime = new JSONObject();
        
        Long val = Long.valueOf("93939393939393");
        locationTime.put("Tesco", val);

        //Will figure out locations later

        randomData.put("place", locationTime);

    }
}
