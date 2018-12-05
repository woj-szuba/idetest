public class Adress {

    String street;
    String zip;
    String city;

    public Adress(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public void getInfo(){
        System.out.println("Miasto: " + city);
        System.out.println("Ulica: " + street);
        System.out.println("Kod pocztowy: " + zip);
        System.out.println();

    }
}
