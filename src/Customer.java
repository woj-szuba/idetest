public class Customer {

    private String name;
    private Adress adress;
    private Trip trip;

    public Customer(String name) {
        this.name = name;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }


    public void assignTrip(Trip trip) {
        this.trip = trip;
    }


    public String toString(){
        System.out.println(name);
        adress.toString();
        trip.toString();
        System.out.println();
        return null;
    }
}
