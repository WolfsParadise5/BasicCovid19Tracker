import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Vector;
//import java.util.LinkedList;
//import java.io.BufferedReader;

public class Admin extends Person {
    
    Admin() {}

    public void ChangeCustomerDetail() {
    
    }

    public void DisplayCustomerDetails(){
        System.out.println("CUSTOMER LIST");
        System.out.println("----------------------------------------");
        System.out.format("No\t" + "Name        " + "Phone\t" + "Status");
        System.out.println("");
        System.out.println("----------------------------------------");
        
        try {
            List<String[]> nameData = Functions.openCSVFile("saves/customer.csv");

            for(int i = 0; i < nameData.size(); i++) 
                System.out.println(nameData.get(i)[0] + "\t" + nameData.get(i)[2] + Functions.addSpace(nameData.get(i)[2]) + nameData.get(i)[1] + "\t" + nameData.get(i)[3]);
                //System.out.printf("%2d%11s%10d%7s%n",nameData.get(i)[0],nameData.get(i)[2],nameData.get(i)[1],nameData.get(i)[3]);
        }
    
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void DisplayShopDetails() {
        System.out.println("SHOP LIST");
        System.out.println("--------------------------------------------------");
        System.out.format("No\t" + "Name        " + "Phone\t" + "Manager     " + "Status");
        System.out.println("");
        System.out.println("--------------------------------------------------");

        try {
            List<String[]> nameData = Functions.openCSVFile("saves/shop.csv");

            for(int i = 0; i < nameData.size(); i++) 
                System.out.format(nameData.get(i)[0] + "\t" + nameData.get(i)[1] + Functions.addSpace(nameData.get(i)[1]) + nameData.get(i)[2] + "\t" + nameData.get(i)[3] + Functions.addSpace(nameData.get(i)[3]) + nameData.get(i)[4] + "\n");
        }
    
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MasterVisitHistory() {
        System.out.println("MASTER VISIT HISTORY");
        System.out.println("-------------------------------------------------------");
        System.out.format("No\t" + "Date            " + "Time        " + " Customer\t" + "Shop");
        System.out.println("");
        System.out.println("-------------------------------------------------------");

        try {
            List<String[]> nameData = Functions.openCSVFile("saves/records.csv");

            //Convert timestamp to date and time
            
            for(int i = 0; i < nameData.size(); i++)
                System.out.println(nameData.get(i)[0] + "\t" + Functions.getDate(nameData.get(i)[2]) + "\t" + Functions.getTime(nameData.get(i)[2]) + "     " + nameData.get(i)[1] + "\t" + nameData.get(i)[3]);
                
        }
    
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void changeToCase(String name) {
        //Find location went by customer
        File file = new File("saves/customer.csv");
        
        //Read existing file
        try {
            CSVReader reader = new CSVReader(new FileReader(file), ',');
            List<String[]> csvbody = reader.readAll();

            for(int i=0; i < csvbody.size(); i++) {
                String[] strArray = csvbody.get(i);
                for(int j=0; j<strArray.length; j++) {
                    if (strArray[j].equalsIgnoreCase(name)) {
                        csvbody.get(i)[j+1] = "Case"; 
                    }
                }
            }

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
        
        //Gets the time and shop by customer to flag others
        try {
            CSVReader getTime = new CSVReader(new FileReader("saves/records.csv"), ',');
            List<String[]> recordBody = getTime.readAll();
            Vector<Long> timeInfected = new Vector<Long>();
            Vector<String> shopByCust = new Vector<String>();
            long tempLong;
            String tempCustShop;

            for (int i=0; i < recordBody.size(); i++) {
                String[] lineArray = recordBody.get(i);
                for(int j=0; j < lineArray.length; j++) {
                    if(lineArray[j].equalsIgnoreCase(name)) {
                        tempLong = Long.parseLong(recordBody.get(i)[j+1]);
                        tempCustShop = recordBody.get(i)[j+2];
                        timeInfected.add(tempLong);
                        shopByCust.add(tempCustShop);

                        System.out.println("Time :" + tempLong);
                        System.out.println("Shop : " + shopByCust);
                    }
                }
            }
            //cross check all the times in vector with the records.csv
            Vector<String> peopleInfected = new Vector<String>();

            for(int i=0; i < timeInfected.size(); i++) {  //infected times

                //Get all the infected people and shops
                for(int j=0; j < recordBody.size(); j++) 
                {
                    String[] timeFind = recordBody.get(j);

                    for(int k=0; k < timeFind.length; k++) {
                        tempLong = Long.parseLong(timeFind[2]);
                        
                        for(int l=0; l < shopByCust.size(); l++) {

                            if (tempLong > timeInfected.get(i) & (tempLong - 3600) < timeInfected.get(i)) {
                                
                                String tempOneString = shopByCust.get(l);
                                String tempTwoString = recordBody.get(j)[3];

                                if (tempOneString.equals(tempTwoString)) { //prob
                                    peopleInfected.addElement(recordBody.get(j)[1]);
                                }
                            }

                            if (tempLong < timeInfected.get(i) & (tempLong + 3600) > timeInfected.get(i)) {

                                String tempOneString = shopByCust.get(l);
                                String tempTwoString = recordBody.get(j)[3];

                                if (tempOneString.equals(tempTwoString)) { //prob
                                    peopleInfected.addElement(recordBody.get(j)[1]);
                                }
                            }
                        }

                    }
                }
            }

            //Change people to case
            CSVReader Custreader = new CSVReader(new FileReader("saves/customer.csv"), ',');
            List<String[]> custCsvBody = Custreader.readAll();
            for(int i=0; i < peopleInfected.size(); i++) {
                
                for(int j=0; j < custCsvBody.size(); j++) {
                    String[] custStrArray = custCsvBody.get(j);
                    
                    for(int k=0; k<custStrArray.length; k++) {
                        
                        if (custStrArray[k].equalsIgnoreCase(peopleInfected.get(i))) {
                            custCsvBody.get(j)[k+1] = "Close"; 
                        }
                    }
                }
            }

            Custreader.close();

            FileWriter Custfi = new FileWriter("saves/customer.csv");
            CSVWriter Custwriter = new CSVWriter(Custfi,',');

            Custwriter.writeAll(custCsvBody);
            Custwriter.flush();
            Custwriter.close();

            //Change shops to case
            CSVReader Shopreader = new CSVReader(new FileReader("saves/shop.csv"), ',');
            List<String[]> shopCsvBody = Shopreader.readAll();
            
            for(int i=0; i < shopByCust.size(); i++) {
                
                for(int j=0; j < shopCsvBody.size(); j++) {
                    String[] strArray = shopCsvBody.get(j);
                    
                    for(int k=0; k<strArray.length; k++) {
                        
                        if (strArray[k].equalsIgnoreCase(shopByCust.get(i))) {
                            shopCsvBody.get(j)[k+3] = "Case"; 
                        }
                    }
                }
            }

            Shopreader.close();

            FileWriter Shopfi = new FileWriter("saves/shop.csv");
            CSVWriter Shopwriter = new CSVWriter(Shopfi,',');

            Shopwriter.writeAll(shopCsvBody);
            Shopwriter.flush();
            Shopwriter.close();



        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        

    }



}
