package motocrossWorldChampionship.entities;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderImpl implements Rider {

    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        setName(name);
        this.canParticipate = false;
        this.numberOfWins = 0;
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() < 5) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME,name,5));
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null) {
            throw new NullPointerException(ExceptionMessages.MOTORCYCLE_INVALID);
        }
        this.motorcycle = motorcycle;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins += 1;

    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
