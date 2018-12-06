import java.lang.reflect.Array;
import java.util.Arrays;

public class TravelOffice {

    public static void main(String args[]){
        Adress adress = new Adress("Piotrkowska" , "91-100" , "Lodz");
        Customer customer = new Customer("Wojciech Szuba");
        Trip trip = new Trip(new Date(2018,11,23), new Date(2018, 12, 04),
                "Karaiby");

        CustomerTab customerTab = new CustomerTab();

        customer.assignTrip(trip);
        customer.setAdress(adress);
        customer.getInfo();
        customerTab.addCustomer(customer);
        customerTab.addCustomer(customer);
        customerTab.addCustomer(customer);
        customerTab.addCustomer(customer);
        customerTab.getCustomerCount();
    }
}
