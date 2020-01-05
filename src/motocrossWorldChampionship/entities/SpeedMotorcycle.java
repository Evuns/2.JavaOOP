package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;

public class SpeedMotorcycle extends MotorcycleImpl {
    private static final double CUBIC_CENTIMETERS = 125;

    private double cubicCentimeters;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower);
        setCubicCentimeters();
    }
    @Override
    public void setHorsePower(int horsePower) {
        if (horsePower < 50 || horsePower > 69) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER,horsePower));
        }
        super.setHorsePower(horsePower);
    }

    private void setCubicCentimeters() {
        this.cubicCentimeters = CUBIC_CENTIMETERS;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.getCubicCentimeters() / this.getHorsePower() * laps;
    }
}
