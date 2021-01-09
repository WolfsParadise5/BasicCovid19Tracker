/**
 * Person represents customers' data such as their
 * name, phone and status. This class were extended
 * to Customer and Admin to let these programs to
 * get data easily
 * @author Fong
 */
public class Person {

    private String name;
    private String phone;
    private String[] statuslist = {"Normal", "Case", "Close"};
    private String status;

    Person() {}
    /**
     * This method constructs a customer with a specified name and phone
     * @param name - The name value of Customer
     * @param phone - The status value of Customer
     */
    Person(String name,String phone) {
        this.name = name;
        this.phone = phone;
        this.status = statuslist[0];
    }
    
    /**
     * This method constructs a customer with a specified name, phone and status
     * @param name - The name value of Customer
     * @param phone - The phone value of Phone
     * @param status - The status value of Status
     */
    Person(String name,String phone, String status) {
        this.name = name;
        this.phone = phone;
        this.status = status;
    }

    /**
     * Return the name from the specified customer
     * @return - name in Customer
     */
    public String getName(){
        return name;
    }

    /**
     * Return the phone from the specified customer
     * @return - phone in Customer
     */
    public String getPhone(){
        return phone;
    }

    /**
     * Return the status from the specified customer
     * @return - status in Customer
     */
    public String getStatus(){
        return status;
    }
  
}
