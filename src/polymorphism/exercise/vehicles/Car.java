package polymorphism.exercise.vehicles;

public class Car extends Vehicles {


    private static final double REDUCER = 0.9;

    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + REDUCER);
    }


}
