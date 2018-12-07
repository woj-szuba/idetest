public class Car extends Vehicle {

    public Car(String name) {
        super(name);
    }

    @Override
    double getFuelNeeds(double fuelNeeded) {
        return fuelNeeded;
    }

    @Override
    double getDistance(double distance) {
        return distance;
    }
}
