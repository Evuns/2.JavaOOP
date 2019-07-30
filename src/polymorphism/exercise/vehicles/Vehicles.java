package polymorphism.exercise.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicles implements Driving, Refueling {
    private double fuelQuantity;
    private double fuelConsumption;
    DecimalFormat df = new DecimalFormat("#.##");


    protected Vehicles(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;

    }
    public double getFuelQuantity() {
        return fuelQuantity;
    }
    public double getFuelConsumption(){
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }


    @Override
    public void refuel(double liters) {
        setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String driving(double distance, String vehicle) {
        double usedFuel = this.getFuelConsumption() * distance;
        if (usedFuel <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - usedFuel);
            String format = "%s travelled %s km";
            return String.format(format,vehicle, df.format(distance));
        } else {
            return String.format("%s needs refueling", vehicle);
        }
    }
}
