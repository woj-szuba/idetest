public class Trip {

    Date start;
    Date end;
    String destination;


    public Trip(Date start, Date end, String destination) {
        this.start = start;
        this.end = end;
        this.destination = destination;
    }

    public void getInfo(){
        System.out.println("Cel podróży: " + destination);
        System.out.print("Data przyjazdu: ");
        start.getInfo();
        System.out.print("Data wyjazdu: ");
        end.getInfo();
        System.out.println();

    }
}
