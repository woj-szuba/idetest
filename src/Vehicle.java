abstract public class Vehicle {
    String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

    abstract double getFuelNeeds(double fuelNeeded);
    abstract double getDistance(double distance);

    public double calculateFuelConsumption(double fuelNeeded, double distance){
        return fuelNeeded / distance;
    }

    void go(){
        System.out.println("Typ uruchomionego pojazdu: " + this.getClass().getSimpleName()
                + "\n Nazwa pojazdu: " + name);
    }

    void stop(){
        System.out.println("Typ zatrzymanego pojazdu: " + this.getClass().getSimpleName()
                + "\n Nazwa pojazdu: " + name);
    }
}
