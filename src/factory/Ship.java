package factory;

public class Ship implements Vehilce {
    public Ship() {
    }

    @Override
    public void start() {
        System.out.println("Statek rozpoczął rejs");
    }
}
