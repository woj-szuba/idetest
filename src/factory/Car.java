package factory;

public class Car implements Vehilce {
    public Car() {
    }

    @Override
    public void start() {
        System.out.println("Auto wystartowało");
    }
}
