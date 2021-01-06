import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class readCSV {
    public static void saveToFile(ArrayList<Customer> obj, String filename, String header) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(header + '\n');
        for (int i = 0; i < obj.size(); i++) {
            sb.append (obj.get(i).toString() + "\n");
            System.out.println(sb);
        }
        Files.write(Paths.get(filename), sb.toString().getBytes());
    }

    public static List<String> readFromFile(String filename) throws IOException {
       return Files.readAllLines(Paths.get(filename));
    }

    public static int row(String filename){
        List<String> data = null; 
        try {data = readCSV.readFromFile("customer.csv");}
        catch (IOException e){}
        return data.size();
    }

}



