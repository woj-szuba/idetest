import java.lang.reflect.Array;
import java.util.Arrays;

public class TravelOffice {

    Customer[] customersTab;

    static int customerCount;

    public TravelOffice() {
        this.customersTab = new Customer[2];
    }

    public void addCustomer(Customer customer){
        customerCount++;
        if(customerCount > customersTab.length){
            Customer[] newCustomerTab = new Customer[customersTab.length + 1];
            System.arraycopy(customersTab, 0, newCustomerTab, 0, customersTab.length);
            customersTab = newCustomerTab.clone();
            customersTab[customerCount-1] = customer;
        } else {
            customersTab[customerCount-1] = customer;
        }
    }
    public void getCustomerCount(){
        System.out.println("Liczba zapisanych klientów: " + customersTab.length);
    }


    public static void main(String args[]){
        Adress adress = new Adress("Piotrkowska" , "91-100" , "Lodz");
        Customer customer = new Customer("Wojciech Szuba");
        Trip trip = new Trip(new Date(2018,11,23), new Date(2018, 12, 04),
                "Karaiby");

        TravelOffice travelOffice = new TravelOffice();

        customer.assignTrip(trip);
        customer.setAdress(adress);
        customer.getInfo();
        travelOffice.addCustomer(customer);
        travelOffice.addCustomer(customer);
        travelOffice.addCustomer(customer);
        travelOffice.addCustomer(customer);
        travelOffice.getCustomerCount();
    }
}
