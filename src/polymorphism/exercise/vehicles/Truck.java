package polymorphism.exercise.vehicles;

public class Truck extends Vehicles {

    private static  final double REDUCER = 1.6;
    private static final double REFUEL = 0.95;

    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + REDUCER);

    }
    @Override
    public void refuel(double fuel) {
        super.setFuelQuantity(super.getFuelQuantity() + (fuel * REFUEL));
    }


}
