package factory;

public class Plane implements Vehilce {
    public Plane() {
    }

    @Override
    public void start() {
        System.out.println("Samolot wystartował");
    }
}
