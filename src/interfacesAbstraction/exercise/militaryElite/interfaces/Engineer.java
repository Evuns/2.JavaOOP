package interfacesAbstraction.exercise.militaryElite.interfaces;

import java.util.Collection;

public interface Engineer {

    void addRepair(Repair repair);
    Collection<Repair> getRepairs();

}
