public class Customer {

    String name;
    Adress adress;
    Trip trip;

    public Customer(String name) {
        this.name = name;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }


    public void assignTrip(Trip trip) {
        this.trip = trip;
    }


    public void getInfo(){
        System.out.println(name);
        adress.getInfo();
        trip.getInfo();
        System.out.println();

    }
}
