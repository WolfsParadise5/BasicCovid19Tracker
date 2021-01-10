import java.io.IOException;
import java.util.List;

public class Shop extends Person {
    
    private String manager;
    private int no;

    Shop() {}
    
    Shop(int no, String name, String phone, String manager, String status) {
        super(name, phone, status);
        this.manager = manager;
        this.no = no;
    }

    public void checkStatus(String name) {
        System.out.print("STATUS: ");

        //Get shop data
        try {
            List<String[]> nameData = Functions.openCSVFile("saves/shop.csv");

            for(int i=0; i < nameData.size(); i++) {
                if (nameData.get(i)[1].equalsIgnoreCase(name)) {
                    System.out.print(nameData.get(i)[4]);
                    System.out.println("");
                } 

            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        

    }

    public String toCSVString() {
        return no + "," + getName() + "," + getPhone() + "," + manager + "," + getStatus();
    }
}
