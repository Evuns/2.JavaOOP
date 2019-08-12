package interfacesAbstraction.exercise.militaryElite.soldiers;

import interfacesAbstraction.exercise.militaryElite.enums.Corps;
import interfacesAbstraction.exercise.militaryElite.interfaces.Engineer;
import interfacesAbstraction.exercise.militaryElite.interfaces.Repair;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new HashSet<>();
    }

    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    public Collection<Repair>getRepairs(){
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());

        for (Repair repair : this.repairs) {
            sb.append("  ")
                    .append(repair.toString())
                    .append(System.lineSeparator());
            
        }
        return sb.toString().trim();
    }
}
