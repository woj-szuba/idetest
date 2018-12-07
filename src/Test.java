public class Test {

    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[5];
        Car car = new Car("Tesla");
        Plane plane = new Plane("F-16");
        RaceCar raceCar = new RaceCar("F1");
        Ship ship = new Ship("Macabeo");
        Truck truck = new Truck("Optimus Prime");
        vehicles[0] = car;
        vehicles[1] = plane;
        vehicles[2] = raceCar;
        vehicles[3] = ship;
        vehicles[4] = truck;

        for(int i = 0; i < vehicles.length; i++){
            vehicles[i].go();
            vehicles[i].stop();
            vehicles[i].calculateFuelConsumption(29999,140);
            if(vehicles[i] instanceof Flying) ((Flying) vehicles[i]).callAirControl();
        }

    }
}
