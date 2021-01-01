public class Admin extends Person {
    
    Admin() {}

    public void ChangeCustomerDetail() {
    
    }

    public void DisplayCustomerDetails() {
        System.out.print("CUSTOMER LIST");
        System.out.println("-------------------------");
        System.out.format("No\t" + "Name\t" + "Phone\t" + "Status");
        System.out.println("");
        System.out.println("-------------------------")
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
    
    
    public void changeToCase() {
        //Flags the customer
        
            //Find location went by customer

            //Get the time


        //Flags the other customer in one hour radius



        //Flags the shops that kept their doors open
        

    }



}
