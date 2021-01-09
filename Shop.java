import java.io.IOException;
import java.util.List;

public class Shop extends Person {
    
    private String manager;

    Shop() {}
    
    Shop(String manager, String name, String status, String phone) {
        super(name, phone, status);
        this.manager = manager;
    }

    public void checkStatus() {
        System.out.println("STATUS");
        System.out.println("-------------------------------------------------------------");
        System.out.format("No\t" + "Name        " + "Phone\t" + "Manager     " + "Status");
        System.out.println("");
        System.out.println("-------------------------------------------------------------");

        //Get shop data
        try {
            List<String[]> nameData = Functions.openCSVFile("saves/shop.csv");
            int index = 0;
            for(int i=0; i < nameData.size(); i++) {
                if (nameData.get(i)[1].equalsIgnoreCase(name)) {
                    System.out.println(nameData.get(index)[0] + "\t" + nameData.get(index)[1] + Functions.addSpace(nameData.get(index)[1]) + nameData.get(index)[2] + "\t" + nameData.get(index)[3] + Functions.addSpace(nameData.get(index)[3]) + nameData.get(index)[4]);
                    index++;
                } 

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        

    }
}
