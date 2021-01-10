import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
import java.time.LocalTime;

public class Functions {
    
    public static void GenerateShops() throws IOException {
        
        ArrayList<Shop> shops = new ArrayList<>();
        File file = new File("saves");
        file.mkdir();

        FileWriter csvFile = new FileWriter("saves/shop.csv");
        
        shops.add(new Shop(1,"Walmart","5478588","Richardo","Normal"));
        shops.add(new Shop(2,"Tesco","3985645","Siti","Normal"));
        shops.add(new Shop(3,"Subway","9478652","Jonathan","Normal"));
        shops.add(new Shop(4,"99SpeedMart","7853141","Dio","Normal"));

        for(int i = 0; i < shops.size(); i++) {
            csvFile.append(shops.get(i).toCSVString() + "\n");
        }
        csvFile.flush();
        csvFile.close();
    }

    public static void GenerateCustomer() throws IOException {
        
        ArrayList<Customer> customer = new ArrayList<>();

        FileWriter csvFile = new FileWriter("saves/customer.csv");
        
        customer.add(new Customer(1,"Michael","121174560","Normal"));
        customer.add(new Customer(2,"Siti","139856458","Normal"));
        customer.add(new Customer(3,"Dio","194786523","Normal"));
        customer.add(new Customer(4,"Giorno","153489898","Normal"));
        customer.add(new Customer(5,"Ali","15449898","Normal"));

        for(int i = 0; i < customer.size(); i++) {
            csvFile.append(customer.get(i).toString() + "\n");
        }
        csvFile.flush();
        csvFile.close();
    }


    
    public static void LoadPeople() throws IOException {

        ArrayList<Admin> records = new ArrayList<>();
        int id = 1;
        if (isFileExists("saves/records.csv")) {

            //Read all the csv data
            List<String> lines = Files.readAllLines(Paths.get("saves/records.csv"));

            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");
                id = Integer.parseInt(items[0]);
                records.add(new Admin(id, items[1],Integer.parseInt(items[2]),items[3]));
            }
        }

        else {
            File file = new File("saves");
            file.mkdir();
            
        }

        FileWriter csvFile = new FileWriter("saves/records.csv");
        
        String[] names = {"Siti","Ricardo","Jonathan","Dio","Ghorno"};
        String[] shops = {"Walmart","99SpeedMart","Tesco","Sunway"};
        long[] times = new long[30];
            
        Random generate = new Random();
            
        //List to iterate to put in CSV

        for (int i=0; i < 30; i++) {
            long num = System.currentTimeMillis()/1000 - (long)(Math.random()*(86400-(0+1)+(0)));
            times[i] = num;

        }
        Arrays.sort(times);
        
        for(int i=id+1; i < 31+id; i++) {
            
            int randomIndex = generate.nextInt(names.length);
            int randomIndex2 = generate.nextInt(shops.length);
            String name = names[randomIndex];
            String shop = shops[randomIndex2];
            if (id > 1) 
                records.add(new Admin(i, name, times[i-id-1],shop));
            else
                records.add(new Admin(i-1, name, times[i-id-1],shop));
        }

        for(int i = 0; i < records.size(); i++) {
            csvFile.append(records.get(i).toCSVString() + "\n");
        }
        csvFile.flush();
        csvFile.close();

        System.out.println("Random people ready to go!");

    }

    public static boolean isNameExists(String name) throws IOException, FileNotFoundException {

        //Open the CSV
        List<String[]> customerData = openCSVFile("saves/customer.csv");

        //Iterate through customer list to find the name
        for (int i= 0; i < customerData.size(); i++) {
            if(customerData.get(i)[1].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isShopExists(String shopName) throws IOException, FileNotFoundException {
        //Open the CSV
        List<String[]> customerData = openCSVFile("saves/shop.csv");

        //Iterate through customer list to find the name
        for (int i= 0; i < customerData.size(); i++) {
            if(customerData.get(i)[1].equalsIgnoreCase(shopName)) {
                return true;
            }
        }
        return false;
    }

    public static List<String[]> openCSVFile(String filePath) throws IOException{

        CSVReader getData = new CSVReader(new FileReader(filePath),',');
        List<String[]> contents = getData.readAll();
        return contents;

    }


    public static LocalDate getDate(String seconds) {
        long day = Long.parseLong(seconds) / 86400;
        return LocalDate.ofEpochDay(day);
    }

    public static LocalTime getTime(String seconds) {
        long second = Long.parseLong(seconds);
        while(second >= 86400) {
            second -= 86400;
        }

        return LocalTime.ofSecondOfDay(second);
    }

    public static String addSpace(String variable) {
        int variableLength = variable.length();
        String returnString = "";
        
        while(variableLength != 12) {
            returnString += " ";
            variableLength++;
        }
        return returnString;
    }

    public static boolean isFileExists(String filepath) {
        File checkFile = new File(filepath);
        return checkFile.exists();
    }
    
    public static int returnNextNumber(String filepath) throws IOException{

        int num = 0;
        List<String[]> contents = openCSVFile(filepath);
        for(int i=0; i < contents.size(); i++) {
            num = i;

        

        }
        return num + 1;
    }

}
