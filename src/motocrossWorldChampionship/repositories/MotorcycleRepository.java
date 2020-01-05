package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.MotorcycleImpl;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MotorcycleRepository extends RepositoryImpl {

    private Collection<MotorcycleImpl> motorcycles;

   public MotorcycleRepository() {
        this.motorcycles = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        if (motorcycles.isEmpty()) {
            return null;
        }
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getModel().equals(name)) {
                return motorcycle;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableCollection(motorcycles);
    }

    @Override
    public void add(Object model) {
        motorcycles.add((MotorcycleImpl) model);
    }

    @Override
    public boolean remove(Object model) {
        if(motorcycles.contains(model)){
            motorcycles.remove(model);
            return true;
        }
        return false;
    }
}
