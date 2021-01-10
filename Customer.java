import java.util.*;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Customer extends Person {
    private int no;
	
	Customer () {}
	
	Customer(int no, String name, String phone, String status) {
		super(name, phone, status);
        this.no = no;
    }

    public String toString(){
        return no + "," + getName() + ","+ getPhone() + "," + getStatus();
    }

    public void Register(String phone, String name){

        try{
            int no = 0;
            ArrayList<Customer> custData = new ArrayList<>();
            List<String> data = null; 
            try {data = readCSV.readFromFile("saves/customer.csv");}
            catch (IOException e){}
            for (int i = 0; i < data.size(); i++){
                String[] items = data.get(i).split(",");
                Customer tempCustomer = new Customer(Integer.parseInt(items[0]), items[1], items[2], items[3]);
                custData.add(tempCustomer);
                no = i;
            }

            FileWriter writeToCSV = new FileWriter("saves/customer.csv");
            no += 2;
            System.out.println("ID:" + no);
            
            Customer registerCustomer = new Customer(no, name, phone, "Normal");
            custData.add(registerCustomer);
            
            for(int i = 0; i < custData.size(); i++) {
                writeToCSV.append(custData.get(i).toString() + "\n");
            }

            writeToCSV.flush();
            writeToCSV.close();  
        }
        catch (IOException e){}
        
    }

    public static boolean recordData(String path, String shopName)throws IOException{
        List<String> shop;
        shop = readCSV.readFromFile(path);
        for (int i = 0; i < shop.size(); i++){
            String[] items = shop.get(i).split(",");
            if(items[1].contains(shopName)){
                return true;
            }
        }
        return false; 
    }

    public static List<String> recordData() {
        List<String> recData = null;
        try {
            recData = readCSV.readFromFile("saves/record.csv");
        } catch (IOException e) {
        }
        /*
         * for (int i = 1; i < recData.size(); i++){ String[] items =
         * re.get(i).split(","); Customer tempCustomer = new
         * Customer(Integer.parseInt(items[0]), items[1], items[2], items[3]);
         * custData.add(tempCustomer);
         * 
         * }
         */
        if(recData != null){
            recData.remove(0);
        }
        return recData;
    }

    public static void checkIn(String name, long seconds, String shop) throws IOException {
        
        File file = new File("saves/records.csv");

        //Read existing file
        try {
            CSVReader reader = new CSVReader(new FileReader(file), ',');
            List<String[]> csvbody = reader.readAll();

            int i = csvbody.size();
            csvbody.add(new String[]{Integer.toString(i+1),name,Long.toString(seconds),shop});

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
    }

}