public class CustomerTab {

    Customer[] customersTab;

    static int customerCount;


    public CustomerTab() {
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


}
