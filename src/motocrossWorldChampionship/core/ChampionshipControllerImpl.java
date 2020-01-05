package motocrossWorldChampionship.core;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.common.OutputMessages;
import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.*;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChampionshipControllerImpl implements ChampionshipController {

    private RiderRepository riders;
    private MotorcycleRepository motorcycles;
    private RaceRepository races;

    public ChampionshipControllerImpl() {
        this.riders = new RiderRepository();
        this.motorcycles = new MotorcycleRepository();
        this.races = new RaceRepository();
    }

    @Override
    public String createRider(String riderName) {
        Rider rider = new RiderImpl(riderName);
        if (riders.getByName(riderName) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_EXISTS, riderName));
        }
        riders.add(rider);
        return String.format(OutputMessages.RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        MotorcycleImpl motorcycle;
        if (type.equalsIgnoreCase("Speed")) {
            motorcycle = new SpeedMotorcycle(model, horsePower);
        } else {
            motorcycle = new PowerMotorcycle(model, horsePower);
        }
        if (motorcycles.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.MOTORCYCLE_EXISTS, model));
        }
        motorcycles.add(motorcycle);
        String typePrint = type.concat("Motorcycle");
        return String.format(OutputMessages.MOTORCYCLE_CREATED, typePrint, model);
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        if (riders.getByName(riderName) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND, riderName));
        }
        if (motorcycles.getByName(motorcycleModel) == null) {
            throw new NullPointerException(String.format(ExceptionMessages.MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }
        riders.getByName(riderName).addMotorcycle(motorcycles.getByName(motorcycleModel));
        return String.format(OutputMessages.MOTORCYCLE_ADDED,riderName,motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        if(races.getByName(raceName) == null){
            throw new NullPointerException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }
        if(riders.getByName(riderName) == null){
            throw new NullPointerException(String.format(ExceptionMessages.RIDER_NOT_FOUND,riderName));
        }
        if(races.getByName(raceName).getRiders().contains(riders.getByName(riderName))){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RIDER_ALREADY_ADDED,riderName));
        }
        races.getByName(raceName).addRider(riders.getByName(riderName));
        return String.format(OutputMessages.RIDER_ADDED,riderName,raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        RaceImpl race  = new RaceImpl(name,laps);
        if(races.getByName(name) != null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS,name));
        }
        races.add(race);
        return String.format(OutputMessages.RACE_CREATED,name);
    }

    @Override
    public String startRace(String raceName) {
        if(races.getByName(raceName) == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }
        if(races.getByName(raceName).getRiders().size() < 3){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID,raceName, 3));
        }

        RaceImpl currentRace = races.getByName(raceName);
        Collection <Rider> participatingRiders = currentRace.getRiders();
        List<Rider> sorted = participatingRiders.stream().sorted(Comparator.comparingDouble(
                a -> a.getMotorcycle().calculateRacePoints(currentRace.getLaps()))).collect(Collectors.toList());

        sorted.get(0).winRace();

        return String.format(OutputMessages.RIDER_FIRST_POSITION,sorted.get(0).getName(),raceName) +
                System.lineSeparator() +
                String.format(OutputMessages.RIDER_SECOND_POSITION,sorted.get(1).getName(),raceName) +
                System.lineSeparator() +
                String.format(OutputMessages.RIDER_THIRD_POSITION,sorted.get(2).getName(),raceName);
    }

}
