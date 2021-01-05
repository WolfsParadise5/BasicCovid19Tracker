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

    public void DisplayCustomerDetails() {
        System.out.print("CUSTOMER LIST");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Name\t" + "Phone\t" + "Status");
        System.out.println("");
        System.out.println("-------------------------");
    }
    
    public void DisplayShopDetails() {
        System.out.print("SHOP LIST");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Name\t" + "Phone\t" + "Manager\t" + "Status");
        System.out.println("");
        System.out.println("-------------------------");
    }

    public void MasterVisitHistory() {
        System.out.print("MASTER VISIT HISTORY");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Date\t" + "Time\t" + "Customer\t" + "Shop");
        System.out.println("");
        System.out.println("-------------------------");
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
        
        //Gets the time to flag others
        try {
            CSVReader getTime = new CSVReader(new FileReader("records.csv"), ',');
            List<String[]> recordBody = getTime.readAll();
            Vector<Long> timeInfected = new Vector<Long>();
            long tempLong;

            for (int i=0; i < recordBody.size(); i++) {
                String[] lineArray = recordBody.get(i);
                for(int j=0; j < lineArray.length; j++) {
                    if(lineArray[j].equalsIgnoreCase(name)) {
                        tempLong = Long.parseLong(recordBody.get(i)[j+1]);
                        timeInfected.add(tempLong);
                    }
                }
            }
            //cross check all the times in vector with the records.csv
            Vector<String> peopleInfected = new Vector<String>();
            Vector<String> shopInfected = new Vector<String>();

            for(int i=0; i < timeInfected.size(); i++) {  //infected times

                //Get all the infected people and shops
                for(int j=0; j < recordBody.size(); j++) 
                {
                    String[] timeFind = recordBody.get(i);
                    for(int k=0; k < timeFind.length; k++) {
                        if (timeFind[k].equalsIgnoreCase(Long.toString(timeInfected.get(i)))) { //Incomplete if condition as not accounting range
                            peopleInfected.addElement(recordBody.get(j)[k-2]);
                            shopInfected.addElement(recordBody.get(j)[k+1]);
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
                            custCsvBody.get(j)[k+1] = "Case"; 
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
            
            for(int i=0; i < shopInfected.size(); i++) {
                
                for(int j=0; j < shopCsvBody.size(); j++) {
                    String[] strArray = shopCsvBody.get(j);
                    
                    for(int k=0; k<strArray.length; k++) {
                        
                        if (strArray[k].equalsIgnoreCase(shopInfected.get(i))) {
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

        

        //Flag the customers that walked in during said period


        //Flags the shops that kept their doors open
        

    }



}
