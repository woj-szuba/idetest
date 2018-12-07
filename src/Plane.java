public class Plane extends Vehicle implements Flying {
    public Plane(String name) {
        super(name);
    }

    @Override
    public void TakeOff() {
        System.out.println("Samolot startuje");
    }

    @Override
    public void land() {
        System.out.println("Samolot wylądował");
    }

    @Override
    public void callAirControl() {
        System.out.println("Samolot wzywa kontrolę lotu");
    }

    @Override
    double getFuelNeeds(double fuelNeeded) {
        return fuelNeeded;
    }

    @Override
    double getDistance(double distance) {
        return distance;
    }

    @Override
    void go() {
        this.TakeOff();
    }

    @Override
    void stop() {
        this.land();
    }
}
