import com.opencsv.CSVWriter;
import java.util.LinkedList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.io.File;

public class Functions {
    
    public static void LoadPeople() {

        //Generate the customer CSV
        try {
            File file = new File("saves");
            file.mkdir();
            CSVWriter csvwriteCust = new CSVWriter(new FileWriter("saves/customer.csv"));

            List<String[]> shopCust = new LinkedList<String[]>();
            shopCust.add(new String[]{"1","121174560","Richardo","Normal"});
            shopCust.add(new String[]{"2","139856458","Siti","Normal"});
            shopCust.add(new String[]{"3","194786523","Jonathan","Normal"});
            shopCust.add(new String[]{"4","178531417","Dio","Normal"});
            shopCust.add(new String[]{"5","153489898","Giorno","Normal"});

            csvwriteCust.writeAll(shopCust);
            csvwriteCust.close();
            System.out.println("shop.csv generated!");
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        
        //Generate the shops CSV file
        try {
            CSVWriter csvwriteShop = new CSVWriter(new FileWriter("saves/shop.csv"));

            List<String[]> shopRows = new LinkedList<String[]>();
            shopRows.add(new String[]{"1","Walmart","5478588","Fong","Normal"});
            shopRows.add(new String[]{"2","7-Eleven","7685900","Naga","Normal"});
            shopRows.add(new String[]{"3","FamilyMart","8903890","Ali","Normal"});
            shopRows.add(new String[]{"4","Tesco","4758210","Boy","Normal"});
            shopRows.add(new String[]{"5","Sunway","35884762","Dutch","Normal"});

            csvwriteShop.writeAll(shopRows);
            csvwriteShop.close();
            System.out.println("Print generated!");
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        //Generate random visits
        try {
            CSVWriter csvWriteCheckin = new CSVWriter(new FileWriter("saves/records.csv")); 
            List<String[]> checkInRows = new LinkedList<String[]>();
            String[] names = {"Siti","Ricardo","Jonathan","Dio","Ghorno"};
            String[] shops = {"Walmart","7-Eleven","FamilyMart","Tesco","Sunway"};

            for(int i=1; i <= 30; i++) {
                
                //Generate time
                long num = (long)1609764011 - (long)(Math.random()*(86400-(0+1)+(0)));

                //Pick a name
                Random generate = new Random();
                
                int randomIndex = generate.nextInt(names.length);
                int randomIndex2 = generate.nextInt(shops.length);
                String name = names[randomIndex];
                String shop = shops[randomIndex2];

                checkInRows.add(new String[]{Integer.toString(i), name, Long.toString(num), shop});

            }
            csvWriteCheckin.writeAll(checkInRows);
            csvWriteCheckin.close();
        }
        
        catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("Random people ready to go!");

    }
}
