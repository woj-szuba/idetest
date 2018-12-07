public class Ship extends Vehicle implements Sailing {

    public Ship(String name) {
        super(name);
    }

    @Override
    public void dock() {
        System.out.println("Statek przybył do portu");
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
    void stop() {
        this.dock();
    }
}
