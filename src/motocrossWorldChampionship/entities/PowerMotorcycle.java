package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;


public class PowerMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 450;

    private double cubicCentimeters;

    public PowerMotorcycle(String model, int horsePower) {
        super(model, horsePower);
        setCubicCentimeters();
    }

    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 70 || horsePower > 100) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }
        super.setHorsePower(horsePower);
    }


    public void setCubicCentimeters() {
       this.cubicCentimeters = CUBIC_CENTIMETERS;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / super.getHorsePower() * laps;
    }
}
