import java.io.BufferedReader;
import java.io.File;
//import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readCSV {
    
    public static void main(String[] args) {

        //Generate them csv file
        Functions.LoadPeople();

        //Read
        File file = new File("saves/customer.csv");
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while((line = br.readLine()) != null) {

                String[] values = line.split(",");
                System.out.println(values[0] + " " + values[1] + " " + values[2] + " " + values[3]);
            }

            br.close();
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
