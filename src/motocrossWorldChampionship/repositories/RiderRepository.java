package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class RiderRepository implements Repository {

    private Collection<Rider> riders;

    public RiderRepository() {
        this.riders = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        if (riders.isEmpty()) {
            return null;
        }
        for (Rider rider : riders) {
            if (rider.getName().equals(name)) {
                return rider;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(riders);
    }

    @Override
    public void add(Object model) {
            riders.add((Rider)model);
    }

    @Override
    public boolean remove(Object model) {
        if (riders.contains(model)) {
            riders.remove(model);
            return true;
        }
        return false;
    }
}
