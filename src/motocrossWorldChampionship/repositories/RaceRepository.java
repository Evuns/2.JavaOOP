package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RaceRepository implements Repository {

    private Collection<RaceImpl> races;


    public RaceRepository() {
        this.races = new ArrayList<>();
    }

    @Override
    public RaceImpl getByName(String name) {
        if (races.isEmpty()) {
            return null;
        }
        for (RaceImpl race : races) {
            if (race.getName().equals(name)) {
                return race;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(races);
    }

    @Override
    public void add(Object model) {
        races.add((RaceImpl) model);
    }

    @Override
    public boolean remove(Object model) {
        if(races.contains(model)){
            races.remove(model);
            return true;
        }
        return false;
    }
}
