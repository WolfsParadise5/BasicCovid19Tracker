public class Shop extends Person {
    
    private String manager;

    Shop() {}
    
    Shop(String manager, String name, String status, int phone) {
        super(name, phone, status);
        this.manager = manager;
    }

    public void checkStatus() {
        //Get status from JSON
    }
}
