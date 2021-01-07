import java.time.Instant;

public class TestFunc {
    
    public static void main(String[] args) {
        //
    Functions.LoadPeople();
        //Testing Flag
    Admin admin = new Admin();
        //admin.changeToCase("Siti");
        /*Testing millisecond
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
        */
    admin.DisplayCustomerDetails();
    admin.DisplayShopDetails();
    admin.MasterVisitHistory();
    }
}
