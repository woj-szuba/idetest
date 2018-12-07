public class RaceCar extends Car {
    public RaceCar(String name) {
        super(name);
    }

    @Override
    double getFuelNeeds(double fuelNeeded) {
        return fuelNeeded;
    }
}
