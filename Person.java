public class Person {
    
    String name;
    int phone;
    String[] statuslist = {"Normal", "Case", "Close"};
    String status;

    Person(String name,int phone) {
        this.name = name;
        this.phone = phone;
        this.status = statuslist[2];
    }
    
    Person(String name,int phone, String status) {
        this.name = name;
        this.phone = phone;
        this.status = status;
    }


}
