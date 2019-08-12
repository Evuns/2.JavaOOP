package interfacesAbstraction.exercise.militaryElite.soldiers;

import interfacesAbstraction.exercise.militaryElite.tasks.PrivateImpl;
import interfacesAbstraction.exercise.militaryElite.interfaces.LieutenantGeneral;
import interfacesAbstraction.exercise.militaryElite.interfaces.Private;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Set<Private> privateImplUnderCommand;

    public LieutenantGeneralImpl(int id, String firstName, String lastName,
                                 double salary) {
        super(id, firstName, lastName, salary);
        this.privateImplUnderCommand = new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private o1, Private o2) {
                return o2.getId() - o1.getId();
            }
        });
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privateImplUnderCommand.add(soldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        for (Private soldier : this.privateImplUnderCommand) {
            sb.append("  ")
                    .append(soldier.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
